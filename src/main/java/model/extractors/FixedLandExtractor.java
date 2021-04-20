package model.extractors;

import model.Extractor;

public class FixedLandExtractor extends Extractor {
    private final String location;

    public FixedLandExtractor(double capacity, String location) {
        super(capacity);
        this.location = location;
    }

    public FixedLandExtractor(int id, double capacity, String location) {
        super(id, capacity);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean hasFault() {
        //TODO more logic
        return (this.getId() % 3 == 0);
    }

    @Override
    public String toString() {
        return super.toString() + "; " + "FixedLandExtractor{" +
                "location='" + location + '\'' +
                '}';
    }
}
