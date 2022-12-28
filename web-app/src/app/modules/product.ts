import {Page} from "./page";

export interface Product {

  id:number,
  name:string,
  price:number,
  quantity:number
}

export interface Embedded{
  products:Product[];

}
export interface ProductResponse{
  _embedded:Embedded;
  page:Page;
}
