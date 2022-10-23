import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HealthCheckComponent } from './components/healthcheck/healthcheck.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    HealthCheckComponent
  ],
  imports: [
    CommonModule,
    RouterModule

  ],
  exports:[
   HealthCheckComponent
  ]
})
export class HealthCheckModule { }
