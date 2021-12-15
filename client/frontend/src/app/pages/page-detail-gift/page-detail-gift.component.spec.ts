import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageDetailGiftComponent } from './page-detail-gift.component';

describe('PageDetailGiftComponent', () => {
  let component: PageDetailGiftComponent;
  let fixture: ComponentFixture<PageDetailGiftComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageDetailGiftComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageDetailGiftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
