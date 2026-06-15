import java.util.ArrayList;
import java.util.Collections;

public class LOOKAlgorithm extends ScheduleAlgorithmBase {
   public LOOKAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q) {
      super(initPosition, maxCylinders, direction, q);
   }

   public String getName() {
      return "LOOK";
   }

   public void calcSequence() {
      Collections.sort(referenceQueue);
      ArrayList<Integer> left = new ArrayList<>();
      ArrayList<Integer> right = new ArrayList<>();

      // Split requests into left and right lists
      for (Integer r : referenceQueue) {
         if (r < position) {
            left.add(r);
         } else {
            right.add(r);
         }
      }

      if (direction == ScheduleAlgorithm.RIGHT) {
         // smallest to largest (right side)
         for (int i = 0; i < right.size(); i++) seekToSector(right.get(i));
         // largest to smallest (left side)
         for (int i = left.size() - 1; i >= 0; i--) seekToSector(left.get(i));
      } else {
         for (int i = left.size() - 1; i >= 0; i--) seekToSector(left.get(i));
         for (int i = 0; i < right.size(); i++) seekToSector(right.get(i));
      }
   }
}
