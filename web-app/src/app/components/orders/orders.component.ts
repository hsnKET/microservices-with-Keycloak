import { Component, OnInit } from '@angular/core';
import {Customer} from "../../modules/customer";
import {CustomerService} from "../../services/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Order} from "../../modules/order";
import {OrderService} from "../../services/order.service";
import {ProductItem} from "../../modules/product-item";
import {Page} from "../../modules/page";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  public errorMessage!:string
  public orders!:Order[]
  private pageSize:number = 10;
  private customerId!:number;
  constructor(private orderService:OrderService,
              private router:Router,private route:ActivatedRoute) {
    this.customerId = route.snapshot.params['customerId'];
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(page:number=0){
    this.orderService.allOrders(this.customerId,this.pageSize,page)
      .subscribe({
        next:data => {
          this.orders = data._embedded.orders;
        },
        error:err => {
          this.errorMessage = err.message
        }
      })
  }


  onOrderDetail(id: number) {
    this.router.navigateByUrl("/order-detail/"+id)
  }


}
