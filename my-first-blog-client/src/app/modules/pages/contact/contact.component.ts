import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { GenericService } from 'src/app/services/generic.service';
import { contactDetails } from './contactDetails';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {
  @Output() error = new EventEmitter<boolean>();
  showLoader: boolean;
  developersInfo: contactDetails[] = [];

  constructor(private service: GenericService) { }

  ngOnInit() {
    this.showLoader = true;
    this.service.contactDetails().subscribe((res: contactDetails[])=>{
      this.developersInfo = res; 
      this.showLoader = false;
    }, err=>{
      this.sendErrorFlag(true);
      this.showLoader=false;
    });
  }

  sendErrorFlag(flag: boolean){
    this.error.emit(flag);
  }

}
