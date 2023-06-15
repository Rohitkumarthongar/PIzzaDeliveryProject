import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }

  addToCart(data:any){
    this.http.post<any>("http://localhost:9000/api/pizza/service/{{userEmailId}}/pizza",data);
  }

  getCArt(){
    this.http.get<any>("http://localhost:9000/api/pizza/service/{{userEmailId}}");
  }
}
