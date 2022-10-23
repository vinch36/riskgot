import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable, tap } from 'rxjs';
import { UserBackend } from '../../models/userbackend.model';
import { UsersService } from '../../services/users.service';

@Component({
  selector: 'app-update-userprofile',
  templateUrl: './update-userprofile.component.html',
  styleUrls: ['./update-userprofile.component.scss']
})
export class UpdateUserprofileComponent implements OnInit {


  userForm!: FormGroup;

  urlRegex!: RegExp;

  userProfilePreview$!: Observable<UserBackend>

  constructor(private usersService: UsersService, private fromBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.urlRegex = /(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_+.~#?&/=]*)/;

    this.userForm = this.fromBuilder.group(
      {
        nickname: [null, Validators.required],
        picture: [null, [Validators.pattern(this.urlRegex)]]
      },
      { updateOn: 'change' });

    this.userProfilePreview$ = this.userForm.valueChanges.pipe(
      map(formValue => ({
        ...formValue
      }))
    );

  }

  onSubmitForm(): void {
    this.usersService.updateUser(this.userForm.value).pipe(
      tap(() => this.router.navigateByUrl('/userprofile'))
    ).subscribe();

  }



}
