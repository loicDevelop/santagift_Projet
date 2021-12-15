import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageListGiftComponent } from './page-list-gift.component';

describe('PageListGiftComponent', () => {
  let component: PageListGiftComponent;
  let fixture: ComponentFixture<PageListGiftComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageListGiftComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageListGiftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
