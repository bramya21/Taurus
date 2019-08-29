import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { Account } from './account';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  id:string
  loginUrl:string = 'http://localhost:52114/users/login'
  transactionUrl:string = 'http://localhost:8075/rest/transaction'
  accountsUrl:string='http://localhost:52114/users/account'
  customerUrl:string='http://localhost:52114/users/customers'
  deleteAccountUrl:string='http://localhost:52114/users/account/'
  constructor(private http:HttpClient) {}

  postLogin(user:User)
  {
    return this.http.post<any>(this.loginUrl,user);
  }

  addaccount(account:Account){
       return this.http.post<any>(this.accountsUrl, account);
     }
  addcustomer(customer:Customer):Observable<any> {
      return this.http.post<any>(this.customerUrl, customer);
    }

    deleteaccount(accId:number)
    {
      return this.http.post<any>(this.deleteAccountUrl+accId,'');
    }
  // // Get accounts
  // getaccounts():Observable<Account[]> {
  //   return this.http.get<Account[]>(this.accountsUrl);
  // }

  // // Delete account
  // deleteaccount(account:Account):Observable<Account> {
  //   const url = `${this.accountsUrl}/${account.accno}`;
  //   return this.http.delete<Account>(url, httpOptions);
  // }

  // // Add account
  // addaccount(account:Account):Observable<Account> {
  //   return this.http.post<Account>(this.accountsUrl, account, httpOptions);
  // }
  // //get transactions by user account
  // getTransactions(transaction:Transaction):Observable<Transaction[]> {
  //   const url = `${this.transactionUrl}/${transaction.fromaccount}`;
  //   return this.http.get<Transaction[]>(url);
  // }
  // //add transaction
  // addTransaction(transaction:Transaction):Observable<Transaction>{
  //   console.log(transaction)
  //   console.log(this.http.put<Transaction>(this.transactionUrl,transaction,httpOptions))
  //   return this.http.put<Transaction>(this.transactionUrl,transaction,httpOptions)
  // }
}
