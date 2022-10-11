import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable, tap } from 'rxjs';
import { Game } from '../../../core/models/game.model';
import { GamesService } from '../../../core/services/games.service';

@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrls: ['./new-game.component.scss']
})
export class NewGameComponent implements OnInit {


  gameForm!: FormGroup;


  gamePreview$!: Observable<Game>;
  urlRegex!: RegExp;

  constructor(private gamesService:GamesService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit(): void {
    this.urlRegex = /(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_+.~#?&/=]*)/;
    this.gameForm = this.formBuilder.group(
      {
        title: [null, Validators.required],
        description: [null, Validators.required],
        imageUrl: [null, [Validators.required, Validators.pattern(this.urlRegex)]],
        location: [null]
      }, { updateOn: 'blur' });
    this.gamePreview$ = this.gameForm.valueChanges.pipe(
      map(formValue => ({
        ...formValue,
        createdDate: new Date(),
        likes: 0,
        id: 0
      }))
    );

  }


  onSubmitForm(): void {
    this.gamesService.addGame(this.gameForm.value).pipe(
      tap(()=>this.router.navigateByUrl('/games'))
    ).subscribe();
    
  }

}
