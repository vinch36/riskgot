import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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


  constructor(private gamesService:GamesService, private router:Router) { }

  ngOnInit(): void {
    this.games$=this.gamesService.getAllGames();
  }

  ngOnDestroy(){
  }

  onCreateGame(){
    this.router.navigateByUrl('/games/create');


  }

}
