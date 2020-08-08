import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appareil } from './appareil';
import { HttpClient} from '@angular/common/http';

export const appareilsUrl = 'http://localhost:8080/Appareil'; // URL to web api

@Injectable({
  providedIn: 'root'
})
export class AppareilService {

  constructor(private http: HttpClient) {
  }  

  findAll(): Observable<Appareil[]> {
    return this.http.get<Appareil[]>(appareilsUrl);
  }

}

