package com.lld.multithreadedlogging.model.message;

import com.lld.multithreadedlogging.constant.LogLevel;
import com.lld.multithreadedlogging.constant.SupportedLogMedium;

public class WritableMessage {
    /*
        WritableMessage wraps an instance of ApplicationAwareMessage so that we can log extra
        metadata if required while actually logging the application message.
     */
    private ApplicationAwareMessage applicationAwareMessage;
    private LogLevel logLevel;
    private SupportedLogMedium medium;
    private Thread sourceThread;

    public WritableMessage(ApplicationAwareMessage applicationAwareMessage, LogLevel logLevel, SupportedLogMedium medium) {
        this.applicationAwareMessage = applicationAwareMessage;
        this.logLevel = logLevel;
        this.medium = medium;
        this.sourceThread = applicationAwareMessage.getThread();
    }

    public SupportedLogMedium getMedium() {
        return this.medium;
    }

    @Override
    public String toString() {
        return "Log Level = " + logLevel
                + " Thread - " + sourceThread.getName()
                + " timestamp = " + applicationAwareMessage.getTime().toString()
                + " message = " + applicationAwareMessage.getMsg();
    }
}
