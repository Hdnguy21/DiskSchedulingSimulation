import java.util.*;

public class SCANAlgorithm extends ScheduleAlgorithmBase {
    private static final int DISK_SIZE = 200;

    public SCANAlgorithm(List<Integer> requests, int initialPos) {
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

        // Move right first, then return to left
        for (int request : right) {
            totalHeadMovement += calculateDistance(currentPosition, request);
            sequence.add(request);
            currentPosition = request;
        }

        // Move to the end if there are requests on the left
        if (!left.isEmpty()) {
            totalHeadMovement += calculateDistance(currentPosition, DISK_SIZE);
            currentPosition = DISK_SIZE;
        }

        // Now move left
        for (int request : left) {
            totalHeadMovement += calculateDistance(currentPosition, request);
            sequence.add(request);
            currentPosition = request;
        }

        return totalHeadMovement;
    }
}
