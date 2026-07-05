Exercise 4 – CRUD Operations

RESTful APIs with Spring Boot
REST (Representational State Transfer) controllers expose standard endpoints allowing client applications to perform CRUD (Create, Read, Update, Delete) operations over HTTP:
- @RestController: Combines @Controller and @ResponseBody, automatically serializing return values to JSON.
- @RequestMapping: Specifies baseUrl mapping.
- Endpoints Mapper annotations:
  - @GetMapping: Maps HTTP GET requests (retrieval).
  - @PostMapping: Maps HTTP POST requests (creation).
  - @PutMapping: Maps HTTP PUT requests (updates).
  - @DeleteMapping: Maps HTTP DELETE requests (deletions).
