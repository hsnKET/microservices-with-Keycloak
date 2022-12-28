import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerResponse} from "../modules/customer";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  getCustomers(size:number = 10,page:number=0):Observable<CustomerResponse> {
    return this.http.get<CustomerResponse>(environment.baseCustomerServiceURL+"/customers?projection=fullCustomer&size="+size+"&page="+page)
  }
}
