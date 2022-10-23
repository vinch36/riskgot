import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthCheckComponent } from './healthcheck.component';

describe('TestComponent', () => {
  let component: HealthCheckComponent;
  let fixture: ComponentFixture<HealthCheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthCheckComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HealthCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
