public class GarbageCollectionDemo {

    private static class DemoObject {
        private final String label;
        private final byte[] payload = new byte[128];

        DemoObject(String label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Garbage Collection Demonstration =====");
        long startTime = System.nanoTime();

        MemoryMonitor.printMemoryReport("Before Allocation");

        DemoObject[] objects = new DemoObject[100000];
        int objectCount = 0;
        System.out.println("Creating Objects...");
        // TODO: fill objects[i] = new DemoObject("Object-" + i)
        for (int i = 0; i < 100000; i++) {
            objects[i] = new DemoObject("Object-" + i);
            objectCount++;
        }
        // TODO: print Objects Created count; printMemoryReport After Allocation
        System.out.printf("Objects Created: %s%n", objectCount);
        MemoryMonitor.printMemoryReport("After Allocation");

        // TODO: set objects = null; trigger GC; print After GC report + elapsed ms
        objects = null;
        System.gc();
        MemoryMonitor.printMemoryReport("After GC");
        System.out.printf("Execution Time : %.2f ms %n", (System.nanoTime() - startTime) / 1000000.0);
        // Tip: elapsedMillis = (System.nanoTime() - startTime) / 1_000_000
    }
}