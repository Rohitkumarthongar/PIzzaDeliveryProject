import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  
  loginUser(data:any)
  {
    alert("Login Process");
    return this.http.get<any>("http://localhost:9000/api/pizza/Auth/login",data);
  }
}
