package progressTracker;

import exerciseModule.Exercise;
import workoutPlanModule.WorkoutDay;

import java.util.List;

public class IntensityAdjustment {

    public WorkoutDay recommend(WorkoutDay workoutDay) {
        List<Exercise> plannedExercises = workoutDay.getPlannedExercises();
        List<Exercise> actualExercises = workoutDay.getActualExercises();

        for (int i = 0; i < plannedExercises.size(); i++) {
            Exercise plannedExercise = plannedExercises.get(i);
            Exercise actualExercise = actualExercises.get(i);

            List<Exercise.Set> plannedSets = plannedExercise.getSets();
            List<Exercise.Set> actualSets = actualExercise.getSets();

            boolean allSetsEqual = gatherSetData(plannedSets, actualSets);
            boolean allRepsAre10 = allRepsAre10(actualSets);

            if (allRepsAre10) {
                adjustWeight(plannedSets, 10);
                setRepsTo(plannedSets, 8);
            } else if (allSetsEqual) {
                increaseRepsBy1(plannedSets);
            } else if (!allSetsEqual) {
                setMediumReps(plannedSets, actualSets);
            }
        }

        workoutDay.setPlannedExercises(plannedExercises);
        return workoutDay;
    }

    private void setMediumReps(List<Exercise.Set> plannedSets, List<Exercise.Set> actualSets) {
        int plannedReps = 0;
        int actualReps = 0;

        for (Exercise.Set set : plannedSets) {
            plannedReps = plannedReps + Integer.parseInt(set.getReps());
        }
        for (Exercise.Set set : actualSets) {
            actualReps = actualReps + Integer.parseInt(set.getReps());
        }

        if(actualReps < plannedReps) {
            actualReps = actualReps / plannedSets.size();
            for (Exercise.Set set : plannedSets) {
                set.setReps(String.valueOf(actualReps));
            }
        }
    }
    private void increaseRepsBy1(List<Exercise.Set> sets) {
        for (Exercise.Set set : sets) {
            int reps = Integer.parseInt(set.getReps());
            if (reps < 10) {
                set.setReps(String.valueOf(reps + 1));
            }
        }
    }

    private void setRepsTo(List<Exercise.Set> sets, int targetReps) {
        for (Exercise.Set set : sets) {
            set.setReps(String.valueOf(targetReps));
        }
    }

    private void adjustWeight(List<Exercise.Set> sets, double percentage) {
        for (Exercise.Set set : sets) {
            set.setWeight(set.getWeight() * (1 + percentage / 100));
        }
    }

    private boolean allRepsAre10(List<Exercise.Set> actualSets) {
        for (Exercise.Set set : actualSets) {
            int actualReps = Integer.parseInt(set.getReps());
            if (actualReps < 10) {
                return false;
            }
        }
        return true;
    }

    private boolean gatherSetData(List<Exercise.Set> plannedSets, List<Exercise.Set> actualSets) {
        for (int i = 0; i < plannedSets.size(); i++) {
            int plannedReps = Integer.parseInt(plannedSets.get(i).getReps());
            int actualReps = Integer.parseInt(actualSets.get(i).getReps());

            if (actualReps < plannedReps) {
                return false;
            }
        }
        return true;
    }
}