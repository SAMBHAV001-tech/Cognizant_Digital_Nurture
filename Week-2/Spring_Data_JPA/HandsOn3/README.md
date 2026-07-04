Hands-on 3 – Hibernate Annotation Configuration

What is Annotation-Based Configuration in Hibernate
Annotation-based configuration allows mapping database tables directly inside Java entity classes using JPA standard annotations. This eliminates the need for separate .hbm.xml files, making the project structure cleaner and easier to maintain.

Key Mapping Annotations
- @Entity: Declares that the Java class is a JPA entity mapped to a database table.
- @Table: Specifies the name of the database table (e.g., name = "book").
- @Id: Specifies the primary key of the entity.
- @GeneratedValue: Defines the strategy for primary key generation. GenerationType.IDENTITY instructs the database to auto-increment the ID (like auto_increment in MySQL or identity in H2).
- @Column: Specifies the database column attributes (name, length, nullable, etc.) mapped to the class field.

How to Configure Annotations
In hibernate.cfg.xml, instead of registering mapping resources, we register annotated classes using:
<mapping class="com.hibernate.annotation.model.Book"/>
This informs the SessionFactory to read annotations from the Book class.
