package org.study.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.entities.Student;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DynamoDBRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void insertIntoDynamoDB(Student student) {
        dynamoDBMapper.save(student);
    }

    public void updateStudentDynamoDB(Student student) {
        dynamoDBMapper.save(student, buildDynamoDBSaveExpression(student));
    }

    public Student getOneStudentFromDynamoDB(String studentId, String lastName) {
        return dynamoDBMapper.load(Student.class, studentId, lastName);
    }

    public void deleteOneStudent(Student student) {
        dynamoDBMapper.delete(student);
    }

    private DynamoDBSaveExpression buildDynamoDBSaveExpression(Student student) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expected = new HashMap<>();
        expected.put("studentId", new ExpectedAttributeValue(new AttributeValue(student.getStudentId()))
                .withComparisonOperator(ComparisonOperator.EQ));
        dynamoDBSaveExpression.setExpected(expected);
        return dynamoDBSaveExpression;
    }

}
