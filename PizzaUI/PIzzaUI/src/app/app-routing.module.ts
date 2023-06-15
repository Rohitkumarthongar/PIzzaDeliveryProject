import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { DashBoardComponent } from './components/dash-board/dash-board.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './components/services/auth.guard';
import { SignUpComponent } from './components/sign-up/sign-up.component';

const routes: Routes = [
  // {path:"dashBoard",component:DashBoardComponent},
  {path:"signUp",component:SignUpComponent},
  {path:"login",component:LoginComponent},
  {path:"home",component:HomeComponent,canActivate:[AuthGuard]},
  {path:"cart",component:CartComponent,canActivate:[AuthGuard]},
  {path:"**",component:DashBoardComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
