import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  constructor(private http:HttpClient) { }

  signUpUser(data:any)
  {
    return this.http.post("http://localhost:9000/api/pizza/Auth/saveUser",data);

  }
}
