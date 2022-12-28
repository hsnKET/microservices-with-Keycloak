import { Component, OnInit } from '@angular/core';
import {Order} from "../../modules/order";
import {OrderService} from "../../services/order.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductItem, ProductItemResponse} from "../../modules/product-item";
import {ProductItemsService} from "../../services/product-items.service";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  public errorMessage!:string
  public productItemResponse!:ProductItemResponse
  private pageSize:number = 10;
  private orderId!:number;
  public totalPrice:number = 0;
  constructor(private productDetailService:ProductItemsService,
              private router:Router,private route:ActivatedRoute) {
    this.orderId = route.snapshot.params['orderId'];
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(page:number=0){
    this.productDetailService.allProductItems(this.orderId)
      .subscribe({
        next:data => {
          this.productItemResponse = data;
          this.total();
        },
        error:err => {
          this.errorMessage = err.message
        }
      })
  }

  private total(){
    this.productItemResponse.productItems
      .forEach(pi =>{
        this.totalPrice += (pi.quantity * (pi.price - (pi.price*pi.discount/100)))
      });
  }

}
