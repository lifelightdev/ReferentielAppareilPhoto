import {inject, TestBed, getTestBed } from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {HttpClientModule, HttpErrorResponse, HttpEvent, HttpEventType, HttpRequest} from '@angular/common/http';
import { appareilsUrl, AppareilService } from './appareil.service';

describe('Appareil Service', () => {
  // let injector: TestBed;
  // let service: AppareilService;
  // let backend: HttpTestingController;

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
      providers: [ AppareilService ],
    });
    // injector = getTestBed();
    // service = injector.get(AppareilService);
    // backend = injector.get(HttpTestingController);
  });

  // afterEach(() => {
  //   backend.verify();
  // });

  it(
    'should get users',
    inject(
      [HttpTestingController, AppareilService],
      (httpMock: HttpTestingController, dataService: AppareilService) => {
        const mockUsers = [
          { name: 'Bob', website: 'www.yessss.com' },
          { name: 'Juliette', website: 'nope.com' }
        ];

        dataService.findAll().subscribe((event: HttpEvent<any>) => {
          switch (event.type) {
            case HttpEventType.Response:
              expect(event.body).toEqual(mockUsers);
          }
        });

        const mockReq = httpMock.expectOne(appareilsUrl);

        expect(mockReq.cancelled).toBeFalsy();
        expect(mockReq.request.responseType).toEqual('json');
        mockReq.flush(mockUsers);

        httpMock.verify();
      }
    )
  );

   /* it('should be created', () => {
     expect(service).toBeTruthy();
   });

   it('should call the GET appareils api and return all results', () => {
     let actualDataAll = {};

     service.findAll().subscribe(data => (actualDataAll = data));

     const req = backend.expectOne(`http://localhost:8080/Appareil`);
     expect(req.request.method).toBe("GET");
     req.flush(expectedDataAll);

     /*backend
       .expectOne((req: HttpRequest<any>) => {
         return req.url === `${'http://localhost:8080/Appareil'}` && req.method === 'GET';
       }, `GET all appareil data from ${'http://localhost:8080/Appareil'}`)
       .flush(expectedDataAll);

     expect(actualDataAll).toEqual(expectedDataAll);*/
  // });

});
