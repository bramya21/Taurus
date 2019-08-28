import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  public account:Account;
   
  ngOnInit() {
    this.account = new Account(null,null,null,null);
  }
 
  constructor(private service : UserService) {

   }
   onSubmit() {
    console.log(this.account);
    let resp = this.service.addaccount(this.account).subscribe(data=>console.log(data));
     }


}
