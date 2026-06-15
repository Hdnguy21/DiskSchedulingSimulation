import java.util.*;

public class DiskSchedulingSimulation {
    public static void main(String[] args) {
        // Initialize scheduling algorithms
        List<Integer> diskRequests = generateDiskRequests();
        int initialPosition = 50;

        System.out.println("=== Disk Scheduling Simulation ===");
        System.out.println("Initial Head Position: " + initialPosition);
        System.out.println("Disk Requests: " + diskRequests);
        System.out.println("Disk Size: 0-200 cylinders\n");

        // Test different scheduling algorithms
        testFCFS(diskRequests, initialPosition);
        testSCAN(diskRequests, initialPosition);
        testCSCAN(diskRequests, initialPosition);
        testCLOOK(diskRequests, initialPosition);
    }

    private static void testFCFS(List<Integer> requests, int initialPos) {
        FCFSAlgorithm fcfs = new FCFSAlgorithm(requests, initialPos);
        int totalHeadMovement = fcfs.calculateSchedule();
        System.out.println("--- FCFS (First Come First Served) ---");
        fcfs.displaySchedule();
        System.out.println();
    }

    private static void testSCAN(List<Integer> requests, int initialPos) {
        SCANAlgorithm scan = new SCANAlgorithm(requests, initialPos);
        int totalHeadMovement = scan.calculateSchedule();
        System.out.println("--- SCAN (Elevator Algorithm) ---");
        scan.displaySchedule();
        System.out.println();
    }

    private static void testCSCAN(List<Integer> requests, int initialPos) {
        CSCANAlgorithm cscan = new CSCANAlgorithm(requests, initialPos);
        int totalHeadMovement = cscan.calculateSchedule();
        System.out.println("--- C-SCAN (Circular SCAN) ---");
        cscan.displaySchedule();
        System.out.println();
    }

    private static void testCLOOK(List<Integer> requests, int initialPos) {
        CLOOKAlgorithm clook = new CLOOKAlgorithm(requests, initialPos);
        int totalHeadMovement = clook.calculateSchedule();
        System.out.println("--- C-LOOK (Circular LOOK) ---");
        clook.displaySchedule();
        System.out.println();
    }

    private static List<Integer> generateDiskRequests() {
        return Arrays.asList(98, 183, 37, 122, 14, 124, 65, 67);
    }
}
