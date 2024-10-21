package exerciseModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercise {
    private String name;
    private ExerciseType type;
    private List<Set> sets;  // Список подходов (вес + повторения)

    public Exercise(String name, ExerciseType type) {
        this.name = name;
        this.type = type;
        this.sets = new ArrayList<>();
    }

    // Добавление подхода в упражнение
    public void addSet(double weight, String reps) {
        sets.add(new Set(weight, reps));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Exercise exercise = (Exercise) object;
        return Objects.equals(name, exercise.name) && Objects.equals(type, exercise.type)
                && Objects.equals(sets, exercise.sets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, sets);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", sets=" + sets +
                '}';
    }

    // Вложенный класс Set для хранения данных о подходах
    public static class Set {
        private double weight;
        private String reps;

        public Set(double weight, String reps) {
            this.weight = weight;
            this.reps = reps;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getReps() {
            return reps;
        }

        public void setReps(String reps) {
            this.reps = reps;
        }

        @Override
        public String toString() {
            return "Set{" +
                    "weight=" + weight +
                    ", reps='" + reps + '\'' +
                    '}';
        }
    }
}