import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  public customer:Customer;
   
  ngOnInit() {
    this.customer = new Customer(null,null,null,null,null,null);
  }
 
  constructor(private service : UserService) {

   }
   onSubmit() {
    console.log(this.customer);
    let resp = this.service.addcustomer(this.customer).subscribe(data=>console.log(data));
   }
}
