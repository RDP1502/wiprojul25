import { HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('tokenValue');
    
    if (token!=null && token !== '') {
      const authReq = req.clone({
        headers: req.headers.set('Authorization', `${token}`)
      });
      return next.handle(authReq);
    }
    
    return next.handle(req);
  }
}
