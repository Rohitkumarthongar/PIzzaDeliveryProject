import { Component, OnInit } from '@angular/core';
import { CART_DATA } from '../local Storage/cartData';
import { PIZZA_DATA } from '../local Storage/PIzzaStore';
import { PIzza } from '../model/pizza';
import { CartService } from '../services/cart.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  

   public PizzaStoreCollection:any=PIZZA_DATA;
   public pizzaCart:any=CART_DATA;
   addPizza:PIzza=new PIzza;
  constructor(private cart:CartService) { }
 

  ngOnInit(): void {
   
  }
 addTocart(addPizza:any)
 {
  this.cart.addToCart(addPizza);
 }
  
}
