import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { APP_BASE_HREF, LocationStrategy, HashLocationStrategy } from '@angular/common';
import { HomeComponent } from './modules/home/home.component';
import { LeftPanelComponent } from './shared/left-panel/left-panel.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { MainComponent } from './shared/main/main.component';
import { HttpClientModule } from '@angular/common/http';
import { LoaderComponent } from './shared/loader/loader.component';
import { ButtonModule } from '../../node_modules/primeng/button'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LeftPanelComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    LoaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ButtonModule
  ],
  providers: [
    {provide: APP_BASE_HREF, useValue:'/'},
    {provide: LocationStrategy, useClass:HashLocationStrategy}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
