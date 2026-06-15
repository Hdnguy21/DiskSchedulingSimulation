import java.util.*;

public class CLOOKAlgorithm extends ScheduleAlgorithmBase {
    private static final int DISK_SIZE = 200;

    public CLOOKAlgorithm(List<Integer> requests, int initialPos) {
        super(requests, initialPos);
    }

    @Override
    public int calculateSchedule() {
        // Separate requests into left and right of initial position
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int request : diskRequests) {
            if (request < initialPosition) {
                left.add(request);
            } else {
                right.add(request);
            }
        }

        // Sort both lists
        Collections.sort(left, Collections.reverseOrder());
        Collections.sort(right);

        int currentPosition = initialPosition;
        sequence.add(currentPosition);

        // Move right first
        for (int request : right) {
            totalHeadMovement += calculateDistance(currentPosition, request);
            sequence.add(request);
            currentPosition = request;
        }

        // Jump to leftmost request instead of disk end
        if (!left.isEmpty()) {
            int leftmost = left.get(0);
            totalHeadMovement += calculateDistance(currentPosition, leftmost);
            currentPosition = leftmost;

            // Service left requests from highest to lowest
            for (int i = left.size() - 1; i >= 0; i--) {
                int request = left.get(i);
                if (request != currentPosition) {
                    totalHeadMovement += calculateDistance(currentPosition, request);
                    currentPosition = request;
                }
                sequence.add(request);
            }
        }

        return totalHeadMovement;
    }
}
