public class PerformanceTest {

    private static class SampleObject {
        private final int value;
        private final byte[] data = new byte[64];

        SampleObject(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Performance Measurement =====");
        MemoryMonitor.printMemoryReport("Start");

        int[] objectCounts = {10, 100, 1_000, 100_000, 1_000_000};

        System.out.println();
        System.out.printf("%-12s %-14s %-18s%n", "Objects", "Used Memory", "Execution Time");
        System.out.println("--------------------------------------------------");

        for (int count : objectCounts) {
            runAllocationTest(count);
        }

        System.out.println();
        System.out.println("Additional measurements:");
        measureLoopExecution();
        measureArrayAllocation();
        measureLargeByteArray();
    }

    private static void runAllocationTest(int count) {
        MemoryMonitor.triggerGarbageCollection();
        long memoryBefore = MemoryMonitor.getUsedMemoryBytes();
        long start = System.nanoTime();

        // TODO: allocate SampleObject[count], fill each slot
        SampleObject[] sampleObjects = new SampleObject[count];
        for (int i = 0; i < count; i++) {
            sampleObjects[i] = new SampleObject(i);
        }
        // TODO: measure elapsed ms + memoryUsed; printf row; null array + GC
        System.out.printf("%-13d %-13.2f %.2f ms %n", count, (double) MemoryMonitor.getUsedMemoryBytes() - memoryBefore,  (double) (System.nanoTime() - start) / 1000000.0);
        sampleObjects = null;
        System.gc();
        //throw new UnsupportedOperationException("TODO");
    }

    private static void measureLoopExecution() {
        // TODO: loop 10_000_000 iterations summing i into sum; print elapsed ms
        long start = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        System.out.printf("Loop Execution (10M Iterations): %.2f ms | sum = %d%n",  (double) (System.nanoTime() - start) / 1000000.0, sum);
        //throw new UnsupportedOperationException("TODO");
    }

    private static void measureArrayAllocation() {
        // TODO: allocate int[1_000_000], fill with i, print elapsed ms
        long start = System.nanoTime();
        int[] sum = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            sum[i] = i;
        }
        System.out.printf("Loop Execution (10M Iterations): %.2f ms %n", (double) (System.nanoTime() - start) / 1000000.0);

        //throw new UnsupportedOperationException("TODO");
    }

    private static void measureLargeByteArray() {
        MemoryMonitor.printMemoryReport("Before Large byte[]");
        // TODO: allocate 10 MB byte[]; print After report; null + GC; print After Releasing
        byte[] data = new byte[1024 * 1024 * 10];
        MemoryMonitor.printMemoryReport("After Large byte[]");
        data = null;
        System.gc();
        //throw new UnsupportedOperationException("TODO");
    }
}