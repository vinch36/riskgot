import { LOCALE_ID, NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { RouterModule } from '@angular/router';
import * as fr from '@angular/common/locales/fr';
import { HttpClientModule } from '@angular/common/http';
import { AuthorizationModule } from '../authorization/authorization.module';




@NgModule({
  declarations: [HeaderComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule,
    AuthorizationModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'fr-FR'},],
  exports:[HeaderComponent] 

})




export class CoreModule { 
  constructor() {
    registerLocaleData(fr.default);
  }
}




