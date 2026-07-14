# Hands-on 5 – Update Employee REST Service

This hands-on demonstrates creating an update endpoint using HTTP PUT to update an employee's details in-memory, including validation rules and throwing a custom `EmployeeNotFoundException` if the target employee is not found.

## Concepts
- `@PutMapping` annotations map PUT requests to handlers.
- Validation annotations are applied transitively using `@Valid` on nested objects.
- Custom exceptions like `EmployeeNotFoundException` annotated with `@ResponseStatus` automatically return standard status codes like `404 Not Found`.
