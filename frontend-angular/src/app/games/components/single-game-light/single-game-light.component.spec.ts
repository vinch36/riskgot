import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleGameLightComponent } from './single-game-light.component';

describe('SingleGameLightComponent', () => {
  let component: SingleGameLightComponent;
  let fixture: ComponentFixture<SingleGameLightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SingleGameLightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SingleGameLightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
