Hands-on 3 – Fetch Quiz Attempt Details using HQL

What is Complex Entity Graph Fetching in HQL
When working with database entities with multiple nested relationships (for example, Attempt -> AttemptQuestion -> Question -> Options, and AttemptQuestion -> AttemptOption -> Options), standard fetching strategies trigger dozens of individual database queries, causing severe performance issues.

How to Fetch Nested Graph in a Single Database Call
We can use HQL FETCH JOIN on multiple levels of relationships to load the entire graph of associated entities in one or two queries.
The query implemented inside AttemptRepository:
"select distinct a from Attempt a left join fetch a.attemptQuestions aq left join fetch aq.question q left join fetch q.optionsList o left join fetch aq.attemptOptions ao left join fetch ao.options where a.user.id = :userId and a.id = :attemptId"
allows us to retrieve the complete Attempt record and navigate all its children dynamically without triggering any lazy loading exceptions or database roundtrips.
