import { Injectable } from '@angular/core';
import {Observable } from 'rxjs';
import { Appareil } from './appareil';
import {HttpClient, HttpErrorResponse, HttpRequest} from '@angular/common/http';
import { of } from 'rxjs';
import { catchError } from 'rxjs/operators';

export const appareilsUrl = 'http://localhost:8080/Appareil'; // URL to web api

@Injectable()
export class AppareilService {

  // private appareilsUrl: string;

  constructor(private http: HttpClient) {
    // this.appareilsUrl = 'http://localhost:8080/Appareil';
  }

  // public findAll(): Observable<Appareil[]> {
  findAll() {
    const req = new HttpRequest('GET', appareilsUrl, {
      reportProgress: true
    });

    return this.http.request(req);

    // return this.http.get<Appareil[]>(this.appareilsUrl);
    /* return this.http.get<Appareil[]>(appareilsUrl)
      .pipe(
        catchError(err => this.handleError(err, 'getAppareil')),
      );
      */
  }

  /*public save(appareil: Appareil) {
    return this.http.post<Appareil>(this.appareilsUrl, appareil);
  }*/

  handleError(error: HttpErrorResponse, methodName: string): Observable<any> {
    console.error(`${methodName} failed due to ${error.message}`);
    return of(undefined);
  }
}

