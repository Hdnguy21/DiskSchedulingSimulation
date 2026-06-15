import java.util.*;

public class FCFSAlgorithm extends ScheduleAlgorithmBase {
    public FCFSAlgorithm(List<Integer> requests, int initialPos) {
        super(requests, initialPos);
    }

    @Override
    public int calculateSchedule() {
        int currentPosition = initialPosition;
        sequence.add(currentPosition);

        // Process requests in FIFO order
        for (int request : diskRequests) {
            totalHeadMovement += calculateDistance(currentPosition, request);
            sequence.add(request);
            currentPosition = request;
        }

        return totalHeadMovement;
    }
}
