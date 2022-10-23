import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../../services/users.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.scss']
})
export class UserprofileComponent implements OnInit {

  
  userId?:string;
  
  
  
  constructor(public usersService:UsersService, private router:Router) { }
  
  ngOnInit(): void {

  }

  onClick():void{
       this.router.navigateByUrl('userprofile/update');
  }




}
