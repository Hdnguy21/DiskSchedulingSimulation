import java.util.*;

public class CSCANAlgorithm extends ScheduleAlgorithmBase {
    private static final int DISK_SIZE = 200;

    public CSCANAlgorithm(List<Integer> requests, int initialPos) {
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

        // Move right first to the end
        for (int request : right) {
            totalHeadMovement += calculateDistance(currentPosition, request);
            sequence.add(request);
            currentPosition = request;
        }

        // Move to the end of disk
        totalHeadMovement += calculateDistance(currentPosition, DISK_SIZE);
        currentPosition = DISK_SIZE;

        // Jump to beginning and service left requests
        totalHeadMovement += calculateDistance(currentPosition, 0);
        currentPosition = 0;

        // Now move right servicing left requests (in reverse order)
        for (int i = left.size() - 1; i >= 0; i--) {
            int request = left.get(i);
            totalHeadMovement += calculateDistance(currentPosition, request);
            sequence.add(request);
            currentPosition = request;
        }

        return totalHeadMovement;
    }
}
