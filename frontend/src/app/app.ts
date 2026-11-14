import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
<<<<<<< HEAD
import { Header} from './components/header/header';

@Component({
  imports: [RouterOutlet, Header],
=======

@Component({
  imports: [RouterOutlet],
>>>>>>> 305c0828f38f53a92cff4c0cfa28da88ad24eb98
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontend');
}
