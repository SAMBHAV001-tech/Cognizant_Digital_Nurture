import { render, screen } from '@testing-library/react';
import App from './App';

test('renders welcome heading', () => {
  render(<App />);
  const headingElement = screen.getByText(/Welcome to the first session of React/i);
  expect(headingElement).toBeInTheDocument();
});
