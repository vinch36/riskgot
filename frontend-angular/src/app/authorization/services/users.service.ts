import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService, User } from '@auth0/auth0-angular';
import { map, Observable, switchMap, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserBackend } from '../models/userbackend.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  SERVER_URL: string = environment.serverUrl;
  public userBackend$!:Observable<UserBackend>
  public userBackend!:UserBackend;
  
  constructor(private http:HttpClient, private authorizationService:AuthService) { 
    
    this.userBackend$ = this.authorizationService.getUser().pipe(
      tap(user=> console.log(user?.email)),
      switchMap(user=>this.http.get<UserBackend>(this.SERVER_URL +'users/'+ user?.email).pipe(
        tap(userBackend=>this.userBackend=userBackend)
      )));
      
  }


  public updateUser(formValue:{nickname:string, imageUrl?:string}):Observable<UserBackend>
  {
    return this.http.put<UserBackend>(this.SERVER_URL +'users/'+ this.userBackend.email,{
      ...formValue
    });

  }

  

  


}
