import java.util.*;

public class DiskSchedulingSimulation {
    public static void main(String[] args) {
        // Initialize scheduling algorithms
        List<Integer> diskRequests = generateDiskRequests();
        int initialPosition = 50;
        
        System.out.println("=== Disk Scheduling Simulation ===\n");
        System.out.println("Initial Head Position: " + initialPosition);
        System.out.println("Disk Requests: " + diskRequests + "\n");
        
        // Test different scheduling algorithms
        testFCFS(diskRequests, initialPosition);
        testSCAN(diskRequests, initialPosition);
        testCSCAN(diskRequests, initialPosition);
    }
    
    private static void testFCFS(List<Integer> requests, int initialPos) {
        FCFSAlgorithm fcfs = new FCFSAlgorithm(requests, initialPos);
        int totalHeadMovement = fcfs.calculateSchedule();
        System.out.println("FCFS Algorithm:");
        System.out.println("  Total Head Movement: " + totalHeadMovement + " cylinders\n");
    }
    
    private static void testSCAN(List<Integer> requests, int initialPos) {
        SCANAlgorithm scan = new SCANAlgorithm(requests, initialPos);
        int totalHeadMovement = scan.calculateSchedule();
        System.out.println("SCAN Algorithm:");
        System.out.println("  Total Head Movement: " + totalHeadMovement + " cylinders\n");
    }
    
    private static void testCSCAN(List<Integer> requests, int initialPos) {
        CSCANAlgorithm cscan = new CSCANAlgorithm(requests, initialPos);
        int totalHeadMovement = cscan.calculateSchedule();
        System.out.println("C-SCAN Algorithm:");
        System.out.println("  Total Head Movement: " + totalHeadMovement + " cylinders\n");
    }
    
    private static List<Integer> generateDiskRequests() {
        return Arrays.asList(98, 183, 37, 122, 14, 124, 65, 67);
    }
}
