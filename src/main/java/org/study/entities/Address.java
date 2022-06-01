package org.study.entities;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@DynamoDBDocument
public class Address {

    @DynamoDBAttribute
    private String city;
    @DynamoDBAttribute
    private String state;
    @DynamoDBAttribute
    private String zipCode;

}
