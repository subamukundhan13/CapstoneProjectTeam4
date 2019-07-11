import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service'; 
import { Customer } from '../customer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  submitted=false;
  invalidcred=false;
  emptyfields=false;
  customer : Customer;
  Username : string;
  Password : string;

  constructor(private dataService: DataService) { 
  
  this.submitted=false;
  }

  private authenticateUsers()
  {
   this.dataService.getCustomerDetails(this.Username).then(customer => this.customer = customer);
   if((this.customer.username)!="wrong")
   {
    if((this.customer.password)==this.Password)
    {
    this.submitted=true;
    this.invalidcred= false;
    }
    else
    {
     this.invalidcred=true;
     this.emptyfields=false;
    }
   }
   else if((this.customer.username)=="wrong")
   {
   this.invalidcred = true;
   this.emptyfields=false;
   }

  }
  ngOnInit() {
  this.Username="";
  this.Password="";
  }
 onSubmit()
 {
    if(this.Username!="")
    {
      if(this.Password!="")
      {
       this.authenticateUsers();
      }
      else
      {
        this.emptyfields=true;  
      }
    }
    else
    this.emptyfields=true;

 }
}
