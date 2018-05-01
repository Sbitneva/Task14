package future;

import java.util.concurrent.Callable;

public class IncrementValue implements Callable<Long> {
    private static final Object sync = new Object();
    private Long value = 0L;

    public IncrementValue() {
        value = 0L;
    }

    public Long call() {
        synchronized (sync) {
            value = value + 1L;
        }
        return value;
    }

    public Long getValue() {
        return value;
    }
}