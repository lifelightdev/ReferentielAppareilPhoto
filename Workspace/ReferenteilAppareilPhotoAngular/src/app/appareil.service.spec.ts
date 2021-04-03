import { inject, TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { appareilsUrl, AppareilService } from './appareil.service';

describe('Appareil Service', () => {
  let service: AppareilService;
  let backend: HttpTestingController;

  const expectedDataAll = [
    {id: 1, modeEmploie: 1, modele: 1},
    {id: 2, modeEmploie: 2, modele: 2},
    {id: 3, modeEmploie: 1, modele: 3}
  ];
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    backend = TestBed.get(HttpTestingController);
    service = TestBed.get(AppareilService);
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

  it('should call the GET appareils api and return all results', () => {
     let actualDataAll = {};
     service.findAll().subscribe(data => (actualDataAll = data));
     const req = backend.expectOne(appareilsUrl);
     expect(req.request.method).toBe("GET");
     req.flush(expectedDataAll);
     expect(actualDataAll).toEqual(expectedDataAll);
  });
});
