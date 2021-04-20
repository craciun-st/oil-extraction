import model.Business;
import model.Position;
import model.Worker;
import model.extractors.FixedLandExtractor;
import model.extractors.MobileLandExtractor;
import model.extractors.OffshorePlatform;

public class App {

    public static void main(String[] args) {
        Business company = new Business(0);
        FixedLandExtractor extractor1 = new FixedLandExtractor(25.5, "Alpha");
        FixedLandExtractor extractor2 = new FixedLandExtractor(33.2, "Beta");
        MobileLandExtractor extractor3 = new MobileLandExtractor(26.0, "Alpha");
        OffshorePlatform extractor4 = new OffshorePlatform(1000.0);
        OffshorePlatform extractor5 = new OffshorePlatform(2500.1);
        Worker manager1 = new Worker(Position.MANAGER, "John Williams");
        Worker medic1 = new Worker(Position.MEDIC, "Gordon Freeman");
        extractor4.addWorker(manager1);
        extractor5.addWorker(medic1);
        for (int i = 0; i < 5; i++) {
            Worker currentWorker = new Worker(Position.MANUAL_WORKER, "Engineer " + i);
            if (i % 2 == 1) {
                extractor4.addWorker(currentWorker);
            } else {
                extractor5.addWorker(currentWorker);
            }
            //TODO company.addWorker
        }
        company.addExtractor(extractor1);
        company.addExtractor(extractor2);
        company.addExtractor(extractor3);
        company.addExtractor(extractor4);
        company.addExtractor(extractor5);

        for (int i = 0; i < 3; i++) {
            System.out.println("---Day " + i + " ----");
            company.update();
            System.out.println(company.getExtractorsWithFaults().toString());
            System.out.println(company.getRecentProductiveExtractors().toString());
        }
    }
}
