import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowTablesComponent } from './show-tables.component';

describe('ShowTablesComponent', () => {
  let component: ShowTablesComponent;
  let fixture: ComponentFixture<ShowTablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowTablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowTablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
