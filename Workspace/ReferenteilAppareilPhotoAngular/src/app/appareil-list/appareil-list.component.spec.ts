import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AppareilListComponent } from './appareil-list.component';
import { AppareilService } from '../appareil.service';

import {HttpClient, HttpHandler} from '@angular/common/http';

describe('AppareilListComponent', () => {
  let component: AppareilListComponent;
  let fixture: ComponentFixture<AppareilListComponent>;
  let service: AppareilService;

  jest.mock('@angular/common/http');  
    
  
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [ AppareilService, HttpClient, HttpHandler ],
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

  it('should create AppareilListComponent', () => {
    expect(component).toBeTruthy();
  });
});