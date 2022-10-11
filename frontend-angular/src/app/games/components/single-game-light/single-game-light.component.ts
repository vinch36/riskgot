import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from '../../../core/models/game.model';
import { GamesService } from '../../../core/services/games.service';

@Component({
  selector: 'app-single-game-light',
  templateUrl: './single-game-light.component.html',
  styleUrls: ['./single-game-light.component.scss']
})
export class SingleGameLightComponent implements OnInit {
  @Input() game!: Game;


  snapButtonText!:string;
  alreadyLiked!:boolean;

  constructor(private gamesService:GamesService, private router :Router) {

    }

  ngOnInit(): void {
      this.snapButtonText = 'Like'
      this.alreadyLiked = false;
  }

  onAddSnap():void {
    if (!this.alreadyLiked){
    this.gamesService.likeGameById(this.game.id,'unlike');
    this.snapButtonText='Unlike'
    }
    else{
      this.gamesService.likeGameById(this.game.id, 'like');
      this.snapButtonText='Like'
    }
    this.alreadyLiked=!this.alreadyLiked;
  }

  onViewGame():void{
    this.router.navigateByUrl(`games/${this.game.id}`);
  }
}
