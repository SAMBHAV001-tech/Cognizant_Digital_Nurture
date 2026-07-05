Exercise 6 – Pagination and Sorting

What is Pagination and Sorting in Spring Data JPA
When loading large datasets from the database, querying all database records at once is inefficient. Spring Data JPA provides native support for retrieving data in chunks (pagination) and arranging the query results in specific orders (sorting):
- Pageable: Interface that wraps page number, page size, and Sort properties. Custom instances are constructed using PageRequest.of(page, size, Sort).
- Page: Container mapping the current page's content along with pagination metadata (total records, current page number, total pages).
- Sort: Defines field-level sorting directions (ascending/descending).
