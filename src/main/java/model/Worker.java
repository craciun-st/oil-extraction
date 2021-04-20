package model;

import model.extractors.OffshorePlatform;

public class Worker {

    private Position position;
    private int nrOfDaysOnSite;
    private final String name;
    private Extractor site;

    public Worker(Position position, String name) {
        this.position = position;
        this.name = name;
        this.nrOfDaysOnSite = 0;
    }


    public Worker(Position position, String name, OffshorePlatform site) {
        this.position = position;
        this.name = name;
        this.site = site;
        this.nrOfDaysOnSite = 0;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getNrOfDaysOnSite() {
        return nrOfDaysOnSite;
    }

    public void setNrOfDaysOnSite(int nrOfDaysOnSite) {
        this.nrOfDaysOnSite = nrOfDaysOnSite;
    }

    public Extractor getSite() {
        return site;
    }

    public void setSite(OffshorePlatform site) {
        this.site = site;
    }   // settter only for Offshore

    public boolean leaveSite() {
        if (this.site == null) {
            return true;
        } else {
            if (this.site instanceof OffshorePlatform) {
                OffshorePlatform oldSite = (OffshorePlatform) this.site;    // currently can always cast this
                                                                            // but an intermediate abstract class
                                                                            // should be created for extending
                                                                            // behavior similar to OffshorePlatform
                if (oldSite.removeWorker(this)) {
                    this.site = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "position=" + position +
                ", nrOfDaysOnSite=" + nrOfDaysOnSite +
                ", name='" + name + '\'' +
                ", site=" + site.getClass().getSimpleName() +   // this causes a stack overflow if you leave
                                                                // just the object's toString representation
                                                                // due to the worker and site referencing each
                                                                // other
                '}';
    }
}
