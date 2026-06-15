import java.util.*;

public abstract class ScheduleAlgorithmBase {
    protected List<Integer> diskRequests;
    protected int initialPosition;
    protected List<Integer> sequence;
    protected int totalHeadMovement;

    public ScheduleAlgorithmBase(List<Integer> requests, int initialPos) {
        this.diskRequests = new ArrayList<>(requests);
        this.initialPosition = initialPos;
        this.sequence = new ArrayList<>();
        this.totalHeadMovement = 0;
    }

    public abstract int calculateSchedule();

    public void displaySchedule() {
        System.out.println("Scheduling Sequence: " + sequence);
        System.out.println("Total Head Movement: " + totalHeadMovement);
    }

    protected int calculateDistance(int from, int to) {
        return Math.abs(from - to);
    }
}
