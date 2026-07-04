Hands-on 6 – Many-to-Many Relationship

What is a Many-to-Many Relationship in JPA
A Many-to-Many relationship indicates that multiple records of an entity are linked to multiple records of another entity. For example, an Employee can possess multiple Skill records, and a Skill can be possessed by multiple Employee records.

JPA Configuration
- @ManyToMany: Used to declare the relationship mapping.
- @JoinTable: Used to specify the join table name and column mappings since many-to-many associations require a linking table in a relational database schema.
- joinColumns: Defines foreign keys linking the join table to the owner entity (employee table). In this project, joinColumns = @JoinColumn(name = "es_em_id").
- inverseJoinColumns: Defines foreign keys linking the join table to the target entity (skill table). In this project, inverseJoinColumns = @JoinColumn(name = "es_sk_id").
- Eager fetching: Used FetchType.EAGER to ensure associated skills are loaded from the join table automatically during entity fetching, avoiding LazyInitializationException outside transactional boundaries.
