import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AppareilListComponent } from './appareil-list.component';
import { AppareilService } from '../appareil.service';
import {Appareil} from '../appareil';

import {HttpClient} from '@angular/common/http';

describe('AppareilListComponent', () => {
  let component: AppareilListComponent;
  let fixture: ComponentFixture<AppareilListComponent>;

  let service: AppareilService;

  jest.mock('@angular/common/http');

  const httpClient = new HttpClient(null);


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [ AppareilService ],
      declarations: [ AppareilListComponent ]
    })
      .compileComponents();
    service = TestBed.get(AppareilService);
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppareilListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
