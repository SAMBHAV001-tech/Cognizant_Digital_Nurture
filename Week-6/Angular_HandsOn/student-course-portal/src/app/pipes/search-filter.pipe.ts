import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilter',
  standalone: true
})
export class SearchFilterPipe implements PipeTransform {
  transform(items: any[], searchText: string, fieldName: string = 'name'): any[] {
    if (!items) return [];
    if (!searchText) return items;

    searchText = searchText.toLowerCase();

    return items.filter(item => {
      if (item[fieldName]) {
        return item[fieldName].toString().toLowerCase().includes(searchText);
      }
      return false;
    });
  }
}
