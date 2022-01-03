package com.xlrs.ft.user.cofig;

import com.mongodb.client.*;
import org.bson.Document;

public final class MongoTestClient {
    private MongoTestClient() {
    }
    public static void main(String[] args) throws Exception {
    	
    	SSLConfig.loadSSLProperties();
    	
        String template = "mongodb://%s:%s@%s/sample-database?ssl=true&replicaSet=rs0&readpreference=%s";
        String username = "xlrsdocumentusr";
        String password = "masterpass123";
        String clusterEndpoint = "xlrs-customer-data.cluster-cgutzdhdznex.ap-southeast-2.docdb.amazonaws.com:27017";
       String readPreference = "secondaryPreferred";
        String connectionString = String.format(template, username, password, clusterEndpoint, readPreference);

        String truststore = "sys-connect-via-ssl-test-cacerts.jks";
        String truststorePassword = "changeit";

        System.setProperty("javax.net.ssl.trustStore", truststore);
        System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase testDB = mongoClient.getDatabase("xlrs-customer-data");
        testDB.createCollection("user-test-collection");
        MongoCollection<Document> numbersCollection = testDB.getCollection("user-test-collection");

        Document doc = new Document("name", "pi").append("value", 3.14159);
        numbersCollection.insertOne(doc);

        MongoCursor<Document> cursor = numbersCollection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

    }
}
