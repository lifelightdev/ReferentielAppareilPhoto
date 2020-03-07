import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable } from 'rxjs';
import { Appareil } from './appareil';

@Injectable()
export class AppareilServiceService {

  private appareilsUrl: string;

  constructor(private http: HttpClient) {
    this.appareilsUrl = 'http://localhost:8080/Appareil';
  }

  public findAll(): Observable<Appareil[]> {
    return this.http.get<Appareil[]>(this.appareilsUrl);
  }

  public save(appareil: Appareil) {
    return this.http.post<Appareil>(this.appareilsUrl, appareil);
  }
}

