package com.khadri.log4j.controller;

import com.khadri.log4j.aspect.StudentInOut;
import com.khadri.log4j.model.StudentRequest;
import com.khadri.log4j.model.StudentResponse;
import com.khadri.log4j.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("student/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("get/hallticket")
    @StudentInOut(request = "#args[0]")
    public ResponseEntity<StudentResponse> getHallTicket(@RequestBody StudentRequest studentRequest) throws ExecutionException, InterruptedException {
        return studentService.getHallTicket(studentRequest);
    }
}