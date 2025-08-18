package LoggingFramework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import LoggingFramework.strategies.appender.LogAppender;

public class LogManager {
    private static final LogManager INSTANCE = new LogManager();
    private final Map<String, Logger> loggers = new ConcurrentHashMap<>();
    private final Logger rootLogger;
    private final AsyncLogProcessor processor;

    private LogManager() {
        this.rootLogger = new Logger("root", null);
        this.loggers.put("root", rootLogger);
        this.processor = new AsyncLogProcessor();
    }

    public static LogManager getInstance() {
        return INSTANCE;
    }

    public Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, this::createLogger);
    }

    private Logger createLogger(String name) {
        if (name.equals("root")) {
            return rootLogger;
        }
        int lastDot = name.lastIndexOf('.');
        String parentName = (lastDot == -1) ? "root" : name.substring(0, lastDot);
        Logger parent = getLogger(parentName);
        return new Logger(name, parent);
    }

    public Logger getRootLogger() {
        return rootLogger;
    }

    AsyncLogProcessor getProcessor() {
        return processor;
    }

    public void shutdown() {
        processor.stop();

        loggers.values().stream()
                .flatMap(logger -> logger.getAppenders().stream())
                .distinct()
                .forEach(LogAppender::close);
        System.out.println("Logging framework shut down gracefully.");
    }
}