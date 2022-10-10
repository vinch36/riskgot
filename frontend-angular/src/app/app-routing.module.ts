import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameListComponent } from './game-list/game-list.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { NewGameComponent } from './new-game/new-game.component';
import { SinglegameComponent } from './singlegame/singlegame.component';

const routes: Routes = [
{path:'games/:id', component: SinglegameComponent},
{path:'games', component: GameListComponent },
{path:'create', component: NewGameComponent },
{path:'', component: LandingPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
