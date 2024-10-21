package progressTracker;

import exerciseModule.Exercise;
import workoutPlanModule.WorkoutDay;
import java.util.List;

public class Progress {
    private boolean result;      // Индикатор выполнения тренировки
    private Double percentDone;  // Процент выполнения тренировки

    public Progress() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Double getPercentDone() {
        return percentDone;
    }

    public void setPercentDone(Double percentDone) {
        this.percentDone = percentDone;
    }

    // Метод для расчета прогресса и выполнения тренировки
    public void calculateProgress(WorkoutDay workoutDay) {
        List<Exercise> plannedExercises = workoutDay.getPlannedExercises();
        List<Exercise> actualExercises = workoutDay.getActualExercises();

        double plannedIntensity = plannedExercises.stream()
                .mapToDouble(Exercise::calculateIntensity)
                .sum();

        double actualIntensity = actualExercises.stream()
                .mapToDouble(Exercise::calculateIntensity)
                .sum();

        // Процент выполнения
        this.percentDone = (actualIntensity / plannedIntensity) * 100;

        // Если фактическая интенсивность больше или равна запланированной, считается, что тренировка выполнена
        this.result = actualIntensity >= plannedIntensity;
    }
}