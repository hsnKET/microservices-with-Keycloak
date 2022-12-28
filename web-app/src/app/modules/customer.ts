import {Page} from "./page";

export interface Customer {
  id:number;
  name:string;
  email:string;
}


export interface EmbeddedCustomer{
  customers:Customer[];

}
export interface CustomerResponse{
  _embedded:EmbeddedCustomer;
  page:Page;
}

