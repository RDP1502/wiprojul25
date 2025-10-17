import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IOrder } from '../Interface/iorder';
import { BASE_URL } from '../Utils/appConstant';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient){}

  private token=localStorage.getItem("tokenValue");
      // console.log("jwt token="+token)
      private header:HttpHeaders  = new HttpHeaders()
  
      private headers = new HttpHeaders()
        .set('Content-Type', 'application/json')
        .set('Authorization', `${this.token}`)

  getOrders():Observable<IOrder[]>{
    return this.http.get<IOrder[]>(`${BASE_URL}/orders`, {headers:this.headers})
  }

  newOrders(orders:IOrder):Observable<any>{
    return this.http.post(`${BASE_URL}/orders/place`, orders, {headers:this.headers, responseType:'text'as'json'});
  }
  
  getOrderById(id:number):Observable<IOrder>{
    return this.http.get<IOrder>(`${BASE_URL}/orders/${id}`, {headers:this.headers})
  }

  updateOrder(order:IOrder){
    return this.http.put(`${BASE_URL}/orders/place/${Number(order.orderId)}`, order,{headers:this.headers});
  }

  getOrderByUserId(userId:number):Observable<IOrder[]>{
    return this.http.get<IOrder[]>(`${BASE_URL}/orders/userId/${userId}`, {headers:this.headers})
  }
 
  
}
