import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
}
)
export class UsersService {

  loginUrl:string = 'http://localhost:52114/users/login'
  constructor(private http:HttpClient) { }

  
  postLogin(user:User)
  {
    return this.http.post<any>(this.loginUrl,user);
  }
}
