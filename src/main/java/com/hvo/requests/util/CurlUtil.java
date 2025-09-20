package com.hvo.requests.util;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CurlUtil {

    private static final Logger logger = LogManager.getLogger(CurlUtil.class);

    public static String convertToCurlString(HttpRequestBase request) {
        String requestMethod = request.getMethod();
        StringBuilder builder = new StringBuilder();
        builder.append("curl " + request.getURI().toString())
                .append(" --request " + requestMethod)
                .append(" --verbose ");
        for (Header header : request.getAllHeaders()) {
            String headerString = new StringBuilder()
                    .append(" --header ")
                    .append("'" + header.getName())
                    .append(": " + header.getValue() + "'").toString();
            builder.append(headerString);
        }
        if ("POST".equals(requestMethod)) {
            HttpEntityEnclosingRequestBase enclosingRequest = (HttpEntityEnclosingRequestBase) request;
            HttpEntity entity = enclosingRequest.getEntity();
            try {
                InputStream inputStream = entity.getContent();
                String data = createString(inputStream);
                builder.append(" --data '" + data).append("'");
            } catch (IOException ex) {
                logger.error(ex);
            }
        }
        return builder.toString();
    }

    private static String createString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int length; (length = inputStream.read(buffer)) != -1; ) {
            outputStream.write(buffer, 0, length);
        }
        return outputStream.toString(StandardCharsets.UTF_8.name());
    }
}
