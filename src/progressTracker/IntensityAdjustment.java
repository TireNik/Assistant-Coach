package progressTracker;

import exerciseModule.Exercise;
import workoutPlanModule.WorkoutDay;

import java.util.List;

public class IntensityAdjustment {

    // Главный метод, который вызывает другие, и обновляет план
    public WorkoutDay recommend(WorkoutDay workoutDay) {
        List<Exercise> actualExercises = workoutDay.getActualExercises();  // Используем фактически выполненные упражнения

        for (Exercise exercise : actualExercises) {
            List<Exercise.Set> sets = exercise.getSets();

            // Собираем информацию о подходах
            AdjustmentData data = gatherSetData(sets);

            // Решаем, увеличивать ли вес, уменьшать или оставлять
            if (shouldDecreaseWeight(data)) {
                adjustWeight(sets, -10);  // Уменьшаем вес на 10%
            } else if (shouldIncreaseWeight(data)) {
                adjustWeight(sets, 10);   // Увеличиваем вес на 10%
            } else {
                adjustReps(sets, data);   // Не меняем вес, но корректируем повторения
            }
        }

        // Возвращаем обновленный тренировочный день
        workoutDay.setActualExercises(actualExercises);
        return workoutDay;
    }

    // Метод для сбора данных о подходах
    private AdjustmentData gatherSetData(List<Exercise.Set> sets) {
        int totalReps = 0;
        int minReps = Integer.MAX_VALUE;
        boolean decreaseWeight = false;
        boolean increaseWeight = true;

        for (Exercise.Set set : sets) {
            int reps = Integer.parseInt(set.getReps());
            totalReps += reps;
            if (reps < 6) {
                decreaseWeight = true;
            }
            if (reps < 10) {
                increaseWeight = false;
            }
            minReps = Math.min(minReps, reps);
        }

        double averageReps = (double) totalReps / sets.size();
        return new AdjustmentData(decreaseWeight, increaseWeight, minReps, Math.ceil(averageReps));
    }

    // Проверяем, нужно ли уменьшить вес
    private boolean shouldDecreaseWeight(AdjustmentData data) {
        return data.isDecreaseWeight();
    }

    // Проверяем, нужно ли увеличить вес
    private boolean shouldIncreaseWeight(AdjustmentData data) {
        return data.isIncreaseWeight();
    }

    // Увеличиваем или уменьшаем вес
    private void adjustWeight(List<Exercise.Set> sets, double percentage) {
        for (Exercise.Set set : sets) {
            set.setWeight(set.getWeight() * (1 + percentage / 100));
        }
    }

    // Корректируем повторения на следующую тренировку
    private void adjustReps(List<Exercise.Set> sets, AdjustmentData data) {
        int roundedAverageReps = (int) data.getAverageReps(); // Округляем вверх до целого числа
        for (Exercise.Set set : sets) {
            set.setReps(String.valueOf(roundedAverageReps));
        }
    }

    // Вспомогательный класс для хранения данных о подходах
    private static class AdjustmentData {
        private final boolean decreaseWeight;
        private final boolean increaseWeight;
        private final int minReps;
        private final double averageReps;

        public AdjustmentData(boolean decreaseWeight, boolean increaseWeight, int minReps, double averageReps) {
            this.decreaseWeight = decreaseWeight;
            this.increaseWeight = increaseWeight;
            this.minReps = minReps;
            this.averageReps = averageReps;
        }

        public boolean isDecreaseWeight() {
            return decreaseWeight;
        }

        public boolean isIncreaseWeight() {
            return increaseWeight;
        }

        public int getMinReps() {
            return minReps;
        }

        public double getAverageReps() {
            return averageReps;
        }
    }
}