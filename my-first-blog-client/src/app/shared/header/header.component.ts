import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { GenericService } from 'src/app/services/generic.service';
import { headerModel } from './headerModel';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  @Input() headerModels: headerModel[];
  @Output() componentName = new EventEmitter<headerModel>();
  constructor(private headerService: GenericService) { }

  ngOnInit() {
  }
  sendEvent(componentToLoad: headerModel){
    this.componentName.emit(componentToLoad);
  }

}
