# Disk Scheduling Simulation

## Course Context
Built for ACO350 (Operating Systems Principles) at Arizona State University. The assignment required implementing 10 disk scheduling algorithm variations using a strict OOP architecture — enforcing an interface, abstract base class, and polymorphic subclasses per a mandatory UML class hierarchy.

## Tech Stack
- **Language:** Java (Standard Edition)
- **Libraries:** java.util.ArrayList, java.util.Collections, java.util.Scanner
- **Tools:** GNU Make, javac compiler, UNIX CLI, SSH/SCP for remote development

## What It Does
Simulates how an operating system manages hard disk head movement across data tracks. Takes a list of requested disk sectors and calculates the total travel distance each algorithm requires, enabling direct performance comparison across all scheduling strategies.

## Algorithms Implemented (10 Variations)
- **FCFS** — First Come First Served
- **SSTF** — Shortest Seek Time First (greedy)
- **SCAN (R/L)** — Elevator algorithm, both directions
- **C-SCAN (R/L)** — Circular SCAN with loop reset
- **LOOK (R/L)** — Boundary-optimized SCAN reversal
- **C-LOOK (R/L)** — Circular LOOK variant

## Key Technical Features
- Directional data partitioning — splits sector request queues into left/right sub-lists relative to dynamic disk head position
- Cumulative head travel distance tracking using Math.abs() across all algorithm variants
- Full traversal path history logged as string output per run
- Dual input mode — fixed textbook data sequence or randomized simulation array via CLI loop

## How to Run
```bash
# Compile
javac *.java

# Run
java DiskSchedulingSimulation
```

## File Structure
- `DiskSchedulingSimulation.java` — Main driver class and CLI input loop
- `ScheduleAlgorithm.java` — Interface defining the algorithm contract
- `ScheduleAlgorithmBase.java` — Abstract base class with shared state tracking
- `FCFSAlgorithm.java` — First Come First Served
- `SSTFAlgorithm.java` — Shortest Seek Time First
- `SCANAlgorithm.java` — SCAN (Elevator) both directions
- `CSCANAlgorithm.java` — Circular SCAN both directions
- `LOOKAlgorithm.java` — LOOK both directions
- `CLOOKAlgorithm.java` — Circular LOOK both directions
- All algorithms start from the same initial position and process the same request queue
- Total head movement is measured in cylinders
