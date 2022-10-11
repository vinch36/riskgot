import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { Game } from '../../../core/models/game.model';
import { GamesService } from '../../../core/services/games.service';

@Component({
  selector: 'app-singlegame',
  templateUrl: './singlegame.component.html',
  styleUrls: ['./singlegame.component.scss']
})
export class SinglegameComponent implements OnInit {


  game$!:Observable<Game>;


  likeButtonText!:string;
  alreadyLiked!:boolean;

  constructor(private gamesService:GamesService, private route:ActivatedRoute) {

    }

  ngOnInit(): void {
      this.likeButtonText = 'Like'
      this.alreadyLiked = false;
      const gameId=+this.route.snapshot.params['id'];
      this.game$ = this.gamesService.getGameById(gameId);
    
  }

  onLike(gameId: number) {
    if (!this.alreadyLiked){
    this.game$=this.gamesService.likeGameById(gameId,'like').pipe(
      tap(()=>this.likeButtonText='Unlike')
    );
    
    }
    else{
      this.game$=this.gamesService.likeGameById(gameId,'unlike').pipe(
        tap(()=>this.likeButtonText='Like')
      );
    }
    this.alreadyLiked=!this.alreadyLiked;
  }



}
