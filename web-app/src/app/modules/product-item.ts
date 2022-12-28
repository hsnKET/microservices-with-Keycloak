export interface ProductItem {
  id:        number;
  productId: number;
  product:   null;
  price:     number;
  quantity:  number;
  discount:  number;
}

export interface ProductItemResponse{
  id:number,
  createdAt:number,
  status:string,
  customerId:number,
  productItems:ProductItem[];
}

