import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core'
import { map, Observable, switchMap } from 'rxjs';
import { Game } from '../models/game.model'

@Injectable({ providedIn: 'root' })

export class GamesService {


  constructor(private http:HttpClient){}


  getAllGames(): Observable<Game[]> {
    
    return this.http.get<Game[]>('http://localhost:9001/game');
  }

  getGameById(gameId: number): Observable<Game> {
   return this.http.get<Game>(`http://localhost:9001/game/${gameId}`);
  }

  addGame(formValue: { title: string, description: string, imageUrl: string, location?: string }):Observable<Game> 
  {
    return this.http.post<Game>('http://localhost:9001/game',{
      ...formValue,
      createdDate: new Date(),
      numberOfPlayers: 0,
      currentNumberOfPlayers: 0,
      likes:0      
    });
  }


  likeGameById(gameId: number, likeType: 'like' | 'unlike'): Observable<Game> {
    return this.getGameById(gameId).pipe(
      map(game => ({
        ...game,
        likes: game.likes + (likeType === 'like' ? 1 : -1)
      })),
      switchMap(updatedGame => this.http.put<Game>(`http://localhost:9001/game/${gameId}`, updatedGame))
    );

  }
}
