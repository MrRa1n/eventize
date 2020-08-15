import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Constants } from 'src/app/constants';

@Injectable({
  providedIn: 'root'
})
export class VenuesService {

  /** The venues endpoint. */
  private endpoint: string = Constants.API_PATH + '/venues';

  /**
   * Creates an instance of VenuesService.
   * 
   * @param {HttpClient} http
   * @memberof VenuesService
   */
  constructor(private http: HttpClient) { }

  /**
   * Get all venues.
   *
   * @returns {Observable<any>}
   * @memberof VenuesService
   */
  getAllVenues(): Observable<any> {
    return this.http.get<any>(this.endpoint);
  }
}
