package org.mule.modules.documentdb;

import java.io.IOException;
import java.util.List;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.param.Default;

import org.mule.modules.documentdb.config.ConnectorConfig;
import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.Database;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.DocumentCollection;
import com.microsoft.azure.documentdb.RequestOptions;



@Connector(name="document-db", friendlyName="DocumentDB")
public class DocumentDBConnector {

    // Replace with your DocumentDB end point and master key.
//    private static final String END_POINT = "https://mulesoft.documents.azure.com:443/";
//    private static final String MASTER_KEY = "m9wrosPmWlhgiO2Z35m6t6dujiqhVJbeljUrSELxtxR6ZYGmp9LSgIrfrPzsV2jtG1ClrKMnazsvQmmIAnsS2A==";
	
	
    @Config
    ConnectorConfig config;

    
	/**
	* Description for CreateDatabase
	*
	* {@sample.xml ../../../doc/document-db-connector.xml.sample document-db:CreateDatabase}
	*
	*	@param param The comment for param
	*	@return return comment
	*/
	@Processor
	public Object createDatabase(@FriendlyName("Database ID") String databaseID) throws DocumentClientException {
		DocumentClient documentClient = new DocumentClient(config.getEndPoint(),
        		config.getMasterKey(), ConnectionPolicy.GetDefault(),
                ConsistencyLevel.Session);
       

        // Define a new database using the id above.
        Database myDatabase = new Database();
        myDatabase.setId(databaseID);

        // Create a new database.
        myDatabase = documentClient.createDatabase(myDatabase, null)
                .getResource();

		
		
		return null;
	}
	
	
	/**
	* Description for CreateCollection
	*
	* {@sample.xml ../../../doc/document-db-connector.xml.sample document-db:CreateCollection}
	*
	*	@param param The comment for param
	*	@return return comment
	*/
	@Processor
	public Object createCollection(@FriendlyName("Database ID") String databaseID, @FriendlyName("Collection ID") String collectionID) throws DocumentClientException {
		DocumentClient documentClient = new DocumentClient(config.getEndPoint(),
        		config.getMasterKey(), ConnectionPolicy.GetDefault(),
                ConsistencyLevel.Session);
		
		// Define a new collection using the id above.
        DocumentCollection myCollection = new DocumentCollection();
        myCollection.setId(collectionID);

        // Set the provisioned throughput for this collection to be 1000 RUs.
        RequestOptions requestOptions = new RequestOptions();
        //requestOptions.setOfferThroughput(1000);

        // Create a new collection.
        myCollection = documentClient.createCollection(
                "dbs/" + databaseID, myCollection, requestOptions)
                .getResource();
		return null;
	}

    
	/**
	* Description for Insert
	*
	* {@sample.xml ../../../doc/document-db-connector.xml.sample document-db:Insert}
	*
	*	@param param The comment for param
	*	@return return comment
	*/
	@Processor
	public Object Insert(@Default("#[payload]") String document, @FriendlyName("Database ID") String databaseID, @FriendlyName("Collection ID") String collectionID)  throws DocumentClientException {
		
		// Instantiate a DocumentClient w/ your DocumentDB Endpoint and AuthKey.
        DocumentClient documentClient = new DocumentClient(config.getEndPoint(),
        		config.getMasterKey(), ConnectionPolicy.GetDefault(),
                ConsistencyLevel.Session);

		
		Document allenDocument = new Document(document);
		
		

        // Create document.
        allenDocument = documentClient.createDocument(
                "dbs/" + databaseID + "/colls/" + collectionID, allenDocument, null, false)
                .getResource();
		
		return null;
	}
	
	
	/**
	* Description for query
	*
	* {@sample.xml ../../../doc/document-db-connector.xml.sample document-db:query}
	*
	*	@param param The comment for param
	*	@return return comment
	*/
	@Processor
	public List<Document> query(@Default("#[payload]") String queryString, @FriendlyName("Database ID") String databaseID, @FriendlyName("Collection ID") String collectionID)  throws DocumentClientException {
		
		DocumentClient documentClient = new DocumentClient(config.getEndPoint(),
        		config.getMasterKey(), ConnectionPolicy.GetDefault(),
                ConsistencyLevel.Session);
		
		// Query documents
        List<Document> results = documentClient
                .queryDocuments(
                        "dbs/" + databaseID + "/colls/" + collectionID,
                        queryString,
                        null).getQueryIterable().toList();
        return results;
	}
	
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}