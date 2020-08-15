import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VenuesComponent } from './eventize/pages/venues/venues.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  { path: '', component: AppComponent }, // TODO: Create dashboard component
  { path: 'venues', component: VenuesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
