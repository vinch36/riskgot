import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/components/landing-page/landing-page.component';
import { HealthCheckComponent } from './healthcheck/components/healthcheck/healthcheck.component';
import { UserprofileComponent } from './authorization/components/userprofile/userprofile.component';
import { AuthGuard } from '@auth0/auth0-angular';
import { UpdateUserprofileComponent } from './authorization/components/update-userprofile/update-userprofile.component';

const routes: Routes = [
  {path: 'games', loadChildren: () => import('./games/games.module').then(m => m.GamesModule), canActivate: [AuthGuard]},
  {path:'', component: LandingPageComponent},
  {path:'healthcheck', component: HealthCheckComponent, canActivate: [AuthGuard]},
  {path:'userprofile/update', component:UpdateUserprofileComponent,canActivate: [AuthGuard]},
  {path:'userprofile', component:UserprofileComponent,canActivate: [AuthGuard]}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
