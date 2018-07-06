package com.pagination.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class DaoConfig {
	@Value("${jdbc.driverClass}") private String driverClass;
	@Value("${jdbc.connectionUrl}") private String connectionUrl;
	@Value("${jdbc.username}") private String username;
	@Value("${jdbc.password}") private String password;
	
	@Value("${hibernate.dialect}") private String dialect;
	@Value("${hibernate.show_sql}") private String showSql;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(connectionUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory session) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(session);
		return transactionManager;
	}
	
	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory session) {
		HibernateTemplate template =new HibernateTemplate();
		template.setSessionFactory(session);
		return template;
	}
	@Bean
	public LocalSessionFactoryBean getBeanFactory() {
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setHibernateProperties(getHibernateProperties());
		bean.setPackagesToScan(new String[] {"com.pagination"});
		return bean;	
	}
	@Bean
	public Properties getHibernateProperties() {
		Properties properties=new Properties();
		
		properties.setProperty("hibernate.dialect", dialect);
		properties.setProperty("hibernate.show_sql", showSql);

		return properties;
		
	}
}
