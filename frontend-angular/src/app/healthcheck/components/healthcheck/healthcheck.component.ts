import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { interval, map, mergeMap, Observable, Subject, take, takeUntil } from 'rxjs';
import { HealthCheck } from '../../models/healthcheck.model';
import { HealthcheckService } from '../../services/healthcheck.service';

@Component({
  selector: 'app-healthcheck',
  templateUrl: './healthcheck.component.html',
  styleUrls: ['./healthcheck.component.scss']
})
export class HealthCheckComponent implements OnInit, OnDestroy {


  interval$!: Observable<number>
  private destroy$!: Subject<boolean>;

  healthCheck$!: Observable<HealthCheck>;
  constructor(private router:Router, private healthCheckService: HealthcheckService) { }

  ngOnInit(): void {
    this.destroy$ = new Subject<boolean>();
    this.healthCheck$ = this.healthCheckService.getHealthCheck();

    this.interval$ = interval(1000);
    this.interval$.pipe(
      takeUntil(this.destroy$),
      mergeMap(() => this.healthCheck$ = this.healthCheckService.getHealthCheck())
    ).subscribe();
  }

  onClickBack(){
    this.router.navigateByUrl('/');
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
  }

}


