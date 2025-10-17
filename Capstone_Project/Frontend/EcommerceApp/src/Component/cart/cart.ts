import { ChangeDetectorRef, Component } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../../Service/cart-service';
import { ICart } from '../../Interface/icart';
import { ProductService } from '../../Service/product-service';
import { IProduct } from '../../Interface/iproduct';
import { CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ICartItem } from '../../Interface/icart-item';
import { IOrder } from '../../Interface/iorder';
import { OrderService } from '../../Service/order-service';

@Component({
  selector: 'app-cart',
  imports: [CurrencyPipe, FormsModule],
  templateUrl: './cart.html',
  styleUrl: './cart.css'
})
export class Cart {

  constructor(private router:Router,
    private cartService:CartService,
    private productService:ProductService,
    private cdr: ChangeDetectorRef,
    private orderService:OrderService
  ){}

  addedItems:ICart[]=[]
  products:IProduct[]=[]
  count:number=0
  itemCart:ICartItem[]=[]

 
  ngOnInit() {
   
    this.cartService.cartItems$.subscribe(items => {
      this.addedItems = items;
      this.products = []; // clear previous before refetching
      this.getProductById();
      console.log("length", this.addedItems.length)
    });
  }

  
  // Add this field
quantityByProductId: { [id: number]: number } = {};

// In getProductById(), after you push each product, set its quantity once
getProductById() {
  this.addedItems.forEach(item => {
    item.cartItems.forEach(cartProduct => {
      this.productService.getProductById(cartProduct.productId).subscribe(res => {
        this.products.push(res);
        // initialize per-product quantity from cart
        this.quantityByProductId[cartProduct.productId] = cartProduct.quantity;
        this.cdr.detectChanges();
      });
    });
  });
}

// Handle per-product quantity change
onQtyChange(productId: number, qty: number) {
  const newQty = Math.max(1, Number(qty) || 1);
  this.quantityByProductId[productId] = newQty;

  // Update the cart data
  const updated = this.addedItems.map(cart => ({
    ...cart,
    cartItems: cart.cartItems.map(ci =>
      ci.productId === productId ? { ...ci, quantity: newQty } : ci
    )
  }));

  // Persist (add this method in service if you don't have it)
  this.cartService.replaceCart(updated);
  this.addedItems = updated;
  this.cdr.detectChanges();
}

get subtotal(): number {
  return this.products.reduce((sum, p) => {
    const qty = this.quantityByProductId[p.id!] || 0;
    return sum + qty * p.price;
  }, 0);
}

  deleteItem(id:number) {

    this.cartService.removeFromCart(id);
  }

  deleteAll(){
    this.cartService.clearCart()
  }
  
  
  finalCart:ICart={
    userId:Number(localStorage.getItem('userId')?Number(localStorage.getItem('userId')):0),
    totalQty:this.addedItems.reduce((acc,item)=> acc+item.totalQty,0),
    totalPrice:this.subtotal,
    cartItems:[]
  }
  placeOrder(){
    
   this.addedItems.forEach(item=>{
    item.cartItems.forEach(item=>{
      this.itemCart.push(item)
      this.finalCart.totalQty = item.quantity;
    })
   })
   let order: IOrder={
      userId:this.finalCart.userId,
      totalAmount:this.subtotal,
      items:this.itemCart
    }
    console.log("order is",order,"items are",order.items)
    this.productService.placeOrder(order).subscribe(()=>{
      this.cartService.clearCart()
      this.router.navigate(['/home'])
    },(error)=>{
      console.log("error while placing order")
    })
  }
}