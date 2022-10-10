import { Component, OnDestroy, OnInit } from '@angular/core';
import { interval, tap , takeUntil, Subject } from 'rxjs';
import { Game } from '../models/game.model';
import { GamesService } from '../services/games.service';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.scss']
})
export class GameListComponent implements OnInit, OnDestroy {


  games!:Game[];

  private destroy$!:Subject<boolean>;

  constructor(private gamesService:GamesService) { }

  ngOnInit(): void {
    this.destroy$=new Subject<boolean>();
    this.games = this.gamesService.getAllGames();


    interval(1000).pipe(
      takeUntil(this.destroy$),
      tap(console.log)
    ).subscribe();
  }

  ngOnDestroy(){
    this.destroy$.next(true);
  }

}
