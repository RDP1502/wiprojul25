import { ChangeDetectorRef, Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../Service/user-service';
import { IUser } from '../../Interface/iuser';
import { TokenData } from '../../Interface/token-data';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  imports: [FormsModule, RouterLink],
  templateUrl: './user-login.html',
  styleUrl: './user-login.css'
})
export class UserLogin {

  constructor(private router:Router,
    private userService:UserService,
    private cdr: ChangeDetectorRef
  ){}

  user={
    emailId:'',
    passWord:''
  }

  jwtToken: TokenData={token:''}
  users:IUser[]=[]

  ngOnInit(){
    this.cdr.detectChanges()
  }

  login(){
    this.userService.login(this.user).subscribe((data)=>{
      this.jwtToken = data;
      console.log(this.jwtToken)
      localStorage.setItem('tokenValue', this.jwtToken.token)
      this.router.navigate(['/home'])
    }, (error)=>{
      console.log("error while sign in ", error)
    })
  }



}
