package model;

import util.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Business {
    private int day;
    private List<Extractor> extractors;
    private List<Worker> employees;

    public Business(int day) {
        this.day = day;
        extractors = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public List<Extractor> getExtractorsWithFaults() {
        if (extractors.size() == 0) {
            return extractors;
        } else {
            return extractors.stream()
                    .filter(Extractor::hasFault)
                    .collect(Collectors.toList());
        }
    }

    public List<Extractor> getRecentProductiveExtractors() {
        if (extractors.size() == 0) {
            return extractors;
        } else {
            return extractors.stream()
                    .filter(Extractor::hasBeenProductiveInLastDay)
                    .collect(Collectors.toList());
        }
    }

    public void moveWorkerToSite(Worker someWorker, Extractor someSite) {

    }

    public void update() {
        for (Extractor extractor : extractors) {
            extractor.setLastDayOutputAsFractionOfCapacity(Randoms.getRandomSubUnitaryFraction());
        }
        for (Worker employee : employees) {
            if (employee.getSite() != null) {
                employee.setNrOfDaysOnSite(employee.getNrOfDaysOnSite() + 1);
            }
        }
        day++;

    }

    public void addExtractor(Extractor someExtractor) {
        int newId = this.getMaxSerialForExtractor() + 1;
        someExtractor.setId(newId);
        extractors.add(someExtractor);
    }

    public int getMaxSerialForExtractor() {
        if (extractors.size() == 0) {
            return 0;
        } else {
            return extractors.stream()
                    .mapToInt(Extractor::getId)
                    .max().orElse(0);
        }
    }

}
