import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { GenericService } from 'src/app/services/generic.service';
import { cityList } from './cityList';

@Component({
  selector: 'app-climate',
  templateUrl: './climate.component.html',
  styleUrls: ['./climate.component.scss']
})
export class ClimateComponent implements OnInit {
  @Output() error = new EventEmitter<boolean>();
  latitude: string;
  longitude: string;
  selectedCityName: string;
  selectedCountry: string;
  countryNames: string[] = [];
  cityNames: string[] = [];
  showLoader: boolean;
  errorFlag: boolean;
  temperature: string;
  feelsLike: string;
  weatherCondition: string;
  windSpeed: string;
  stateName: string;
  citiesJson: cityList[] = [];

  constructor(private service: GenericService) { }

  ngOnInit() {
    this.showLoader = true;
    this.service.getGeoLocation().subscribe((res: cityList[])=>{
      this.citiesJson = res;
      this.populateCityDropdown(this.citiesJson);
    });
  }
  populateCityDropdown(citiesResponse: cityList[]){
    citiesResponse.forEach(res=>{
      if(!this.countryNames.includes(res.country) && res.country !== "")
      this.countryNames.push(res.country);
    });
    console.log('country names:: '+ this.countryNames);
    this.showLoader = false;
  }

  onCountrySelection(event){
    this.showLoader = true;
    this.selectedCountry = event;
    this.cityNames = [];
    this.selectedCityName = "";
    var index = this.citiesJson.findIndex(src => src.country === this.selectedCountry);
    this.citiesJson[index].cities.forEach(src=>{
      this.cityNames.push(src.cityName);
    })
    this.showLoader = false;
  }

  onCityChange(event){
    this.showLoader = true;
    this.selectedCityName = event;
    var index = this.citiesJson.findIndex(src => src.country === this.selectedCountry);
    if(index != -1){
      var cityIndex = this.citiesJson[index].cities.findIndex(src => src.cityName === this.selectedCityName);
      if(cityIndex != -1){
        this.latitude = this.citiesJson[index].cities[cityIndex].latitude;
        this.longitude = this.citiesJson[index].cities[cityIndex].longitude;
        this.service.getClimateDetails(this.latitude, this.longitude, this.selectedCityName).subscribe(res=>{
          this.stateName = res.cityName;
          this.temperature = res.temp_f;
          this.weatherCondition = res.wx_desc;
          this.windSpeed = res.windspd_kmh;
          console.log(res);
          this.showLoader = false;
        }, err=>{
          this.errorFlag = true;
          this.sendErrorFlag(this.errorFlag);
          this.showLoader = false;
        });
      }else{
        this.showLoader = false;
        this.errorFlag = true;
        this.sendErrorFlag(this.errorFlag);
      }
    }else{
      this.showLoader = false;
      this.errorFlag = true;
      this.sendErrorFlag(this.errorFlag);
    }
  }
  sendErrorFlag(flag: boolean){
    this.error.emit(flag);
  }

}
