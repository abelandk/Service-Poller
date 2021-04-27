package com.kry.services.helpers;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class HttpRequest {

    private RestTemplate restTemplate;

    public HttpRequest() {
        restTemplate = new RestTemplate();
    }

    /** Send a GET HTTP REQUEST and returns the status
        @param url the Url to Poll
        @return PollStatus returned
     */
    public PollStatus getRequest(String url)
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);

        try
        {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class, 1);
            if(responseEntity.getStatusCode() == HttpStatus.OK)
            {
                return PollStatus.OK;
            }
            else
            {
                return PollStatus.FAIL;
            }
        }
        catch (Exception e)
        {
            return PollStatus.INVALID_URL;
        }
    }
}
