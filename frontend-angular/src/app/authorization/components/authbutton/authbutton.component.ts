import { Component, Inject, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { Observable, switchMap, tap } from 'rxjs';
import { AuthbackendService } from '../../services/authbackend.service';
import { UsersService } from '../../services/users.service';

@Component({
  selector: 'app-authbutton',
  templateUrl: './authbutton.component.html',
  styleUrls: ['./authbutton.component.scss']
})
export class AuthbuttonComponent implements OnInit {

  // Inject the authentication service into your component through the constructor
  
  
  
  constructor(public auth: AuthService, public authBackendService:AuthbackendService) {}



  ngOnInit(): void {
    
  }


  onClickLogin()
  {
    this.authBackendService.login().subscribe();
    
  }

}
