import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { APP_BASE_HREF, LocationStrategy, HashLocationStrategy, PathLocationStrategy } from '@angular/common';
import { HomeComponent } from './modules/home/home.component';
import { LeftPanelComponent } from './shared/left-panel/left-panel.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { LoaderComponent } from './shared/loader/loader.component';
import { ButtonModule } from '../../node_modules/primeng/button';
import { CardModule } from '../../node_modules/primeng/card';
import { ContactComponent } from './modules/pages/contact/contact.component';
import { ClimateComponent } from './modules/pages/climate/climate.component';
import { ErrorComponent } from './modules/pages/error/error.component'

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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ButtonModule,
    CardModule
  ],
  providers: [
    {provide: APP_BASE_HREF, useValue:'/'},
    {provide: LocationStrategy, useClass:PathLocationStrategy}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
