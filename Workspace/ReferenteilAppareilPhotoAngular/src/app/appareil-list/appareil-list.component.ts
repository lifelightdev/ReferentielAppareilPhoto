import { Component, OnInit } from '@angular/core';
import { AppareilService } from '../appareil.service';
import { Appareil } from '../appareil';

@Component({
  selector: 'app-appareil-list',
  templateUrl: './appareil-list.component.html',
  styleUrls: ['./appareil-list.component.css']
})
export class AppareilListComponent implements OnInit {

  constructor(private appareilService: AppareilService) { }

  appareils: Appareil[];
  ngOnInit(): void {
    this.appareilService.findAll().subscribe(data => {
      this.appareils = data;
    });
  }

}
