import exerciseModule.Exercise;
import exerciseModule.ExerciseType;
import progressTracker.IntensityAdjustment;
import workoutPlanModule.WorkoutDay;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Exercise benchPress = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
        benchPress.addSet(65.0, "10");
        benchPress.addSet(65.0, "10");
        benchPress.addSet(65.0, "8");

        Exercise actBenchPress = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
        actBenchPress.addSet(65.0, "10");
        actBenchPress.addSet(65.0, "10");
        actBenchPress.addSet(65.0, "10");

        WorkoutDay workoutDay = new WorkoutDay(
                List.of(benchPress),
                List.of(actBenchPress),
                LocalDateTime.now()
        );

        IntensityAdjustment intensityAdjustment = new IntensityAdjustment();
        WorkoutDay adjustedWorkoutDay = intensityAdjustment.recommend(workoutDay);

        System.out.println(adjustedWorkoutDay.getPlannedExercises());
    }
}