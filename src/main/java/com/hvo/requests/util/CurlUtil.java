package com.hvo.requests.util;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestBase;

public class CurlUtil {

    public static String convertToCurlString(HttpRequestBase request) {
        StringBuilder builder = new StringBuilder();
        builder.append("curl " + request.getURI().toString())
                .append(" --request " + request.getMethod())
                .append(" --verbose ");
        for (Header header : request.getAllHeaders()) {
            String headerString = new StringBuilder()
                    .append(" --header ")
                    .append("'" + header.getName())
                    .append(": " + header.getValue() + "'").toString();
            builder.append(headerString);
        }
        return builder.toString();
    }
}
