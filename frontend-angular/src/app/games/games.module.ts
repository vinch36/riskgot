import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SinglegameComponent } from './components/single-game/singlegame.component';
import { GameListComponent } from './components/game-list/game-list.component';
import { SingleGameLightComponent } from './components/single-game-light/single-game-light.component';
import { NewGameComponent } from './components/new-game/new-game.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { GameRoutingModule } from './games-routing.module';



@NgModule({
  declarations: [
    SinglegameComponent,
    GameListComponent,
    SingleGameLightComponent,
    NewGameComponent
],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    GameRoutingModule
  ],
  exports:[
    SinglegameComponent,
    GameListComponent,
    SingleGameLightComponent,
    NewGameComponent
  ]
})
export class GamesModule { }
