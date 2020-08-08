import { inject, TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { HttpClientModule, HttpErrorResponse, HttpEvent, HttpEventType, HttpRequest} from '@angular/common/http';
import { appareilsUrl, AppareilService } from './appareil.service';
import { HttpClient, HttpHandler } from '@angular/common/http';

describe('Appareil Service', () => {
  let service: AppareilService;
  let injector: TestBed;
  let backend: HttpTestingController;
  const expectedData = { id: 1,
    modeEmploie: 1,
    modele: 1 };

  const expectedDataAll = [
    {id: 1, modeEmploie: 1, modele: 1},
    {id: 2, modeEmploie: 2, modele: 2},
    {id: 3, modeEmploie: 1, modele: 3}
  ];
    beforeEach(() => {
    TestBed.configureTestingModule({      
      imports: [ HttpClientTestingModule ],
      providers: [ AppareilService, HttpClient, HttpHandler ]
    });
    injector = getTestBed();
    service = injector.get(AppareilService);
    backend = injector.get(HttpTestingController);
  });

   afterEach(() => {
     backend.verify();
   });

  it('should be created AppareilService', () => {
    expect(service).toBeDefined;
  });   

  it('should be created', () => {
     expect(service).toBeTruthy();
   });

  /*it('should call the GET appareils api and return all results', () => {
     let actualDataAll = {};

     service.findAll().subscribe(data => (actualDataAll = data));

     const req = backend.expectOne(appareilsUrl);
     expect(req.request.method).toBe("GET");
     req.flush(expectedDataAll);

     backend
       .expectOne((req: HttpRequest<any>) => {
         return req.url === `${'http://localhost:8080/Appareil'}` && req.method === 'GET';
       }, `GET all appareil data from ${'http://localhost:8080/Appareil'}`)
       .flush(expectedDataAll);

     expect(actualDataAll).toEqual(expectedDataAll);
  });*/

});


