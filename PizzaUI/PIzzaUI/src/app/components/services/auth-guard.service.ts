import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {
  isLogged:boolean=false;
  redirectUrl:String='';
  isUserAdmin:boolean=false;

  constructor() { }

  userLogin(code:String)
  {
    this.isLogged=true;
        // this.isUserAdmin=code.startsWith("Pizza");
  }
}
