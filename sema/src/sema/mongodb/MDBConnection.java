package sema.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;

import sema.util.SProperties;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

//http://docs.mongodb.org/ecosystem/tutorial/getting-started-with-java-driver/

public class MDBConnection {

	static DB getConnection(){
		// To directly connect to a single MongoDB server (note that this will not auto-discover the primary even
		// if it's a member of a replica set:
		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient( SProperties.getHost() , SProperties.getPort() );
			DB db = mongoClient.getDB( SProperties.getDb());
			
			return db;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		MongoClient mongoClient;
		try {
			
			/**
			 * Display all databases.

	List<String> dbs = mongo.getDatabaseNames();
	for(String db : dbs){
		System.out.println(db);
	}
			 */
			mongoClient = new MongoClient( "localhost" , 27017 );
			DB db = mongoClient.getDB( "sema" );
			Set<String> colls = db.getCollectionNames();
			ArrayList<DBCollection> dbs = new ArrayList<DBCollection>();
			for (String s : colls) {
				dbs.add(db.getCollection(s));
			}
			BasicDBObject bdbo = new BasicDBObject("name", "MongoDB")
	        .append("type", "database")
	        .append("count", 1)
	        .append("info", new BasicDBObject("x", 203).append("y", 102));

			db.getCollection("testData").insert(bdbo);
			BasicDBObject query = new BasicDBObject("x", 5);
			
			DBObject dbo ;
			DBCursor cursor;
			for(DBCollection c:dbs){
				System.out.println(c.getName());
				dbo=c.findOne();
				System.out.println(dbo.toString());
				System.out.println(c.getCount());
				
				cursor = c.find(query);
				try {
				   while(cursor.hasNext()) {
				       System.out.println(cursor.next());
				   }
				} finally {
				   cursor.close();
				}

				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
