package LoggingFramework;

import LoggingFramework.entities.LogMessage;
import LoggingFramework.strategies.appender.LogAppender;

import java.util.List;
import java.util.concurrent.*;

class AsyncLogProcessor {
    private final ExecutorService executor;

    public AsyncLogProcessor() {
        this.executor = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "AsyncLogProcessor");
            thread.setDaemon(true); 
            return thread;
        });
    }

    public void process(LogMessage logMessage, List<LogAppender> appenders) {
        if (executor.isShutdown()) {
            System.err.println("Logger is shut down. Cannot process log message.");
            return;
        }

        executor.submit(() -> {
            for (LogAppender appender : appenders) {
                appender.append(logMessage);
            }
        });
    }

    public void stop() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.err.println("Logger executor did not terminate in the specified time.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
