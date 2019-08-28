import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-deleteaccount',
  templateUrl: './deleteaccount.component.html',
  styleUrls: ['./deleteaccount.component.css']
})
export class DeleteaccountComponent implements OnInit {
  public accId:number;
   
  ngOnInit() {
   
  }
 
  constructor(private service : UserService) {

   }

   onSubmit() {
    console.log(this.accId);
    let resp = this.service.deleteaccount(this.accId);
    console.log(resp);
   }
}
