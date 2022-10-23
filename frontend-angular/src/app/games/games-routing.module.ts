import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GameListComponent } from "./components/game-list/game-list.component";
import { NewGameComponent } from "./components/new-game/new-game.component";
import { SinglegameComponent } from "./components/single-game/singlegame.component";

const routes:Routes =[
    {path:'create', component: NewGameComponent},
    {path:':id', component: SinglegameComponent},
    {path:'', component: GameListComponent }
]


@NgModule({
    imports:[
        RouterModule.forChild(routes)
    ],
    exports:[RouterModule]
})

export class GameRoutingModule{}
