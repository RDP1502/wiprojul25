import { ChangeDetectorRef, Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CartService } from '../../Service/cart-service';
import { ICart } from '../../Interface/icart';
import { ProductService } from '../../Service/product-service';
import { IProduct } from '../../Interface/iproduct';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { UserService } from '../../Service/user-service';

@Component({
  selector: 'app-edit-product',
  imports: [FormsModule, DatePipe, RouterLink],
  templateUrl: './edit-product.html',
  styleUrl: './edit-product.css'
})
export class EditProduct {

  constructor(private router:Router,
    private productService: ProductService,
    private cdr: ChangeDetectorRef,
    private activatedRoute: ActivatedRoute,
    private userService: UserService
  ){
    let id = Number(this.activatedRoute.snapshot.paramMap.get('id'))
    this.productId= Number(id)
  }
  productId:number=0
  ngOnInit(){
    this.findProduct(this.productId)
    

  }
   userId = Number(localStorage.getItem('userId'))

   product:IProduct={
    productName:'',
    productDesc:'',
    productCat:'',
    make:'',
    availableQty:0,
    price:0,
    uom:'' ,
    prodRating:0,
    imgUrl:'',
    dateOfManufacture: new Date()}

  findProduct(productId:number){
    this.productService.getProductById(productId).subscribe((data)=>{
      this.product = data
      this.cdr.detectChanges()
    })

  }
  clear(){
    this.product = {
      productName:'',
    productDesc:'',
    productCat:'',
    make:'',
    availableQty:0,
    price:0,
    uom:'' ,
    prodRating:0,
    imgUrl:'',
    dateOfManufacture: new Date()
    }
    this.cdr.detectChanges()
  }

  edit(){
    this.productService.updateProduct(this.productId, this.product).subscribe({
      next:(res)=>{
        console.log(res)
        this.clear()
        this.router.navigate(['/home'])
        this.cdr.detectChanges()
      }, error:(err)=>{
        console.log("error while updating product",err)
      }
    })
  }

  logout(){
    this.userService.logout(this.userId).subscribe((res)=>{
      console.log("You are logged out")
      localStorage.removeItem('tokenValue')
      localStorage.removeItem('userId')
      localStorage.removeItem('role')
      localStorage.removeItem('cart')
      this.router.navigate(['/login'])
    },(error)=>{
      console.log("errror while logout", error)
    })
    console.log("user id is  ", this.userId)
  }

}
