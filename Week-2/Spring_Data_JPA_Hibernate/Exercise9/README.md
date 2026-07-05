Exercise 9 – Data Source Configuration

What is Multiple Datasource Configuration in Spring Boot
By default, Spring Boot auto-configures a single DataSource and EntityManagerFactory. When an application needs to connect to multiple database engines or separate database schemas, we must disable default auto-configuration and configure individual DataSource beans explicitly.

JPA Configuration Steps
- Exclude DataSourceAutoConfiguration.class: Tells Spring Boot not to trigger default single datasource autoconfiguration.
- Configure @Bean definitions: Expose separate DataSource, LocalContainerEntityManagerFactoryBean, and PlatformTransactionManager beans for each database.
- EnableJpaRepositories configuration: Bind specific package hierarchies to their respective EntityManagerFactory and transaction managers (for example, basePackages = "com.example.repository.primary" binds to primaryEntityManagerFactory).
