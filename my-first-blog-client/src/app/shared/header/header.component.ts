import { Component, OnInit } from '@angular/core';
import { GenericService } from 'src/app/services/generic.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  private headerDetails: string[] = [];
  private showLoader: boolean;
  constructor(private headerService: GenericService) { }

  ngOnInit() {
    this.showLoader = true;
    this.headerService.getHeaderDetails().subscribe(res=>{
      this.headerDetails.push(...res);
      console.log("response from server:: "+ JSON.stringify(this.headerDetails));
      this.showLoader=false;
    })
  }
  sendEvent(event){
    console.log('event ', JSON.stringify(event));
  }

}
