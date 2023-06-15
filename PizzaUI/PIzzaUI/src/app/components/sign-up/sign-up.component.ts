import { ConnectionPositionPair } from '@angular/cdk/overlay';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignUpService } from '../services/sign-up.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  hide: any;
SignUpForm !: FormGroup;
 

  constructor(private formBuilder:FormBuilder,private sign:SignUpService,private router:Router,private Http:HttpClient) { }

  ngOnInit(): void {
    this.SignUpForm=this.formBuilder.group({
      userFirstName:[null,[Validators.required,Validators.maxLength(15),Validators.minLength(3)]],
      userLastName:[null,[Validators.required,Validators.maxLength(15),Validators.minLength(3)]],
      userEmailId:[null,[Validators.required,Validators.email]],
      userPassword:[null,[Validators.required,Validators.minLength(8)]],
    userContNo:[null,Validators.required]}); 
  }

  get userFirstName()
  {
    return this.SignUpForm.get('userFirstName')  as FormControl;
  }

  get userLastName()
  {
    return this.SignUpForm.get('userLastName') as FormControl;
  }
  get userEmailId()
  {
    return this.SignUpForm.get('userEmailId') as FormControl;
  }
  get userPassword()
  {
    return this.SignUpForm.get('userPassword') as FormControl ;
  }
  get userContNo()
  {
    return this.SignUpForm.get('userContNo') as FormControl ;
  }

  signUpForm(){
    console.log(this.SignUpForm.value);
  this.Http.post<any>("http://localhost:9000/api/pizza/Auth/saveUser",this.SignUpForm.value).
  subscribe({
          next:(res)=>{
            alert("USer Got Registered");
            console.log("User Register In Authentication");
            this.router.navigateByUrl("/login");
          },error:()=>
          {
            alert("Sorry User Not Registered");
            this.router.navigateByUrl("/signUp");
          }
          });
          this.SignUpForm.reset();
          
        } 
      

      registrationForm()
      {
        console.log("USer registered");
        this.Http.post<any>("http://localhost:9000/api/pizza/service/registerUser",this.SignUpForm.value)
        .subscribe(
          {next:(res)=>
            {console.log("User Register In microservices")}});
            

      }
    }
    

