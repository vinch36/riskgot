import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Game } from '../models/game.model';
import { GamesService } from '../services/games.service';

@Component({
  selector: 'app-singlegame',
  templateUrl: './singlegame.component.html',
  styleUrls: ['./singlegame.component.scss']
})
export class SinglegameComponent implements OnInit {


  @Input() game!: Game;


  snapButtonText!:string;
  alreadyLiked!:boolean;

  constructor(private gamesService:GamesService, private route:ActivatedRoute) {

    }

  ngOnInit(): void {
      this.snapButtonText = 'Like'
      this.alreadyLiked = false;
      if (!this.game){
      const gameId=+this.route.snapshot.params['id'];
      this.game = this.gamesService.getGameById(gameId);
    }
  }

  onLike() {
    if (!this.alreadyLiked){
    this.gamesService.likeGameById(this.game.id,'like');
    this.snapButtonText='Unlike'
    }
    else{
      this.gamesService.likeGameById(this.game.id, 'unlike');
      this.snapButtonText='Like'
    }
    this.alreadyLiked=!this.alreadyLiked;
  }



}
