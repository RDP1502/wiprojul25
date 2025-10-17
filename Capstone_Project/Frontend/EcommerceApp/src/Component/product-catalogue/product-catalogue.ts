import { ChangeDetectorRef, Component } from '@angular/core';
import { ProductService } from '../../Service/product-service';
import { Router , RouterLink} from '@angular/router';
import { IProduct } from '../../Interface/iproduct';
import { CurrencyPipe } from '@angular/common';
import { UserService } from '../../Service/user-service';
import { CartService } from '../../Service/cart-service';
import { ICart } from '../../Interface/icart';
import { FormsModule } from "@angular/forms";



@Component({
  selector: 'app-product-catalogue',
  imports: [CurrencyPipe, RouterLink, FormsModule],
  templateUrl: './product-catalogue.html',
  styleUrl: './product-catalogue.css'
})
export class ProductCatalogue {

  userRole = localStorage.getItem('role')

  constructor(private productService: ProductService,
    private router: Router,
    private cdr: ChangeDetectorRef,
    private userService:UserService,
    private cartService: CartService
  ) {}


  products:IProduct[]=[]
  filteredProducts: IProduct[] = [];

  userId:number = Number(localStorage.getItem('userId'))

  cartItems:ICart[]=[]
  itemCount = 0

  searchProductName:string=''
  searchProductCategory:string=''

  ngOnInit(){
    
    this.productService.getProducts().subscribe((data)=>{
      this.products = data;
      this.filteredProducts = data
      // console.log(this.products)
      
      this.cdr.detectChanges()
    })
    this.getCartCount()
    
  }

 onSearch() {
  this.filteredProducts = this.products.filter(item => {
    const matchesName = this.searchProductName
      ? item.productName.toLowerCase().includes(this.searchProductName.toLowerCase())
      : true; // if no name filter, accept all

    const matchesCategory = this.searchProductCategory
      ? item.productCat.toLowerCase().includes(this.searchProductCategory.toLowerCase())
      : true; // if no category filter, accept all

    return matchesName && matchesCategory; // BOTH must match if provided
  });

  if (!this.searchProductName && !this.searchProductCategory) {
    this.filteredProducts = this.products; // reset if nothing selected
  }
}

   logout(userId:number){
    this.userService.logout(userId).subscribe((res)=>{
      console.log("You are logged out")
      localStorage.removeItem('tokenValue')
      localStorage.removeItem('userId')
      localStorage.removeItem('role')
      this.cartService.clearCart()
      this.router.navigate(['/login'])
    },(error)=>{
      console.log("errror while logout", error)
    })
    console.log("user id is  ", userId)
  }

  getCartCount(){
    this.itemCount = this.cartService.countItem()
  }
  addToCart(product: IProduct) {
  const currentCart = this.cartService.getCart();

  // find cart for this user
  let userCart = currentCart.find(c => c.userId === this.userId);

  if (!userCart) {
    // if no cart exists, create one
    userCart = {
      userId: this.userId,
      totalQty: 1,
      totalPrice: product.price,
      cartItems: [
        { productId: product.id!, quantity: 1 }
      ]
    };
    this.cartService.addToCart(userCart);
  } else {
    // check if product already exists in cart
    const cartItem = userCart.cartItems.find(ci => ci.productId === product.id);
    if (cartItem) {
      cartItem.quantity += 1;
    } else {
      userCart.cartItems.push({ productId: product.id!, quantity: 1 });
    }

    // update totals
    userCart.totalQty = userCart.cartItems.reduce((sum, ci) => sum + ci.quantity, 0);
    userCart.totalPrice = userCart.cartItems.reduce((sum, ci) => {
      const p = this.products.find(pr => pr.id === ci.productId);
      return sum + (p ? p.price * ci.quantity : 0);
    }, 0);

    // replace in service
    this.cartService.replaceCart([...currentCart]);
  }

  this.getCartCount();
  this.cdr.detectChanges();
}

}
