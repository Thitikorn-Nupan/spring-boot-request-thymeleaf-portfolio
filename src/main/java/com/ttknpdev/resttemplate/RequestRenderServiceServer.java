package com.ttknpdev.resttemplate;

import com.ttknpdev.logging.Logback;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
    This class works for active server every 10 minutes
*/
public class RequestRenderServiceServer {

    private RestTemplate restTemplate ;
    private HttpHeaders headers;
    private final String URL1 = "https://ttknpde-v-portfolio.onrender.com/server"; // request portfolio
    private final String URL2 = "https://request-ttknpde-v-portfolio.onrender.com/server"; // request own
    private Logback logback;

    public RequestRenderServiceServer() {
        restTemplate = new RestTemplate();
        logback = new Logback(RequestRenderServiceServer.class);
    }

    public void requestRenderServer() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity< String > entity = new HttpEntity<>(headers);
        ResponseEntity< String > response = restTemplate.exchange(URL1 , HttpMethod.GET , entity , String.class);
        logback.log.warn(response.getBody());
        response = restTemplate.exchange(URL2 , HttpMethod.GET , entity , String.class);
        logback.log.warn(response.getBody());
    }
}
