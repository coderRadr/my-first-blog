import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { GenericService } from 'src/app/services/generic.service';

@Component({
  selector: 'app-climate',
  templateUrl: './climate.component.html',
  styleUrls: ['./climate.component.scss']
})
export class ClimateComponent implements OnInit {
  @Output() error = new EventEmitter<boolean>();
  latitude: string;
  longitude: string;
  showLoader: boolean;
  errorFlag: boolean;
  temperature: string;
  feelsLike: string;
  weatherCondition: string;
  windSpeed: string;
  stateName: string;

  constructor(private service: GenericService) { }

  ngOnInit() {
    this.showLoader = true;
    this.service.getGeoLocation().then(pos=>{
      console.log('position is:: ', pos.lng,' ', pos.lat);
      this.latitude = pos.lat;
      this.longitude = pos.lng;
      this.service.getClimateDetails(this.latitude, this.longitude).subscribe(res=>{
        this.temperature = res.temp_f;
        this.feelsLike = res.feelslike_f;
        this.windSpeed = res.windspd_kmh;
        this.weatherCondition = res.wx_desc;
        this.stateName = res.cityName;
        this.showLoader = false;
        this.errorFlag = false;
      }, err =>{
        this.sendErrorFlag(true);
        this.showLoader=false;  
      });
    },err=>{
      this.sendErrorFlag(true);
      this.showLoader=false;
    });

  }
  sendErrorFlag(flag: boolean){
    this.error.emit(flag);
  }

}
