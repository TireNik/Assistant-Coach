import exerciseModule.Exercise;
import exerciseModule.ExerciseType;
import workoutPlanModule.WorkoutDay;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
// Создание упражнения Squat с подходами
        Exercise squat = new Exercise("Squat", ExerciseType.LEG);
        squat.addSet(80.0, "12");
        squat.addSet(85.0, "10");
        squat.addSet(90.0, "8");

        // Создание упражнения Bench Press с подходами
        Exercise benchPress = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
        benchPress.addSet(60.0, "10");
        benchPress.addSet(65.0, "8");
        benchPress.addSet(70.0, "6");

        // Создание упражнения Deadlift с подходами
        Exercise deadlift = new Exercise("Deadlift", ExerciseType.VERTEBRA);
        deadlift.addSet(100.0, "8");
        deadlift.addSet(105.0, "6");
        deadlift.addSet(110.0, "4");

        // Создание первого тренировочного дня с тремя упражнениями
        WorkoutDay workoutDay1 = new WorkoutDay(
                Arrays.asList(squat, benchPress, deadlift),
                LocalDateTime.now()
        );

        // Создание второго тренировочного дня с другими упражнениями
        Exercise pullUp = new Exercise("Pull-up", ExerciseType.HAND_PULL);
        pullUp.addSet(0.0, "12");
        pullUp.addSet(0.0, "10");
        pullUp.addSet(0.0, "8");

        Exercise overheadPress = new Exercise("Overhead Press", ExerciseType.HAND_PUSH);
        overheadPress.addSet(40.0, "10");
        overheadPress.addSet(45.0, "8");
        overheadPress.addSet(50.0, "6");

        Exercise lunges = new Exercise("Lunges", ExerciseType.LEG);
        lunges.addSet(50.0, "12");
        lunges.addSet(55.0, "10");
        lunges.addSet(60.0, "8");

        WorkoutDay workoutDay2 = new WorkoutDay(
                Arrays.asList(pullUp, overheadPress, lunges),
                LocalDateTime.now().plusDays(1)
        );

        // Вывод данных о тренировочных днях
        System.out.println("Workout Day 1: " + workoutDay1.getExercises());
        System.out.println("Workout Day 2: " + workoutDay2.getExercises());

    }
}