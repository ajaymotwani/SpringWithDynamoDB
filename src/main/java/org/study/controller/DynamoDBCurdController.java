package org.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamodb")
public class DynamoDBCurdController {

    @GetMapping
    public String dynamoDBDemo() {
        return "dynamoDBDemo";
    }
}
