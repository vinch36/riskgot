import { Injectable } from '@angular/core'
import { Game } from '../models/game.model'

@Injectable({ providedIn: 'root' })

export class GamesService {


  games: Game[] = [{
    id: 1,
    title: 'Archibald',
    description: 'Mon meilleur ami depuis tout petit !',
    imageUrl: 'https://cdn.pixabay.com/photo/2015/05/31/16/03/teddy-bear-792273_1280.jpg',
    createdDate: new Date(),
    likes: 121
  },
  {
    id: 2,
    title: 'Three Rock Mountain',
    description: 'Un endroit magnifique pour les randonnées.',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Three_Rock_Mountain_Southern_Tor.jpg/2880px-Three_Rock_Mountain_Southern_Tor.jpg',
    createdDate: new Date(),
    likes: 12
  },
  {
    id: 3,
    title: 'Un bon repas',
    description: 'Mmmh que c\'est bon !',
    imageUrl: 'https://wtop.com/wp-content/uploads/2020/06/HEALTHYFRESH.jpg',
    createdDate: new Date(),
    likes: 203,
    location: 'A la maison'
  }
  ];

  getAllGames(): Game[] {
    return this.games;
  }

  getGameById(gameId: number): Game {
    const game = this.games.find(game => game.id === gameId);
    if (game) {
      return game;
    }
    else {
      throw new Error("Game not found!");
    }
  }

  addGame(formValue: { title: string, description: string, imageUrl: string, location?: string }):void
  {
    const game:Game = {
      ...formValue,
      likes:0,
      createdDate:new Date(),
      id: this.games[this.games.length-1].id + 1
    }
    this.games.push(game);
  }


  likeGameById(gameId: number, likeType: 'like' | 'unlike'): void {
    const game = this.getGameById(gameId);
    likeType === 'like' ? game.likes++ : game.likes--;
  }
}
