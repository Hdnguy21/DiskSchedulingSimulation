import java.util.ArrayList;
import java.util.Collections;

public class SCANAlgorithm extends ScheduleAlgorithmBase {
   public SCANAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q) {
      super(initPosition, maxCylinders, direction, q);
   }

   public String getName() {
      return "SCAN";
   }

   public void calcSequence() {
      // Sort the queue first
      Collections.sort(referenceQueue);
      
      ArrayList<Integer> left = new ArrayList<>();
      ArrayList<Integer> right = new ArrayList<>();

      // Show requests to the left and right
      for (Integer r : referenceQueue) {
         if (r < position) {
            left.add(r);
         } else {
            right.add(r);
         }
      }

      if (direction == ScheduleAlgorithm.RIGHT) {
         // Right: Go towards maxCylinders
         for (int i = 0; i < right.size(); i++) {
            seekToSector(right.get(i));
         }
         seekToSector(maxCylinders - 1);
         for (int i = left.size() - 1; i >= 0; i--) {
            seekToSector(left.get(i));
         }
      } else {
         // Left: Go towards 0
         for (int i = left.size() - 1; i >= 0; i--) {
            seekToSector(left.get(i));
         }
         seekToSector(0);
         for (int i = 0; i < right.size(); i++) {
            seekToSector(right.get(i));
         }
      }
   }
}
