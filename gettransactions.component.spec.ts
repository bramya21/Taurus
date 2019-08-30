import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GettransactionsComponent } from './gettransactions.component';

describe('GettransactionsComponent', () => {
  let component: GettransactionsComponent;
  let fixture: ComponentFixture<GettransactionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GettransactionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GettransactionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
