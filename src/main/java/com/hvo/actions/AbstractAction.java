package com.hvo.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hvo.requests.Request;
import com.hvo.responses.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public abstract class AbstractAction<T extends Response> implements Action<T> {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Log logger = LogFactory.getLog(this.getClass());

    protected T execute(Request request, Class<T> responseClazz) {
        try {
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(request.getRequest());
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();

            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            T responseObject;
            if (httpEntity != null) {
                String jsonString = EntityUtils.toString(httpEntity);
                logger.debug("HttpResponseEntity: " + jsonString);
                responseObject = createObject(jsonString, statusCode, responseClazz);
            } else {
                responseObject = createObject(statusCode, responseClazz);
            }
            return responseObject;
        } catch (Exception ex) {
            logger.error(ex);
        } finally {
            try {
                httpClient.close();
            } catch (IOException ex) {
                logger.error(ex);
            }
        }
        return null;
    }

    private T createObject(String jsonString, int statusCode, Class<T> clazz) throws IOException {
        T convertedObject = objectMapper.readValue(jsonString, clazz);
        convertedObject.setResponseCode(statusCode);
        logger.debug(clazz.getName() + ": " + convertedObject);
        return convertedObject;
    }

    private T createObject(int statusCode, Class<T> clazz) throws ReflectiveOperationException {
        T object = clazz.getDeclaredConstructor().newInstance();
        object.setResponseCode(statusCode);
        logger.debug(clazz.getName() + ": " + object);
        return object;
    }

}
