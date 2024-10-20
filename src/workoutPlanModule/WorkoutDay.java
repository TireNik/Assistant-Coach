package workoutPlanModule;

import exerciseModule.Exercise;

import java.time.LocalDateTime;
import java.util.List;

public class WorkoutDay {
    private List<Exercise> exercises;
    private LocalDateTime dateTime;

    public WorkoutDay(List<Exercise> exercises, LocalDateTime dateTime) {
        this.exercises = exercises;
        this.dateTime = dateTime;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
