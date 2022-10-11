import { Component, OnDestroy, OnInit } from '@angular/core';
import { interval, tap , takeUntil, Subject, Observable } from 'rxjs';
import { Game } from '../../../core/models/game.model';
import { GamesService } from '../../../core/services/games.service';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.scss']
})
export class GameListComponent implements OnInit, OnDestroy {


  games$!:Observable<Game[]>;

  private destroy$!:Subject<boolean>;

  constructor(private gamesService:GamesService) { }

  ngOnInit(): void {
   
    //this.games = this.gamesService.getAllGames();
    this.games$=this.gamesService.getAllGames();
  }

  ngOnDestroy(){
  }

}
