import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core'
import { map, Observable, switchMap } from 'rxjs';
import { Game } from '../models/game.model'
import {environment} from '../../../environments/environment'
@Injectable({ providedIn: 'root' })

export class GamesService {

  SERVER_URL: string = environment.serverUrl;
  constructor(private http:HttpClient){}


  getAllGames(): Observable<Game[]> {

    return this.http.get<Game[]>(this.SERVER_URL + 'games');
  }

  getGameById(gameId: number): Observable<Game> {
   return this.http.get<Game>(this.SERVER_URL + `games/${gameId}`);
  }

  addGame(formValue: { title: string,gameMode:string, numberOfPlayers: number,description?:string, imageUrl?: string, }):Observable<Game>
  {
    return this.http.post<Game>(this.SERVER_URL + 'games',{
      ...formValue,
    });
  }


  likeGameById(gameId: number, likeType: 'like' | 'unlike'): Observable<Game> {
    return this.getGameById(gameId).pipe(
      map(game => ({
        ...game,
        likes: game.likes + (likeType === 'like' ? 1 : -1)
      })),
      switchMap(updatedGame => this.http.put<Game>(this.SERVER_URL + `games/${gameId}`, updatedGame))
    );

  }
}
