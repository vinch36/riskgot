import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from 'src/app/authorization/services/users.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private router:Router, public usersService: UsersService) { }

  ngOnInit(): void {
  }


  onAddNewGame(){
    this.router.navigateByUrl('/games/create');
  }



}
