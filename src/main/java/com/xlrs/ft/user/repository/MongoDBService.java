package com.xlrs.ft.user.repository;
import java.util.Date;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.xlrs.ft.commons.exception.ApplicationException;
import com.xlrs.ft.user.mongo.MongoDBClient;

@Service
public class MongoDBService {

	@Autowired
	private MongoDBClient mongoDBClient;

	public void insert(String jsonString) throws Exception{
		try {
			MongoDatabase db = mongoDBClient.getMongoDatabase();
			MongoCollection<Document> table = db.getCollection("userCollection");
			Document doc = new Document("customerData",  jsonString);
			doc.append("createdDate", new Date());
			table.insertOne(doc);
		}catch(Exception ex) {
			throw new ApplicationException("MongoDB data insertion failed " + ex.getLocalizedMessage());
		}
	}


}