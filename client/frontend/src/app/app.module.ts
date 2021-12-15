import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageListGiftComponent } from './src/app/pages/page-list-gift/page-list-gift.component';
import { PageDetailGiftComponent } from './pages/page-detail-gift/page-detail-gift.component';

@NgModule({
  declarations: [
    AppComponent,
    PageListGiftComponent,
    PageDetailGiftComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
