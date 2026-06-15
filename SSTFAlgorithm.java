import java.util.ArrayList;

public class SSTFAlgorithm extends ScheduleAlgorithmBase {
    public SSTFAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q) {
       super(initPosition, maxCylinders, direction, q);
    }

    public String getName() {
       return "SSTF";
    }

    public void calcSequence() {
       while (referenceQueue.size() > 0) {
          int closestIndex = 0;
          int minDistance = Math.abs(position - referenceQueue.get(0));

	// closest request to the current head position	
          for (int i = 1; i < referenceQueue.size(); i++) {
             int currentDistance = Math.abs(position - referenceQueue.get(i));
             if (currentDistance < minDistance) {
                minDistance = currentDistance;
                closestIndex = i;
             }
          }
          seekToSector(referenceQueue.remove(closestIndex));
       }
    }
}
