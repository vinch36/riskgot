import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SinglegameComponent } from './singlegame/singlegame.component';
import { registerLocaleData } from '@angular/common';

import * as fr from '@angular/common/locales/fr';
import { GameListComponent } from './game-list/game-list.component';
import { HeaderComponent } from './header/header.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { SingleGameLightComponent } from './single-game-light/single-game-light.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewGameComponent } from './new-game/new-game.component';


@NgModule({
  declarations: [
    AppComponent,
    SinglegameComponent,
    GameListComponent,
    HeaderComponent,
    LandingPageComponent,
    SingleGameLightComponent,
    NewGameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
      { provide: LOCALE_ID, useValue: 'fr-FR'}
    ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    registerLocaleData(fr.default);
  }
}
