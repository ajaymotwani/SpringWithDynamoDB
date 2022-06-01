package org.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.study.entities.Student;
import org.study.service.DynamoDBCurdService;

@RestController
@RequestMapping("/dynamodb")
public class DynamoDBCurdController {

    @Autowired
    private DynamoDBCurdService dynamoDBCurdService;

    @PostMapping
    public String insertIntoDynamoDB(@RequestBody Student student) {
        return dynamoDBCurdService.insertIntoDynamoDB(student);
    }

    @PutMapping
    public String updateStudentDynamoDB(@RequestBody Student student) {
        return dynamoDBCurdService.updateStudentDynamoDB(student);
    }

    @GetMapping
    public ResponseEntity<Student> getOneStudentFromDynamoDB(@RequestParam String studentId, @RequestParam String lastName) {
        return dynamoDBCurdService.getOneStudentFromDynamoDB(studentId, lastName);
    }

    @DeleteMapping
    public String deleteOneStudent(@PathVariable String studentId, @PathVariable String lastName) {
        return dynamoDBCurdService.deleteOneStudent(studentId, lastName);
    }

}
