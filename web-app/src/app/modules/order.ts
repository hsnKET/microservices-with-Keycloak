import {Page} from "./page";
import {ProductItem} from "./product-item";

export interface Order {

  id:number,
  createdAt:number,
  status:string,
  customerId:number,
  customer:number,
  productItems:ProductItem[];
}

export interface Embedded{
  orders:Order[];

}
export interface OrderResponse{
  _embedded:Embedded;
  page:Page;
}

