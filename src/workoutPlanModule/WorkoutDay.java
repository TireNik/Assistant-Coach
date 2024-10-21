package workoutPlanModule;

import exerciseModule.Exercise;

import java.time.LocalDateTime;
import java.util.List;

public class WorkoutDay {
    private List<Exercise> plannedExercises;   // Запланированные упражнения
    private List<Exercise> actualExercises;    // Фактически выполненные упражнения
    private LocalDateTime dateTime;

    public WorkoutDay(List<Exercise> plannedExercises, List<Exercise> actualExercises, LocalDateTime dateTime) {
        this.plannedExercises = plannedExercises;
        this.actualExercises = actualExercises;
        this.dateTime = dateTime;
    }

    public List<Exercise> getPlannedExercises() {
        return plannedExercises;
    }

    public void setPlannedExercises(List<Exercise> plannedExercises) {
        this.plannedExercises = plannedExercises;
    }

    public List<Exercise> getActualExercises() {
        return actualExercises;
    }

    public void setActualExercises(List<Exercise> actualExercises) {
        this.actualExercises = actualExercises;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}