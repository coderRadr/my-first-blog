import { Component, OnInit } from '@angular/core';
import { GenericService } from 'src/app/services/generic.service';
import { contactDetails } from './contactDetails';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {
  showLoader: boolean;
  developersInfo: contactDetails[] = [];

  constructor(private service: GenericService) { }

  ngOnInit() {
    this.showLoader = true;
    this.service.contactDetails().subscribe((res: contactDetails[])=>{
      this.developersInfo = res; 
      this.showLoader = false;
    });
  }

}
