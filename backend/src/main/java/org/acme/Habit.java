package org.acme;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Habit {
    // Propriedades da entidade Habit
    private String habitName;
    private String habitDescription;

    @Id
    @GeneratedValue
    private Long id;
    
    // Construtor cheio
    public Habit(String newHabitName, String newHabitDescription) {
        this.habitName = newHabitName;
        this.habitDescription = newHabitDescription;
    }
    // Construtor vazio
    public Habit() {
    }

    // Getters e Setters
    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitDescription() {
        return habitDescription;
    }

    public void setHabitDescription(String habitDescription) {
        this.habitDescription = habitDescription;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

}
