import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { HabitModel } from '../models/habit.model';

// A Service manda as requisições e recebe as respostas do backend, utilizando o HttpClient do Angular (configurado no 'app.config.ts').
@Injectable({ providedIn: 'root' }) // nao entendi o que faz mas deixa ai
export class HabitService  {
    private client = inject(HttpClient);    // HttpClient faz as requisições nativas do Angular (GET, POST, DELETE) para o backend.
    private apiUrl = 'http://localhost:8080/api/habits';

    getHabits() {         // retorna uma lista de habitos
        return this.client.get<HabitModel[]>(this.apiUrl); // == curl GET http://localhost:8080/api/habits
    }

    createHabit(habit: HabitModel) {
        return this.client.post(this.apiUrl, habit); // == curl POST http://localhost:8080/api/habits -Body '{id: x, habitName: y, habitDescription: z}'
    }

    deleteHabit(habit: HabitModel) {
		    return this.client.delete(`${this.apiUrl}/${habit.id}`); // == curl DELETE http://localhost:8080/api/habits/{id}
    }
}
