import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ICart } from '../Interface/icart';
import { BASE_URL } from '../Utils/appConstant';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient){}

  private userCartItems = new BehaviorSubject<ICart[]>(this.loadCart())
  cartItems$ = this.userCartItems.asObservable()

  private token=localStorage.getItem("tokenValue");
      // console.log("jwt token="+token)
  private header:HttpHeaders  = new HttpHeaders()
  
  private headers = new HttpHeaders()
        .set('Content-Type', 'application/json')
        .set('Authorization', `${this.token}`)

 countItem(){
  return this.userCartItems.value.length;
  
 }

 // Get current items (snapshot)
  private loadCart(): ICart[] {
    const savedCart = localStorage.getItem('cart');
    return savedCart ? JSON.parse(savedCart) : [];
  }

  private saveCart(cart: ICart[]) {
    localStorage.setItem('cart', JSON.stringify(cart));
  }

  getCart(): ICart[] {
    return this.userCartItems.value;
  }

  addToCart(item: ICart) {
    const updatedCart = [...this.userCartItems.value, item];
    this.userCartItems.next(updatedCart);
    this.saveCart(updatedCart);
  }

  removeFromCart(productId: number) {
    const updatedCart = this.userCartItems.value.map(cart => ({
    ...cart,
    cartItems: cart.cartItems.filter(item => item.productId !== productId)
  }));

  this.userCartItems.next(updatedCart);
  this.saveCart(updatedCart);
  }
replaceCart(cart: ICart[]) {
  this.userCartItems.next(cart);
  this.saveCart(cart);
}


  clearCart() {
    this.userCartItems.next([]);
    localStorage.removeItem('cart');
  }
  
}