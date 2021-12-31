package com.springboot.learning.learnwiremock.controller;

import com.springboot.learning.learnwiremock.entity.Response;
import com.springboot.learning.learnwiremock.service.DummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DummyController {
    Logger log = LoggerFactory.getLogger(DummyController.class);

    DummyService dummyService;

    @Autowired
    public void setDummyService(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    public Response<String> get(@PathVariable("id") String id) {
        return dummyService.get(id);
    }
}
