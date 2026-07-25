# Week 6: Angular Hands-On Assignments

Single incremental Angular application (`student-course-portal`) implementing all 10 Angular Hands-On exercises.

## Application Architecture

- **Project Name**: `student-course-portal`
- **Framework**: Angular 21 (Zoneless, Standalone Components, TypeScript, RxJS)
- **Styling**: Custom CSS Slate Dark Design System

---

## Summary of Completed Hands-Ons

### Hands-On 1: Basic Setup & Initial Components
- Initialized `student-course-portal` Angular application using Angular CLI.
- Created `HeaderComponent`, `FooterComponent`, `StudentListComponent`, and `CourseListComponent`.
- Established initial layout and component structure.

### Hands-On 2: Data Binding, Lifecycle Hooks & Component Communication
- Implemented String Interpolation, Property Binding (`[src]`, `[ngClass]`, `[ngStyle]`), Event Binding (`(click)`), and Two-Way Data Binding (`[(ngModel)]`).
- Lifecycle hooks implemented: `ngOnInit`, `ngOnChanges`, and `ngOnDestroy` in `StudentCardComponent`.
- Parent-Child component communication using `@Input()` and `@Output()` with `EventEmitter`.

### Hands-On 3: Directives & Pipes
- Structural directives (`*ngIf` / `@if`, `*ngFor` / `@for`).
- Attribute directives (`ngClass`, `ngStyle`).
- Custom Directive: `HighlightDirective` (`appHighlight`) with `@HostListener('mouseenter')` & `@HostListener('mouseleave')`.
- Built-in Pipes: `uppercase`, `lowercase`, `date`, `currency`.
- Custom Pipe: `SearchFilterPipe` (`searchFilter`) for real-time list search filtering.

### Hands-On 4: Template-Driven Forms
- Created `StudentRegisterComponent` using `#registerForm="ngForm"`.
- Validations: `required`, `email`, `minlength`.
- Dynamic validation error messages display when inputs are dirty/touched.
- Form submission handling and redirect logic.

### Hands-On 5: Reactive Forms
- Created `CourseCreateComponent` using `FormBuilder`, `FormGroup`, `FormControl`, and `FormArray`.
- Dynamic `FormArray` controls for adding/removing course prerequisites.
- Custom Validator: `feeRangeValidator` ensuring fees stay between ₹1,000 and ₹50,000.
- Async Validator: `codeAsyncValidator` checking for duplicate course codes.

### Hands-On 6: Services, Dependency Injection & RxJS Basics
- Models defined: `Student` interface and `Course` interface.
- Services implemented: `StudentService`, `CourseService`, and `PortalStateService` (`@Injectable({ providedIn: 'root' })`).
- Shared state management service using RxJS `BehaviorSubject` for header badges.

### Hands-On 7: Routing, Guards, Lazy Loading & 404
- Configured Angular Router (`app.routes.ts`) for `/students`, `/courses`, `/courses/:id`, `/register`, `/create-course`, `/admin`, and `**`.
- Route parameters handled via `ActivatedRoute` (`paramMap`) in `CourseDetailComponent`.
- Protected routes using functional `CanActivate` guard (`AuthGuard`).
- Implemented `PageNotFoundComponent` for 404 URL paths.

### Hands-On 8: HttpClient, RxJS & Interceptors
- Configured `HttpClient` using `provideHttpClient(withInterceptors([loggingInterceptor]))`.
- RxJS operators used: `map`, `tap`, `of`, `delay`, `firstValueFrom`.
- Functional HTTP Interceptor `loggingInterceptor` logging HTTP request timing.

### Hands-On 9: State Management (NgRx Principles)
- Centralized reactive state management in `CourseService` and `PortalStateService` using RxJS observables and state subjects.
- State mutation methods and selectors for `selectedStudent$` and `totalEnrolled$`.

### Hands-On 10: Unit Testing (Jasmine / Vitest)
- Written test specs (`.spec.ts`) for components, services, and pipes:
  - `search-filter.pipe.spec.ts`
  - `student.service.spec.ts`
  - `student-card.component.spec.ts`
  - `header.component.spec.ts`
  - `app.spec.ts`
- Verified all 11 unit tests pass cleanly using `npx ng test --watch=false`.
