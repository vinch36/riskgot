import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HealthCheck } from '../models/healthcheck.model';
import {environment} from '../../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class HealthcheckService {


  SERVER_URL: string = environment.serverUrl;


  constructor(private http:HttpClient) { }

  getHealthCheck(): Observable<HealthCheck> {
    return this.http.get<HealthCheck>(this.SERVER_URL + 'healthcheck');
  }
}
