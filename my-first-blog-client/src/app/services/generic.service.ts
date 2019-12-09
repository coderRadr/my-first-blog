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
      console.log("headers:: "+ JSON.stringify(this.httpHeaders), trackingId);
  }
  
  public getHeaderDetails(): Observable<any> {
    this.commonHeader();
    const options = {
      headers: this.httpHeaders
    }
    return this.http.get('/details', options);
  }
}
