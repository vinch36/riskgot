import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthbuttonComponent } from './components/authbutton/authbutton.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
// Import the injector module and the HTTP client module from Angular
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// Import the HTTP interceptor from the Auth0 Angular SDK
import { AuthHttpInterceptor, AuthModule } from '@auth0/auth0-angular';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProfilebuttonComponent } from './components/profilebutton/profilebutton.component';
import { UpdateUserprofileComponent } from './components/update-userprofile/update-userprofile.component';


@NgModule({
  declarations: [AuthbuttonComponent, UserprofileComponent, ProfilebuttonComponent, UpdateUserprofileComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AuthModule.forRoot({
      domain: 'dev-9-9s2dzx.us.auth0.com',
      clientId: 'vCkYh7JnXNJnER4lZQFDt6JtXwCE0Ck2',
      // Request this audience at user authentication time
      //audience: 'https://dev-9-9s2dzx.us.auth0.com/api/v2/',
      audience: 'https://risk-got-api.com',
      // Request this scope at user authentication time
      //scope: 'read:current_users',
      // Specify configuration for the interceptor    
      //scope: 'read:users',   
      //scope: 'read:users read:current_user',  
      //scope: 'read:current_user',
      //scope: 'read:current_user update:current_user',
     
      httpInterceptor: {
        
        allowedList: [
          {uri: 'http://localhost:9001/riskgot/api/*',
          tokenOptions: {
            // The attached token should target this audience
            audience: 'https://risk-got-api.com',
            // The attached token should have these scopes
            //scope: 'read:current_user'
          }
        }
        ,
          {
            // Match any request that starts 'https://dev-9-9s2dzx.us.auth0.com/api/v2/' (note the asterisk)
            uri: 'https://dev-9-9s2dzx.us.auth0.com/api/v2/*',
            tokenOptions: {
              // The attached token should target this audience
              audience: 'https://dev-9-9s2dzx.us.auth0.com/api/v2/',
              // The attached token should have these scopes
              scope: 'read:current_user update:current_user'
            }
          }
        ]
      }
    })
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthHttpInterceptor, multi: true },
  ],
  exports: [AuthbuttonComponent,ProfilebuttonComponent]
})
export class AuthorizationModule { }
