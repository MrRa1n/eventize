import { Component, OnInit } from '@angular/core';
import { VenuesService } from 'src/app/core/services/venues.service';

@Component({
  selector: 'app-venues',
  templateUrl: './venues.component.html',
  styleUrls: ['./venues.component.scss']
})
export class VenuesComponent implements OnInit {

  /** The table columns. */
  tableColumns: any[];
  /** The table data. */
  tableData: any[];

  /**
   * Creates an instance of VenuesComponent.
   * 
   * @param {VenuesService} venuesService
   * @memberof VenuesComponent
   */
  constructor(private venuesService: VenuesService) { }

  /**
   * On init.
   *
   * @memberof VenuesComponent
   */
  ngOnInit() {
    this.tableColumns = this.getTableColumns();
    this.getAllVenues();
  }

  /**
   * Get all venues.
   *
   * @memberof VenuesComponent
   */
  getAllVenues(): void {
    this.venuesService.getAllVenues()
      .subscribe((data: any[]) => {
        this.tableData = data;
      });
  }

  /**
   * Get table columns.
   *
   * @returns {any[]}
   * @memberof VenuesComponent
   */
  getTableColumns(): any[] {
    return [
      { id: 'venue_name', title: 'Name', width: '12.5%', sort: false },
      { id: 'venue_desc', title: 'Description', width: '12.5%', sort: false },
      { id: 'telephone', title: 'Telephone', width: '12.5%', sort: false },
      { id: 'email', title: 'Email', width: '12.5%', sort: false },
      { id: 'street', title: 'Street', width: '12.5%', sort: false },
      { id: 'city', title: 'City', swidth: '12.5%', ort: false },
      { id: 'postcode', title: 'Postcode', width: '12.5%', sort: false },
      { id: 'country', title: 'Country', width: '12.5%', sort: false }
    ];
  }
}
