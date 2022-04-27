import { TestBed } from '@angular/core/testing';

import { eventService } from './event.service';

describe('eventService', () => {
  let service: eventService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(eventService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
