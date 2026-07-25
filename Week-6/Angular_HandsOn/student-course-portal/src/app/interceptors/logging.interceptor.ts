import { HttpInterceptorFn } from '@angular/common/http';
import { tap } from 'rxjs';

export const loggingInterceptor: HttpInterceptorFn = (req, next) => {
  const started = Date.now();
  return next(req).pipe(
    tap({
      next: (event) => {
        const elapsed = Date.now() - started;
      },
      error: (error) => {
        const elapsed = Date.now() - started;
      }
    })
  );
};
