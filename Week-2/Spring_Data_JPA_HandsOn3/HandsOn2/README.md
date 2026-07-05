Hands-on 2 – Get Permanent Employees using HQL

What is the N+1 Selects Problem in ORM
When loading entities with associated child collections or associations mapped as FetchType.LAZY, accessing each child association triggers a separate SQL query. For N parent records, this causes 1 initial query followed by N subsequent child queries (total N+1 select queries), leading to performance degradation.

How to Optimize Queries using JOIN FETCH
We can use HQL JOIN FETCH (or FETCH JOIN) to instruct the ORM provider (Hibernate) to fetch associated relationships (such as @ManyToOne or @ManyToMany associations) in the same database select query using an inner join or left join.
For example, the HQL query:
"select distinct e from Employee e join fetch e.department left join fetch e.skillList where e.permanent = true"
loads each matching Employee along with their Department and Skill list in a single database roundtrip, completely avoiding the N+1 selects problem.
