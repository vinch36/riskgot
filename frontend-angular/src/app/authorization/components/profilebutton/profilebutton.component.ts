import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-profilebutton',
  templateUrl: './profilebutton.component.html',
  styleUrls: ['./profilebutton.component.scss']
})
export class ProfilebuttonComponent implements OnInit {

  constructor(public auth:AuthService, private router:Router) { }

  ngOnInit(): void {
    
  }

  onClickProfile():void{
    this.router.navigateByUrl('/userprofile');
  }


}
