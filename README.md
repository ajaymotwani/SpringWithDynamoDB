# SpringWithDynamoDB
SpringWithDynamoDB

To run it in local you need Intellij with lombok plugin enabled.
Modify application.yml file with your aws access key, secret-key and region 
Sample request body
```
{
    "lastName": "LastNameStudent",
    "firstName": "FirstNameStudent",
    "age": 18,
    "address": {
        "state": "MH",
        "city": "Mumbai",
        "zipCode": "400100"
    }
}
```