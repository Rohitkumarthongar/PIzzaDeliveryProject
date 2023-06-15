import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthGuardService } from '../services/auth-guard.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide=true;
  LoginForm!:FormGroup;
  constructor(private formBuilder:FormBuilder,private login:LoginService,private route:Router,private Http:HttpClient,private auth:AuthGuardService) { }


  ngOnInit(): void {
    this.LoginForm=this.formBuilder.group({
      userEmailId:[null,Validators.required],
      userPassword:[null,Validators.required]
    })   
  }

  get userEmailId()
{
  return this.LoginForm.get('userEmailId') ;
}
get userPassword()
{
  return this.LoginForm.get('userPassword') ;
}



  loginForm(){
    console.log(this.LoginForm.value);
        if(this.LoginForm.valid)
        {
          this.Http.post<any>("http://localhost:9000/api/pizza/Auth/login",this.LoginForm.value)
    .subscribe({
      next:(res)=>
      {
        
        this.auth.userLogin(this.LoginForm.value);
        alert("User Login SuccesFully");
        this.route.navigateByUrl("/home")
    },
      error:()=>
      {
        alert("Sorry User Not Registered");
        this.route.navigateByUrl("/signUp")
      }
    });
        this.LoginForm.reset();
        }
  }

}

