import { ChangeDetectorRef, Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../../Service/user-service';
import { IUser } from '../../Interface/iuser';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user-register',
  imports: [FormsModule, RouterLink],
  templateUrl: './user-register.html',
  styleUrl: './user-register.css'
})
export class UserRegister {


  constructor(private router:Router,
    private userService:UserService,
    private cdr: ChangeDetectorRef
  ){}

  newUser:IUser = {
    firstName:'',
    lastName:'',
    emailId:'',
    passWord:'',
    address:''
  }

   repeatPassword:string = "";

   register() {
    if(this.newUser.passWord != this.repeatPassword){
      alert("Passwords don't match")
    }else{
      this.userService.register(this.newUser).subscribe({
      next: (response) => {
        console.log('Registration response:', response);
        this.router.navigate(['/login']);
      }
    })
}
   }
  }
