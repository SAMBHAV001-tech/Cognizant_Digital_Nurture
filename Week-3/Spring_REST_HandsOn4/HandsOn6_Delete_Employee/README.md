# Hands-on 6 – Delete Employee REST Service

This hands-on demonstrates creating a deletion endpoint using HTTP DELETE to delete an employee resource by ID from the in-memory list, and throwing `EmployeeNotFoundException` if the ID is invalid.

## Concepts
- `@DeleteMapping` maps HTTP DELETE requests to handler methods.
- Path variables are extracted using `@PathVariable`.
