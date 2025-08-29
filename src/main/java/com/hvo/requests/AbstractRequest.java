package com.hvo.requests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractRequest implements Request {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    protected void logCurl() {
        String className = this.getClass().getName();
        String message = className + ": " + this.getCurl();
        logger.debug(message);
    }

    protected abstract String getCurl();
}
