import { TestBed } from '@angular/core/testing';

import { AppareilServiceService } from './appareil-service.service';

describe('AppareilServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AppareilServiceService = TestBed.get(AppareilServiceService);
    expect(service).toBeTruthy();
  });
});
