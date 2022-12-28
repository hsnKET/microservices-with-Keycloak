import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductResponse} from "../modules/product";
import {environment} from "../../environments/environment";
import {ProductItem, ProductItemResponse} from "../modules/product-item";

@Injectable({
  providedIn: 'root'
})
export class ProductItemsService {

  constructor(private http:HttpClient) { }

  allProductItems(orderId:number):Observable<ProductItemResponse>{
    return this.http
      .get<ProductItemResponse>(environment.baseOrderServiceURL+"/fullOrder/"+orderId);
  }
}
