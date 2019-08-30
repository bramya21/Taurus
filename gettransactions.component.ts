import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../models/Transactions'
import { AccountsService } from '../../service/accounts.service'
import {MatTableDataSource} from '@angular/material/table';


@Component({
  selector: 'app-gettransactions',
  templateUrl: './gettransactions.component.html',
  styleUrls: ['./gettransactions.component.css']
})
export class GettransactionsComponent implements OnInit {
  transactions:Transaction[]=[]
  transaction:Transaction=new Transaction()
  displayedColumns:string[]=['id','to account','amount transffered','transactiondate'];
  dataSource = new MatTableDataSource(this.transactions);

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(private account:AccountsService) { }

  ngOnInit() {
    this.transaction={
      "tid": 100,
      "fromaccount":1001,
      "toaccount":1001,
      "ammouttransffered":40,
      "transactiondate":'2019-08-29'
    }
    this.account.getTransactions(this.transaction).subscribe(

      transactions => {
        console.log(transactions);
        this.transactions = transactions
      }
    )
  }

}
