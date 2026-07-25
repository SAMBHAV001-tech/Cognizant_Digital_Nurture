import { SearchFilterPipe } from './search-filter.pipe';

describe('SearchFilterPipe', () => {
  let pipe: SearchFilterPipe;

  beforeEach(() => {
    pipe = new SearchFilterPipe();
  });

  it('should create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('should filter items by name', () => {
    const items = [
      { id: 1, name: 'Aarav' },
      { id: 2, name: 'Priya' },
      { id: 3, name: 'Rohan' }
    ];
    const result = pipe.transform(items, 'aarav', 'name');
    expect(result.length).toBe(1);
    expect(result[0].name).toBe('Aarav');
  });

  it('should return all items if search query is empty', () => {
    const items = [{ id: 1, name: 'Aarav' }, { id: 2, name: 'Priya' }];
    const result = pipe.transform(items, '', 'name');
    expect(result.length).toBe(2);
  });
});
