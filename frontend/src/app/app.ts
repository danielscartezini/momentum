import { Component, inject, OnInit, signal } from '@angular/core';
import { HabitService } from './services/habit.service';
import { HabitModel } from './models/habit.model';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App implements OnInit {
  private habitService = inject(HabitService);
  habits: Array<HabitModel> = [];
  habit: HabitModel = {
    id: 0,
    habitName: '',
    habitDescription: ''
  };

  ngOnInit(): void {
    this.loadHabits();
  }

  loadHabits() {
    this.habitService.getHabits().subscribe((response) => {
      this.habits = response;
    });
  }

  addHabit(newHabit: HabitModel) {
    this.habitService.createHabit(newHabit).subscribe(() => {
      this.loadHabits();
    });
  }

  deleteHabit(habit: HabitModel) {
    this.habitService.deleteHabit(habit).subscribe(() => {
      this.loadHabits();
    })
  }
}
