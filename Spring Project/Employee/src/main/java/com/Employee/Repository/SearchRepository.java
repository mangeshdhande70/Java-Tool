package com.Employee.Repository;

import com.Employee.model.Employee;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepository implements SearchRepo{


    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Employee> findByUnit(String text) {

        List<Employee> list = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("Infosy");
        MongoCollection<Document> collection = database.getCollection("Employee");

        AggregateIterable<Document> result = (AggregateIterable<Document>) ((MongoCollection<?>) collection).
                  aggregate(Arrays.asList(new Document("$search",
                              new Document("text",
                              new Document("query", text)
                                .append("path", "unit")))));

        result.forEach(document -> list.add(mongoConverter.read(Employee.class , document)));

        return list;
    }
}
