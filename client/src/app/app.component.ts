import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  isCollapsed: boolean = false;

  navLinks: any[];

  ngOnInit(): void {
    this.navLinks = this.getNavLinks();
  }

  getNavLinks(): any[] {
    return [
      { icon: 'dashboard', title: 'Dashboard', href: '' },
      {
        icon: 'tool',
        title: 'Manage',
        href: '',
        links: [
          { icon: '', title: 'Venues', href: '' },
          { icon: '', title: 'Events', href: '' },
          { icon: '', title: 'Guests', href: '' }
        ]
      }
    ];
  }
}
