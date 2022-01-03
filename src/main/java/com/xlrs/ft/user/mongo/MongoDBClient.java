package com.xlrs.ft.user.mongo;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.ConnectionPoolSettings;
import com.xlrs.ft.user.cofig.SSLConfig;

@Component
public class MongoDBClient {


	/*
	 * private MongoClient getMongoClient() {
	 * 
	 * String username = "xlrsdocumentusr"; String password = "masterpass123";
	 * String clusterEndpoint =
	 * "xlrs-customer-data.cluster-cgutzdhdznex.ap-southeast-2.docdb.amazonaws.com:27017";
	 * 
	 * String template =
	 * "mongodb://%s:%s@%s/xlrs-customerbankdata?ssl=true&replicaSet=rs0&readpreference=%s";
	 * String readPreference = "secondaryPreferred"; String dbname =
	 * "xlrs-customer-data"; String connectionString = String.format(template,
	 * username, password, clusterEndpoint, readPreference);
	 * System.out.println("connection string found is : " + connectionString);
	 * 
	 * MongoClient mongoClient = MongoClients.create(connectionString); return
	 * mongoClient; }
	 */
	
	private MongoClient getMongoClient() throws Exception {
		SSLConfig.loadSSLProperties();
		
		String username = "xlrsdocumentusr";
		String password = "masterpass123";
		String clusterEndpoint = "xlrs-customer-data.cluster-cgutzdhdznex.ap-southeast-2.docdb.amazonaws.com:27017";

		String template = "mongodb://%s:%s@%s/xlrs-customerbankdata?ssl=true&replicaSet=rs0&readpreference=%s";
		String readPreference = "secondaryPreferred";
		String dbname = "xlrs-customer-data";
		String connectionString = String.format(template, username, password, clusterEndpoint, readPreference);
		System.out.println("connection string found is : " + connectionString);
		
		
        final MongoCredential credential = MongoCredential.createCredential(username, dbname, password.toCharArray());
        final MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .readPreference(ReadPreference.secondaryPreferred())
                .retryWrites(false)
                .applyToSslSettings(builder -> builder.enabled(true))
                .applyToConnectionPoolSettings(connPoolBuilder ->
                        ConnectionPoolSettings.builder().
                                maxSize(1).build())
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress(clusterEndpoint, 27017))))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        
        return mongoClient;
	}

	public MongoDatabase getMongoDatabase() throws Exception {
		MongoDatabase db = getMongoClient().getDatabase("xlrs-customer-data");
		return db;
	}
}
