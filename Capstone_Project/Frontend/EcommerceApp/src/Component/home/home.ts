import { ChangeDetectorRef, Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../Service/user-service';
import { IUser } from '../../Interface/iuser';
import { USER_ICON } from '../../Utils/appConstant';
import { FormsModule } from '@angular/forms';
import { IProduct } from '../../Interface/iproduct';
import { ProductService } from '../../Service/product-service';
import { UserTypePipe } from '../../Utils/userType';
import { CurrencyPipe, DatePipe, UpperCasePipe } from '@angular/common';
import { OrderService } from '../../Service/order-service';
import { IOrder } from '../../Interface/iorder';
import { last } from 'rxjs';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.html',
  styleUrl: './home.css',
  imports: [FormsModule, UserTypePipe, UpperCasePipe, DatePipe, CurrencyPipe
  ],
})
export class Home {


  constructor(
    private router: Router,
    private userService: UserService,
    private cdr: ChangeDetectorRef,
    private productService: ProductService,
    private orderService: OrderService
  ) {}

  role: string = '';
  userId: number = 0;

  loggedUser: IUser = {
    firstName: '',
    lastName: '',
    emailId: '',
    passWord: '',
    address: ''
  };

  userIcon = USER_ICON;
  searchProductName:string=''
  searchProductCategory:string=''
  filteredProducts:IProduct[]=[]

  ngOnInit() {
   
        this.allUsers()
    this.allProducts()
    this.currentUser()
    this.getUserOrders()
    setTimeout(() => {
    this.cdr.detectChanges;
  }, 0);
  }

  currentUser(){
    // Parse token and set role/userId
    const token = localStorage.getItem('tokenValue')?.replace('Bearer ', '');
    if (token) {
      try {
        const payload = JSON.parse(atob(token.split('.')[1]));
        this.role = payload.authorities?.[0] ?? '';
        this.userId = Number(payload.sub) || 0;
        localStorage.setItem('userId', String(this.userId))
        localStorage.setItem('role', this.role);
        this.cdr.detectChanges()
      } catch (e) {
        console.error('Invalid token payload', e);
      }
    }

    if (!this.userId) {
      this.cdr.detectChanges();
      return; // nothing to load
    }

    // Fetch user, then trigger CD (zoneless mode needs manual CD after async)
    this.userService.getUserById(this.userId).subscribe({
      next: (data) => {
        this.loggedUser = data;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Failed to load user', err);
        this.cdr.detectChanges();
      }
    });

  }

  update = false
 

  updateProfile(){
   this.update= !this.update;
   this.updatedUser = {
    firstName:this.loggedUser.firstName!,
    lastName:this.loggedUser.lastName!,
    emailId:this.loggedUser.emailId,
    passWord:this.loggedUser.passWord,
    address:this.loggedUser.address!
  }
  }

  updatedUser = {
    firstName:'',
    lastName:'',
    emailId:'',
    passWord:'',
    address:''
  }
   
  updateUser() {
    
    this.userService.updateUser(this.updatedUser,this.userId).subscribe(()=>{
      console.log("updated")
    }
    )
    this.update=false
    this.cdr.detectChanges()
    console.log("updated")
} 

 logout(userId:number){
    this.userService.logout(userId).subscribe((res)=>{
      console.log("You are logged out")
      localStorage.removeItem('tokenValue')
      localStorage.removeItem('userId')
      localStorage.removeItem('role')
      localStorage.removeItem('cartItems')
      this.router.navigate(['/login'])
    },(error)=>{
      console.log("errror while logout", error)
    })
    console.log("user id is  ", userId)
  }

  shopNow(){
    this.router.navigate(['/products'])
  }

  addProduct(){
    this.router.navigate(['/add-product'])
  }

  users:IUser[]=[]
  manageUser = false
  manage(){
    this.manageUser = !this.manageUser
  }
  allUsers(){
     console.log("call made")
    this.userService.getAllUsers().subscribe((users)=>{
      this.users = users
      console.log("users are ",users)
      this.cdr.detectChanges()
    })
  }

  products:IProduct[]=[]
  allProducts(){
    this.productService.getProducts().subscribe((products)=>{
      this.products = products
      this.filteredProducts= products
      console.log("Products are", this.products)
      this.cdr.detectChanges()
    })
  }

  edit(productId:number){
    this.router.navigate([`/edit/${productId}`])
  }

  deleteProd(productId:number){
    this.productService.deleteProduct(productId).subscribe({
      next:(res)=>{
        this.allProducts();
        console.log(res)
        
      }, error:(error)=>{
      console.log("error while deleting", error)
    }
    })
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

  orders:IOrder[]=[]

  getUserOrders(){
    this.orderService.getOrderByUserId(this.userId).subscribe((orders)=>{
     this.orders = orders
     this.cdr.detectChanges()
    })
  }

  updateOrder(id:number){
    console.log("update id ",id)
    this.orders.forEach((order)=>{
      if(order.id==id&& order.orderStatus?.toLowerCase()!="sucessful"){
        this.orderService.updateOrder(order).subscribe({
          next:(res)=>{
            alert(res)
          }
        })
      }
      this.cdr.detectChanges()
    })
  }
}