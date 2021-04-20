package model;

public abstract class Extractor {
    private int id;
    private double capacity;
    private double lastDayOutput;
    public static final int DUMMY_VALUE = -1;

    public abstract boolean hasFault();

    public Extractor(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not be less or equal to 0");
        } else {
            this.capacity = capacity;
        }
        id = DUMMY_VALUE;
        lastDayOutput = 0;
    }

    public Extractor(int id, double capacity) {
        this.id = id;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not be less or equal to 0");
        } else {
            this.capacity = capacity;
        }
    }

    public double getCapacity() {
        return capacity;
    }

    public double getLastDayOutput() {
        return lastDayOutput;
    }

    public void setLastDayOutputAsFractionOfCapacity(double fraction) {
        if (fraction < 0.0 || fraction > 1.0) {
            throw new IllegalArgumentException("Production can not exceed a fraction of 100%");
        } else {
            this.lastDayOutput = fraction * capacity;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean hasBeenProductiveInLastDay() {
        return (this.lastDayOutput / this.capacity > 0.95);

    }

    @Override
    public String toString() {
        return "model.Extractor{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", lastDayOutput=" + lastDayOutput +
                '}';
    }
}
