import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { headerModel } from 'src/app/shared/header/headerModel';
import { GenericService } from 'src/app/services/generic.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private showLoader: boolean;
  private headerModels: headerModel[] = [];
  componentToLoad: string;
  errorFlag: boolean;
  constructor(private headerService: GenericService) { }

  ngOnInit() {
    this.showLoader = true;
    this.headerService.getHeaderDetails().subscribe(res=>{
      res.forEach(model => {
        this.headerModels.push({name: model.name,code: model.code,isRendered: false});
      });
      this.showLoader=false;
    })
  }
  getComponentName(cModel: headerModel){
    this.headerModels.forEach(src=>{
      if(src.code===cModel.code){
        src.isRendered=true;
      }else{
        src.isRendered = false;
      }
    });
  }

  showError(flag: boolean){
    this.errorFlag = flag;
  }

}
