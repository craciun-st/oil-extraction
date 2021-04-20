package model.extractors;

import model.Extractor;
import model.Worker;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OffshorePlatform extends Extractor {
    private List<Worker> workers;

    public OffshorePlatform(double capacity) {
        super(capacity);
        workers = new ArrayList<>();
    }

    public OffshorePlatform(int id, double capacity) {
        super(id, capacity);
        workers = new ArrayList<>();
    }

    @Override
    public boolean hasFault() {
        //TODO do logic as a function of Workers
        return (this.getId() % 3 == 1);
    }

    public boolean addWorker(Worker someWorker) {
        if (someWorker.leaveSite() == false) {
            return false;
        } else {
            someWorker.setSite(this);
            return workers.add(someWorker);
        }
    }


    public boolean removeWorker(Worker someWorker) {
        return workers.remove(someWorker);
    }

    @Override
    public String toString() {
        return super.toString() + "; " + "OffshorePlatform{" +
                "nrWorkers=" + workers.size() + System.lineSeparator() +
                "\t workers=" + workers.stream()
                                .map(worker -> worker.toString()+System.lineSeparator()+"\t\t")
                                .collect(Collectors.joining()) +
                '}';
    }
}
