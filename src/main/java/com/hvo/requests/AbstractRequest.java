package com.hvo.requests;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractRequest implements Request {

    protected final Log logger = LogFactory.getLog(this.getClass());

    protected void logCurl() {
        String className = this.getClass().getName();
        logger.debug(className + ": " + getCurl());
    }

    protected abstract String getCurl();
}
