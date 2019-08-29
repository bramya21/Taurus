import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable }    from 'rxjs';
import { User } from '../../models/user';
import {AccountsService} from '../../services/accounts.service'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  public user:User;
  formGroup: FormGroup;
  constructor(private formBuilder: FormBuilder,private service : AccountsService) { }

  ngOnInit() {
    this.createForm();
    this.user = new User(null,null)
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required],
    });
  }


  getError(el) {
    switch (el) {
      case 'user':
        if (this.formGroup.get('username').hasError('required')) {
          return 'Username required';
        }
        break;
      case 'pass':
        if (this.formGroup.get('password').hasError('required')) {
          return 'Password required';
        }
        break;
      default:
        return '';
    }
  }

  onSubmit() {
    // this.post = post;
    let resp = this.service.isValidLogin(this.user).subscribe(data=>console.log(data));
  }

}