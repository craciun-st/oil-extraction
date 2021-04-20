package model.extractors;

import model.Extractor;

public class MobileLandExtractor extends Extractor {
    private String location;

    public MobileLandExtractor(double capacity, String location) {
        super(capacity);
        this.location = location;
    }

    public MobileLandExtractor(int id, double capacity, String location) {
        super(id, capacity);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean hasFault() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + "MobileLandExtractor{" +
                "location='" + location + '\'' +
                '}';
    }
}
