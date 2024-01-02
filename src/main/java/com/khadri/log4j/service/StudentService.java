package com.khadri.log4j.service;

import com.khadri.log4j.model.StudentRequest;
import com.khadri.log4j.model.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

@Service
public class StudentService {

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<StudentResponse> getHallTicket(@RequestBody StudentRequest studentRequest) throws ExecutionException, InterruptedException {

//        need to configure the URI for getting Hall ticket Number for the given student information

        String uri="https://webhook.site/69384eca-573f-415d-bda4-73c7f95879f4";
        return new ResponseEntity<>(executorService.submit(() -> restTemplate.postForEntity(uri, studentRequest, StudentResponse.class).getBody()).get(), HttpStatus.CREATED);
    }
}
