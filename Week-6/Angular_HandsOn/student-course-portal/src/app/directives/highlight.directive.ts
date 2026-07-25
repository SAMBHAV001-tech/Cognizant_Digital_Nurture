import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  @Input() appHighlight = 'rgba(56, 189, 248, 0.15)';
  private defaultBorder = '1px solid rgba(255, 255, 255, 0.08)';

  constructor(private el: ElementRef) {}

  @HostListener('mouseenter') onMouseEnter() {
    this.el.nativeElement.style.backgroundColor = this.appHighlight;
    this.el.nativeElement.style.border = '1px solid rgba(56, 189, 248, 0.4)';
    this.el.nativeElement.style.transform = 'translateY(-2px)';
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.el.nativeElement.style.backgroundColor = 'rgba(30, 41, 59, 0.6)';
    this.el.nativeElement.style.border = this.defaultBorder;
    this.el.nativeElement.style.transform = 'none';
  }
}
