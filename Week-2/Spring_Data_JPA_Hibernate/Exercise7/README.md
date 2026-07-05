Exercise 7 – Entity Auditing

What is Entity Auditing in Spring Data JPA
In production databases, it is critical to track when records are created or modified, and by whom. Spring Data JPA provides auditing infrastructure to automate these actions:
- @EnableJpaAuditing: Configuration annotation that enables auditing features.
- AuditingEntityListener: JPA Entity Listener class that handles mapping auditing events (pre-persist, pre-update) automatically.
- Auditing Annotations:
  - @CreatedBy: Populates the user who created the record.
  - @CreatedDate: Populates the date and time when the record was persisted.
  - @LastModifiedBy: Populates the user who last updated the record.
  - @LastModifiedDate: Populates the date and time when the record was updated.
- AuditorAware: Spring interface to fetch the current application auditor (e.g. current logged-in user).
