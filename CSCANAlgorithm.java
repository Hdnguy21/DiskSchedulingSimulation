import java.util.ArrayList;
import java.util.Collections;

public class CSCANAlgorithm extends ScheduleAlgorithmBase {
   public CSCANAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q) {
      super(initPosition, maxCylinders, direction, q);
   }

   public String getName() {
      return "C-SCAN";
   }

   public void calcSequence() {
      Collections.sort(referenceQueue);
      
      ArrayList<Integer> left = new ArrayList<>();
      ArrayList<Integer> right = new ArrayList<>();

      for (Integer r : referenceQueue) {
         if (r < position) {
            left.add(r);
         } else {
            right.add(r);
         }
      }

      if (direction == ScheduleAlgorithm.RIGHT) {
         for (int i = 0; i < right.size(); i++) {
            seekToSector(right.get(i));
         }
         // Go to the very end
         seekToSector(maxCylinders - 1);
         seekToSector(0);
         for (int i = 0; i < left.size(); i++) {
            seekToSector(left.get(i));
         }
      } else {
         for (int i = left.size() - 1; i >= 0; i--) {
            seekToSector(left.get(i));
         }
         // Go to the very beginning
         seekToSector(0);
         seekToSector(maxCylinders - 1);
         for (int i = right.size() - 1; i >= 0; i--) {
            seekToSector(right.get(i));
         }
      }
   }
}
