package org.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.study.dao.DynamoDBRepository;
import org.study.entities.Student;

@Service
public class DynamoDBCurdService {

    @Autowired
    private DynamoDBRepository dynamoDBRepository;

    public String insertIntoDynamoDB(Student student) {
        dynamoDBRepository.insertIntoDynamoDB(student);
        return "Successfully inserted";
    }

    public String updateStudentDynamoDB(Student student) {
        dynamoDBRepository.updateStudentDynamoDB(student);
        return "Successfully inserted";
    }

    public ResponseEntity<Student> getOneStudentFromDynamoDB(String studentId, String lastName) {
        Student student = dynamoDBRepository.getOneStudentFromDynamoDB(studentId, lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    public String deleteOneStudent(String studentId, String lastName) {
        Student student = new Student();
        student.setStudentId(studentId);
        student.setLastName(lastName);
        dynamoDBRepository.deleteOneStudent(student);
        return "Successfully deleted";
    }
}
