Hands-on 2 – Hibernate XML Configuration

What is XML-Based Mapping in Hibernate
In XML-based mapping, we use a separate XML file (usually with extension .hbm.xml) to map a Java class to a database table. In this project, Book.hbm.xml specifies that:
- The class com.hibernate.xml.model.Book maps to table book.
- The property id maps to primary key column book_id, using an increment generator.
- Properties title, author, and price map to columns title, author, and price respectively.

What is the Hibernate Configuration File
hibernate.cfg.xml contains database connection settings (driver class, connection URL, username, password), SQL dialect configuration (like H2Dialect), and the show_sql setting to print executed statements. It also registers mapping resources (.hbm.xml files) to inform Hibernate of mapped entity classes.

Hibernate Workflow
1. Configuration: Load configuration metadata from hibernate.cfg.xml.
2. SessionFactory: Create a heavy-weight thread-safe SessionFactory object.
3. Session: Open a light-weight Session object representing a single database connection.
4. Transaction: Start a database transaction.
5. Operation: Execute operations (save, get, update, delete, or queries).
6. Commit/Rollback: Commit the transaction to save changes, or rollback if an error occurs.
7. Close: Close Session and SessionFactory to release resources.
