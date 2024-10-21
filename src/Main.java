import exerciseModule.Exercise;
import exerciseModule.ExerciseType;
import progressTracker.IntensityAdjustment;
import progressTracker.Progress;
import workoutPlanModule.WorkoutDay;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Создаем фактические упражнения
        Exercise squat = new Exercise("Squat", ExerciseType.LEG);
        squat.addSet(80.0, "15");
        squat.addSet(85.0, "8");
        squat.addSet(90.0, "6");

        Exercise benchPress = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
        benchPress.addSet(60.0, "10");
        benchPress.addSet(65.0, "8");
        benchPress.addSet(70.0, "5");

        // Создаем тренировочный день с фактически выполненными упражнениями
        WorkoutDay workoutDay = new WorkoutDay(
                Arrays.asList(benchPress),
                Arrays.asList(benchPress),  // В этом примере фактические упражнения те же, что и запланированные
                LocalDateTime.now()
        );

        // Применяем корректировку интенсивности
        IntensityAdjustment intensityAdjustment = new IntensityAdjustment();
        WorkoutDay adjustedWorkoutDay = intensityAdjustment.recommend(workoutDay);

        // Вывод обновленных данных
        System.out.println("Updated Workout Day: " + adjustedWorkoutDay.getActualExercises());
    }

//        // Создаем запланированные упражнения
//        Exercise squatPlanned = new Exercise("Squat", ExerciseType.LEG);
//        squatPlanned.addSet(80.0, "12");
//        squatPlanned.addSet(85.0, "10");
//
//        Exercise benchPressPlanned = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
//        benchPressPlanned.addSet(60.0, "10");
//        benchPressPlanned.addSet(65.0, "8");
//
//        // Создаем фактически выполненные упражнения
//        Exercise squatActual = new Exercise("Squat", ExerciseType.LEG);
//        squatActual.addSet(80.0, "12");  // Выполнено ровно по плану
//        squatActual.addSet(85.0, "10");
//
//        Exercise benchPressActual = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
//        benchPressActual.addSet(60.0, "10");  // Выполнено только одно подхода
//        benchPressActual.addSet(65.0, "9");   // Немного не дотянуто до плана
//
//        // Создаем тренировочный день
//        WorkoutDay workoutDay = new WorkoutDay(
//                Arrays.asList(squatPlanned, benchPressPlanned),
//                Arrays.asList(squatActual, benchPressActual),
//                LocalDateTime.now()
//        );
//
//        // Создаем объект прогресса и рассчитываем выполнение
//        Progress progress = new Progress();
//        progress.calculateProgress(workoutDay);
//
//        // Вывод результата
//        System.out.println("Тренировка выполнена: " + progress.isResult());
//        System.out.println("Процент выполнения: " + progress.getPercentDone() + "%");
}
