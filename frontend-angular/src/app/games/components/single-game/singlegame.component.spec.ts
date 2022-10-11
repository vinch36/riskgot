import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SinglegameComponent } from './singlegame.component';

describe('SinglegameComponent', () => {
  let component: SinglegameComponent;
  let fixture: ComponentFixture<SinglegameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SinglegameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SinglegameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
