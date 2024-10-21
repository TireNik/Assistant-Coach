import exerciseModule.Exercise;
import exerciseModule.ExerciseType;
import progressTracker.Progress;
import workoutPlanModule.WorkoutDay;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Создаем запланированные упражнения
        Exercise squatPlanned = new Exercise("Squat", ExerciseType.LEG);
        squatPlanned.addSet(80.0, "12");
        squatPlanned.addSet(85.0, "10");

        Exercise benchPressPlanned = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
        benchPressPlanned.addSet(60.0, "10");
        benchPressPlanned.addSet(65.0, "8");

        // Создаем фактически выполненные упражнения
        Exercise squatActual = new Exercise("Squat", ExerciseType.LEG);
        squatActual.addSet(80.0, "12");  // Выполнено ровно по плану
        squatActual.addSet(85.0, "10");

        Exercise benchPressActual = new Exercise("Bench Press", ExerciseType.HAND_PUSH);
        benchPressActual.addSet(60.0, "10");  // Выполнено только одно подхода
        benchPressActual.addSet(65.0, "7");   // Немного не дотянуто до плана

        // Создаем тренировочный день
        WorkoutDay workoutDay = new WorkoutDay(
                Arrays.asList(squatPlanned, benchPressPlanned),
                Arrays.asList(squatActual, benchPressActual),
                LocalDateTime.now()
        );

        // Создаем объект прогресса и рассчитываем выполнение
        Progress progress = new Progress();
        progress.calculateProgress(workoutDay);

        // Вывод результата
        System.out.println("Тренировка выполнена: " + progress.isResult());
        System.out.println("Процент выполнения: " + progress.getPercentDone() + "%");
    }
}