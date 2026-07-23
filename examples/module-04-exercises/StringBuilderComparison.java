public class StringBuilderComparison {
    private static final int ITERATIONS = 50_000;

    static String withString() {
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            // TODO: result += "x";  (each update creates another String)
            result += "x";
        }
        return result;
    }

    static String withBuilder() {
        // Initial capacity avoids repeated buffer growth.
        // TODO: StringBuilder result = new StringBuilder(ITERATIONS);
        StringBuilder result = new StringBuilder(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            // TODO: result.append('x');
            result.append('x');
        }
        // TODO: return result.toString();
        return result.toString();
    }

    public static void main(String[] args) {
        // TODO: time withString() with System.nanoTime()
        double startTime = System.nanoTime();
        int withStringLength = withString().length();
        double endTime = System.nanoTime();
        double withStringTime = endTime - startTime;
        // TODO: time withBuilder() with System.nanoTime()
        startTime = System.nanoTime();
        int withBuilderLength = withBuilder().length();
        endTime = System.nanoTime();
        double withBuilderTime = endTime - startTime;
        // TODO: printf both lengths and ms (stringNanos / 1_000_000.0)
        System.out.printf("With String || Length: %s || Time %.2f ms %n With Builder || Length: %s || Time %.2f ms %n", withStringLength, withStringTime / 1000000.0, withBuilderLength, withBuilderTime / 1000000.0);
    }
}