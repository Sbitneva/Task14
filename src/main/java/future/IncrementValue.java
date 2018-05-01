package future;

import java.util.concurrent.Callable;

public class IncrementValue implements Callable<Long> {
    public static Long value = 0L;
    private static final Object sync = new Object();

    public Long call() {
        synchronized (sync) {
            value = value + 1L;
        }
        return value;
    }
}