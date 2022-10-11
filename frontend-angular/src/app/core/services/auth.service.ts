import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private token:string= 'myfaketoken';
  constructor() { }


  getToken():string
  {
    return this.token;

  }
}
