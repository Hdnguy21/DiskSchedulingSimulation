import java.util.ArrayList;
import java.util.Collections;

public class CLOOKAlgorithm extends ScheduleAlgorithmBase {
   public CLOOKAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q) {
      super(initPosition, maxCylinders, direction, q);
   }

   public String getName() {
      return "C-LOOK";
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
         // right side
         for (int i = 0; i < right.size(); i++) seekToSector(right.get(i));
         for (int i = 0; i < left.size(); i++) seekToSector(left.get(i));
      } else {
         // left side
         for (int i = left.size() - 1; i >= 0; i--) seekToSector(left.get(i));
         for (int i = right.size() - 1; i >= 0; i--) seekToSector(right.get(i));
      }
   }
}
