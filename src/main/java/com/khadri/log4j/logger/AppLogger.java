package com.khadri.log4j.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLogger {

    private static final Logger errorLogger;
    private static final Logger serverLogger;
    private static final Logger payloadLogger;

    private enum LogLevels {
        FATAL, ERROR, WARN, INFO, DEBUG, TRACE;
    }

    static {
        errorLogger = LogManager.getLogger("error.logger");
        serverLogger = LogManager.getLogger("server.logger");
        payloadLogger = LogManager.getLogger("student.logger");
    }

    private AppLogger() {
    }

    private static void log(LogLevels logLevel, String message, Exception exception) {
        switch (logLevel) {
            case TRACE:
                serverLogger.trace(message);
                break;
            case INFO:
                payloadLogger.info(message);
                break;
            case DEBUG:
                serverLogger.debug(message);
                break;
            case WARN:
                errorLogger.warn(message, exception);
                break;
            case ERROR:
                errorLogger.error(message, exception);
                break;
            case FATAL:
                errorLogger.fatal(message, exception);
                break;
            default:
                break;
        }
    }

    public static void trace(String message) {
        log(LogLevels.TRACE, message, null);
    }

    public static void info(String message) {
        log(LogLevels.INFO, message, null);
    }

    public static void debug(String message) {
        log(LogLevels.DEBUG, message, null);
    }

    public static void warn(String message, Exception exception) {
        log(LogLevels.WARN, message, exception);
    }

    public static void error(String message, Exception exception) {
        log(LogLevels.ERROR, message, exception);
    }

    public static void fatal(String message, Exception exception) {
        log(LogLevels.FATAL, message, exception);
    }

    public static void studentPayLoadLogMessage(String message) {
        payloadLogger.info(message);
    }
}