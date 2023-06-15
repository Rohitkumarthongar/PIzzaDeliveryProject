import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PIZZA_DATA } from '../local Storage/PIzzaStore';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public showCart:any;
 
  constructor() { }
  ngOnInit(): void {
  }
// showCART(){
//   this.
// }
}
