# Disk Scheduling Simulation

This project implements various disk scheduling algorithms commonly used in operating systems to optimize disk head movement and improve I/O performance.

## Algorithms Implemented

### 1. FCFS (First Come First Served)
- Services requests in the order they arrive
- Simple but can result in significant head movement
- No optimization for disk head position

### 2. SCAN (Elevator Algorithm)
- Head moves in one direction servicing all requests
- When reaching the end, reverses direction
- Provides better performance than FCFS

### 3. C-SCAN (Circular SCAN)
- Similar to SCAN but head returns to starting position after reaching the end
- Provides more uniform wait times
- Better for systems requiring fairness

### 4. C-LOOK (Circular LOOK)
- Improvement over C-SCAN
- Doesn't go all the way to disk end, only to the farthest request
- More efficient than C-SCAN

## Project Structure

```
src/
├── ScheduleAlgorithmBase.java  (Abstract base class)
├── FCFSAlgorithm.java
├── SCANAlgorithm.java
├── CSCANAlgorithm.java
├── CLOOKAlgorithm.java
└── DiskSchedulingSimulation.java (Main driver)
```

## Running the Simulation

### Compile
```bash
javac src/*.java
```

### Run
```bash
java -cp src DiskSchedulingSimulation
```

## Example Output

```
=== Disk Scheduling Simulation ===
Initial Head Position: 50
Disk Requests: [98, 183, 37, 122, 14, 124, 65, 67]
Disk Size: 0-200 cylinders

--- FCFS (First Come First Served) ---
Scheduling Sequence: [50, 98, 183, 37, 122, 14, 124, 65, 67]
Total Head Movement: 640

--- SCAN (Elevator Algorithm) ---
Scheduling Sequence: [50, 65, 67, 98, 122, 124, 183, 14, 37]
Total Head Movement: 236

--- C-SCAN (Circular SCAN) ---
Scheduling Sequence: [50, 65, 67, 98, 122, 124, 183, 0, 37, 14]
Total Head Movement: 385

--- C-LOOK (Circular LOOK) ---
Scheduling Sequence: [50, 65, 67, 98, 122, 124, 183, 37, 14]
Total Head Movement: 352
```

## Algorithm Comparison

| Algorithm | Best Case | Worst Case | Average Performance |
|-----------|-----------|------------|---------------------|
| FCFS | Requests in order | Random scattered requests | Poor |
| SCAN | Evenly distributed requests | Heavily loaded system | Good |
| C-SCAN | High fairness required | Heavily one-sided requests | Very Good |
| C-LOOK | Similar to C-SCAN | Similar to C-SCAN | Excellent |

## Notes

- Disk size is set to 0-200 cylinders
- Initial head position is at cylinder 50
- All algorithms start from the same initial position and process the same request queue
- Total head movement is measured in cylinders
