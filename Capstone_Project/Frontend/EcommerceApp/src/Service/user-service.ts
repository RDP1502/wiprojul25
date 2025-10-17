import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IUser } from '../Interface/iuser';
import { Observable } from 'rxjs';
import { TokenData } from '../Interface/token-data';
import { BASE_URL } from '../Utils/appConstant';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient){}

   
  login(User:IUser):Observable<TokenData>{
    return this.http.post<TokenData>(BASE_URL+"/user/login", User)
  }

  register(user:IUser):Observable<any>{
    return this.http.post<any>(BASE_URL+"/user/register", user, {responseType:'text'as 'json'})
  }

  getUserById(id:number):Observable<IUser>{
    let token = localStorage.getItem('tokenValue')
    let header:HttpHeaders = new HttpHeaders()
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`)
    return this.http.get<IUser>(`${BASE_URL}/user/login/${id}` , {headers})
  }

  getAllUsers():Observable<IUser[]>{
    
    let token = localStorage.getItem('tokenValue')
    
    let header:HttpHeaders = new HttpHeaders()
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`)
    return this.http.get<IUser[]>(`${BASE_URL}/user`,{headers})
  }

  updateUser(user:IUser, id:number):Observable<any>{
    let token = localStorage.getItem('tokenValue')
    let header:HttpHeaders = new HttpHeaders()
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`)
    return this.http.put<any>(`${BASE_URL}/user/update/${id}`, user,{headers})
  }

  logout(userId:number):Observable<any>{
    let token = localStorage.getItem('tokenValue')
   
    const headers = new HttpHeaders()
    .set('Content-Type' , 'application/json')
    .set('Authorization', `${token}`|| '')
    console.log("this is header:", headers)
    
    return this.http.get<any>(`${BASE_URL}/user/logout/${userId}`, {headers}) 
  }
}
