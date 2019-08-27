import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Account } from '../models/Accounts'
import { Transaction } from '../models/Transactions';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class AccountsService {
  id:string
  accountsUrl:string = 'http://localhost:8075/rest/accounts'
  transactionUrl:string = 'http://localhost:8075/rest/transaction'

  constructor(private http:HttpClient) {}

  // Get accounts
  getaccounts():Observable<Account[]> {
    return this.http.get<Account[]>(this.accountsUrl);
  }

  // Delete account
  deleteaccount(account:Account):Observable<Account> {
    const url = `${this.accountsUrl}/${account.accno}`;
    return this.http.delete<Account>(url, httpOptions);
  }

  // Add account
  addaccount(account:Account):Observable<Account> {
    return this.http.post<Account>(this.accountsUrl, account, httpOptions);
  }
  //get transactions by user account
  getTransactions(transaction:Transaction):Observable<Transaction[]> {
    const url = `${this.transactionUrl}/${transaction.fromaccount}`;
    return this.http.get<Transaction[]>(url);
  }
  //add transaction
  addTransaction(transaction:Transaction):Observable<Transaction>{
    console.log(transaction)
    console.log(this.http.put<Transaction>(this.transactionUrl,transaction,httpOptions))
    return this.http.put<Transaction>(this.transactionUrl,transaction,httpOptions)
  }

}
