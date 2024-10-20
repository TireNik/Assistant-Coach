package exerciseModule;

import java.util.Objects;

public class Exercise {
   private String name;
   private Exercise type;
   private Double weight;
   private String reps;
   private String sets;

    public Exercise(String name, Exercise type, Double weight, String reps, String sets) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exercise getType() {
        return type;
    }

    public void setType(Exercise type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Exercise exercise = (Exercise) object;
        return Objects.equals(name, exercise.name) && Objects.equals(type, exercise.type) && Objects.equals(weight, exercise.weight) && Objects.equals(reps, exercise.reps) && Objects.equals(sets, exercise.sets);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(weight);
        result = 31 * result + Objects.hashCode(reps);
        result = 31 * result + Objects.hashCode(sets);
        return result;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", weight=" + weight +
                ", reps='" + reps + '\'' +
                ", sets='" + sets + '\'' +
                '}';
    }
}
