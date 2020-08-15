import { Component, Input, OnInit, TemplateRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss']
})
export class DataTableComponent implements OnInit {

  /** The table data. */
  @Input() data: any[];
  /** The table columns. */
  @Input() columns: any[]; // TODO: create model for columns
  /** The table type. */
  @Input() type: string;
  /** The venues table template. */
  @ViewChild('venuesTable', { static: false }) venuesTable: TemplateRef<any>;
  /** The events table template. */
  @ViewChild('eventsTable', { static: false }) eventsTable: TemplateRef<any>;
  /** The guests table template. */
  @ViewChild('guestsTable', { static: false }) guestsTable: TemplateRef<any>;

  constructor() { }

  /**
   * On init.
   * 
   * @memberof DataTableComponent
   */
  ngOnInit() {
  }

  /**
   * Get the table type.
   *
   * @returns {TemplateRef<any>}
   * @memberof DataTableComponent
   */
  getTableType(): TemplateRef<any> {
    switch (this.type) {
      case 'venues':
        return this.venuesTable;
      case 'events':
        return this.eventsTable;
      case 'guests':
        return this.guestsTable;
      default:
        return null;
    }
  }
}
