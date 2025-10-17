import { Routes } from '@angular/router';
import { App } from './app';
import { UserRegister } from '../user-register/user-register';
import { UserLogin } from '../user-login/user-login';
import { Home } from '../home/home';
import { ProductCatalogue } from '../product-catalogue/product-catalogue';
import { AddProduct } from '../add-product/add-product';
import { EditProduct } from '../edit-product/edit-product';
import { Cart } from '../cart/cart';

export const routes: Routes = [
    {path:'', component:UserLogin},
    {path:'login', component:UserLogin},
    {path:'user/register', component:UserRegister},
    {path:'home', component:Home},
    {path:'products', component:ProductCatalogue},
    {path:'add-product', component:AddProduct},
    {path:'edit/:id', component:EditProduct},
    {path:'cart', component:Cart}
    
];
