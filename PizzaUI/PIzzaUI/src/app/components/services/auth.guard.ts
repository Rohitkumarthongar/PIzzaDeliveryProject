import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthGuardService } from './auth-guard.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  
  

  constructor(private authService:AuthGuardService,private route:Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return this.checkLogin(state.url);
    // return true;
  }
  checkLogin(url:String){
    if(this.authService.isLogged)
{
  this.authService.redirectUrl=url; 
   return this.authService.isLogged;
  
}return this.route.navigateByUrl('/login')
}
  
}
