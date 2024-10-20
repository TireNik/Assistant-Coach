package workoutPlanModule;

import java.util.List;

public class WorkoutWeek {
    private List<WorkoutDay> workoutDays;

    public WorkoutWeek(List<WorkoutDay> workoutDays) {
        this.workoutDays = workoutDays;
    }

    public List<WorkoutDay> getWorkoutDays() {
        return workoutDays;
    }

    public void setWorkoutDays(List<WorkoutDay> workoutDays) {
        this.workoutDays = workoutDays;
    }
}
