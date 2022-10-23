import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CoreModule } from './core/core.module';
import { HealthCheckModule } from './healthcheck/healthcheck.module';
import { LandingPageModule } from './landing-page/landing-page.module';
import { AuthModule } from '@auth0/auth0-angular';
import { AuthorizationModule } from './authorization/authorization.module';

@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    CoreModule,
    BrowserModule,
    AppRoutingModule,
    LandingPageModule,
    HealthCheckModule,
    AuthorizationModule
  ],

  bootstrap: [AppComponent]
})
export class AppModule {
 
}
