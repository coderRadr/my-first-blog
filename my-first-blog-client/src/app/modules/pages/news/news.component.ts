import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { GenericService } from 'src/app/services/generic.service';
import { newsResponse } from './newsResponse';
import { source } from './source';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {
  showLoader: boolean;
  @Output() error = new EventEmitter<boolean>();
  category: string[] = [];
  sources: source[] = [];
  sourcesToShow: source[] = [];
  errorFlag: boolean;
  totalRecords: number;

  constructor(private service: GenericService) { }

  ngOnInit() {
    this.showLoader = true;
    this.service.getNews().subscribe((res: newsResponse[])=>{
      res.forEach(src=>{
        this.category.push(src.status);
        this.sources.push(...src.sources);
      });
      this.totalRecords = this.sources.length;
      this.sourcesToShow = this.sources.slice(0,10);
      this.showLoader = false;
      this.errorFlag = false;
    }, err=>{
      this.sendErrorFlag(true);
      this.showLoader=false;
    });
  }

  sendErrorFlag(flag: boolean){
    this.error.emit(flag);
  }

  paginate(event){
    this.sourcesToShow = [];
    this.showLoader = true;
    var startIndex = (event.page * 10);
    var endIndex = (((event.page +1)*10) > this.totalRecords) ? (this.totalRecords) : ((event.page +1)*10);
    for (let index = startIndex; index < endIndex; index++) {
      this.sourcesToShow.push(this.sources[index]);
    }
    this.showLoader = false;
  }

}
