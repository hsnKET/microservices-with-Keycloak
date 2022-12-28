import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Product, ProductResponse} from "../modules/product";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  allProducts(size:number = 10,page:number=0):Observable<ProductResponse>{
    return this.http
      .get<ProductResponse>(environment.baseInventoryServiceURL+"/products?projection=fullProduct&size="+size+"&page="+page);
  }
}
