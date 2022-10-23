import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { map, Observable, switchMap, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserBackend } from '../models/userbackend.model';

@Injectable({
  providedIn: 'root'
})
export class AuthbackendService {

  SERVER_URL: string = environment.serverUrl;



  constructor(private auth: AuthService, private http: HttpClient) {
    
    this.auth.isAuthenticated$.pipe(
      tap(isAuth => {
        if (isAuth){
          this.loginToBackend().subscribe()
          }}))
        .subscribe();
  }

  isAuth$!: Observable<boolean>

  login(): Observable<any> {
    return this.auth.loginWithRedirect();
  }

  private loginToBackend() :Observable<UserBackend>{
    return this.http.post<any>(this.SERVER_URL + 'login', {
    });
  }


  private logoutFromBackend() {
    return this.http.post<any>(this.SERVER_URL + 'logout', {

    });
  }
}


