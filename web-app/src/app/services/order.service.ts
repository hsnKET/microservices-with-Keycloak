import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductResponse} from "../modules/product";
import {environment} from "../../environments/environment";
import {OrderResponse} from "../modules/order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  constructor(private http:HttpClient) { }

  allOrders(customerId:number,size:number = 10,page:number=0):Observable<OrderResponse>{
    return this.http
      .get<OrderResponse>(environment.baseOrderServiceURL+"/orders/search/byCustomerId?customerId="+customerId+"&projection=fullOrder&size="+size+"&page="+page);
  }

}
