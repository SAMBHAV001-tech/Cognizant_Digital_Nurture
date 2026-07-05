Exercise 10 – Hibernate Features

What is Batch Processing in Hibernate
By default, Hibernate executes database insert and update queries individually. For bulk operations (like inserting thousands of rows), this leads to high network traffic and latency. Batch processing configures Hibernate to group SQL insert/update operations into packages (batches) and send them to the database in a single network roundtrip.

Hibernate Features Configuration
- DynamicInsert & DynamicUpdate: Entity annotations telling Hibernate to dynamically construct SQL queries containing only non-null or modified columns. This reduces column processing overhead in SQL parsing.
- BatchSize: Restricts collection loading to run in chunks (batches), solving N+1 loading issues on lazy associations.
- JDBC Batch Configuration properties:
  - spring.jpa.properties.hibernate.jdbc.batch_size=20: Instructs Hibernate to send SQL statements in batches of 20.
  - spring.jpa.properties.hibernate.order_inserts=true: Groups statements sequentially to maximize batch efficiency.
