import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user:User;
   
  ngOnInit() {
    this.user = new User(null,null);
  }
 
  constructor(private service : UserService) {
   }
   onSubmit() {
    console.log(this.user);
    let resp = this.service.postLogin(this.user).subscribe(data=>console.log(data));
     }

}
