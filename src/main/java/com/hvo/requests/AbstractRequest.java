package com.hvo.requests;

import com.hvo.requests.util.CurlUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractRequest implements Request {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    protected void logCurl() {
        String className = this.getClass().getName();
        String message = className + ": " + this.getCurl();
        logger.debug(message);
    }

    public String getCurl() {
        return CurlUtil.convertToCurlString(getRequest());
    }
}
