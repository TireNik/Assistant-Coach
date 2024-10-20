package workoutPlanModule;

import java.util.List;

public class WorkoutMonth {
    private List<WorkoutWeek> workoutWeeks;

    public WorkoutMonth(List<WorkoutWeek> workoutWeeks) {
        this.workoutWeeks = workoutWeeks;
    }

    public List<WorkoutWeek> getWorkoutWeeks() {
        return workoutWeeks;
    }

    public void setWorkoutWeeks(List<WorkoutWeek> workoutWeeks) {
        this.workoutWeeks = workoutWeeks;
    }
}
