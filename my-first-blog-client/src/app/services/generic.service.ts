import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GenericService {
  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) { }
  
  private commonHeader() {
    let trackingId: string = new Date().getTime().toString();
    this.httpHeaders = new HttpHeaders({
        'Content-Type':  'application/json',
        'Accept':'application/json',
        'trackingId': trackingId,
      });
  }
  
  public getHeaderDetails(): Observable<any> {
    this.commonHeader();
    const options = {
      headers: this.httpHeaders
    }
    return this.http.get('/details', options);
  }

  public contactDetails(): Observable<any> {
    this.commonHeader();
    const options = {
      headers: this.httpHeaders
    }
    return this.http.get('/data/contact', options);
  }

  public getGeoLocation(): Observable<any>
  {
    return this.http.get('../../assets/cityList.json');
  }

  getClimateDetails(latitude: string, longitude: string, cityName: string): Observable<any> {
    this.commonHeader();
    const options = {headers: this.httpHeaders}
    return this.http.get('/weather/current/latitude/'+latitude+'/longitude/'+longitude+'/cityName/'+cityName, options);
  }

  getNews(): Observable<any> {
    this.commonHeader();
    const options = {headers: this.httpHeaders}
    return this.http.get('/data/cryptoNews', options);
  }

}
