package workoutPlanModule;

import exerciseModule.Exercise;

import java.time.LocalDateTime;
import java.util.List;

public class WorkoutDay {
    private List<Exercise> plannedExercises;
    private List<Exercise> actualExercises;
    private LocalDateTime dateTime;
    private Integer id;

    public WorkoutDay(List<Exercise> plannedExercises, List<Exercise> actualExercises, LocalDateTime dateTime) {
        this.plannedExercises = plannedExercises;
        this.actualExercises = actualExercises;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return plannedExercises +
                ", " + actualExercises +
                ", " + dateTime +
                ", " + id +
                '}';
    }
}