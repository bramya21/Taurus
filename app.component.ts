import { Component } from '@angular/core';
import { BnNgIdleService } from 'bn-ng-idle';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private bnIdle: BnNgIdleService) { // initiate it in your component constructor
    this.bnIdle.startWatching(10).subscribe((res) => {
      if(res) {
          alert("session expired");
      }
    })
}
}
