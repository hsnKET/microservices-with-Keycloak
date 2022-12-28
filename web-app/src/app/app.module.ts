import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductsComponent } from './components/products/products.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import { OrdersComponent } from './components/orders/orders.component';
import { CustomersComponent } from './components/customers/customers.component';
import { OrderDetailsComponent } from './components/order-details/order-details.component';


const  appRoutes:Routes = [
  {path:"products",component:ProductsComponent},
  {path:"customers",component:CustomersComponent},
  {path:"orders/:customerId",component:OrdersComponent},
  {path:"order-detail/:orderId",component:OrderDetailsComponent},
  {path:"",redirectTo:"products",pathMatch:"full"}
]

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    OrdersComponent,
    CustomersComponent,
    OrderDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
