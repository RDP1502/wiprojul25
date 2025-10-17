import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from '../Interface/iproduct';
import { BASE_URL } from '../Utils/appConstant';
import { IOrder } from '../Interface/iorder';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient){}

    
    // console.log("jwt token="+token)
    private header:HttpHeaders  = new HttpHeaders()

    
   

  getProducts():Observable<IProduct[]>{
    let token = localStorage.getItem('tokenValue')
    console.log("token",token)
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`|| '')
    return this.http.get<IProduct[]>(`${BASE_URL}/products`,{headers})
  }
  
  addNewProduct(product:IProduct):Observable<any>{
    let token = localStorage.getItem('tokenValue')
    // console.log("token",token)
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`|| '')
    return this.http.post<any>(`${BASE_URL}/products`, product, {headers, responseType:'test'as 'json'})
  }

  updateProduct(id:number, product:IProduct):Observable<any>{
    let token = localStorage.getItem('tokenValue')
    console.log("token",token)
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`|| '')
    return this.http.put<any>(`${BASE_URL}/products/${id}`,product,{headers, responseType:'text' as 'json'})
  }

  deleteProduct(id:number):Observable<any>{
    let token = localStorage.getItem('tokenValue')
    console.log("token",token)
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`|| '')
    return this.http.delete<any>(`${BASE_URL}/products/${id}`,{headers, responseType:'text' as 'json'})
  }

  getProductById(id:number):Observable<IProduct>{
    let token = localStorage.getItem('tokenValue')
    console.log("token",token)
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`|| '')
    return this.http.get<IProduct>(`${BASE_URL}/products/${id}`,{headers})
  }

  placeOrder(order:IOrder):Observable<IOrder>{
    let token = localStorage.getItem('tokenValue')
    console.log("token",token)
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`|| '')
    return this.http.post<IOrder>(`${BASE_URL}/products/place`, order,{headers})

  }


}
