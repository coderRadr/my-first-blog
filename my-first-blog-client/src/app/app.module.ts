import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MultiSelectModule} from 'primeng/multiselect';
import { APP_BASE_HREF, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { HomeComponent } from './modules/home/home.component';
import { LeftPanelComponent } from './shared/left-panel/left-panel.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { LoaderComponent } from './shared/loader/loader.component';
import { ButtonModule } from '../../node_modules/primeng/button';
import { CardModule } from '../../node_modules/primeng/card';
import { AccordionModule } from '../../node_modules/primeng/accordion';
import { PaginatorModule } from '../../node_modules/primeng/paginator';
import { ContactComponent } from './modules/pages/contact/contact.component';
import { ClimateComponent } from './modules/pages/climate/climate.component';
import { ErrorComponent } from './modules/pages/error/error.component';
import { NewsComponent } from './modules/pages/news/news.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LeftPanelComponent,
    HeaderComponent,
    FooterComponent,
    LoaderComponent,
    ContactComponent,
    ClimateComponent,
    ErrorComponent,
    NewsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ButtonModule,
    CardModule,
    AccordionModule,
    PaginatorModule,
    MultiSelectModule,
    BrowserAnimationsModule
  ],
  providers: [
    {provide: APP_BASE_HREF, useValue:'/'},
    {provide: LocationStrategy, useClass:PathLocationStrategy}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
