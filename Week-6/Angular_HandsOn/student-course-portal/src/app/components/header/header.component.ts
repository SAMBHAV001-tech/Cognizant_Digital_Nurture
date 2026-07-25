import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { PortalStateService } from '../../services/portal-state.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  portalState = inject(PortalStateService);
  selectedStudent$ = this.portalState.selectedStudent$;
  totalEnrolled$ = this.portalState.totalEnrolled$;
}
