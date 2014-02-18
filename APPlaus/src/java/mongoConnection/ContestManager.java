package mongoConnection;

import com.mongodb.*;
import com.mongodb.util.JSON;
import java.util.Date;

/**
 *
 * @author eirikstadheim
 */
public class ContestManager {
    
    /**
     * Gets the active contests from the database.
     * @param db DB object to contact database
     * @return json array of contest objects
     */
    public static String getActiveContests(DB db) {
        DBCollection coll = db.getCollection("contest");
        BasicDBObject query = new BasicDBObject();
	query.put("date_end", BasicDBObjectBuilder.start("$gte"
                , new Date()).get());
        //sort with next date first
        DBCursor cursor = coll.find(query).sort(new BasicDBObject( "date_end" , 1 ));
        return JSON.serialize(cursor);
    }

    /**
     * Gets the next 7(or less) inactive(finished) contests from the database.
     * @param db DB object to contact database
     * @param skip number of documents to skip before fetching the documents
     * @return json serialized array of the seven(or less) documents
     */
    public static String getInactiveContests(DB db, int skip) {
        DBCollection coll = db.getCollection("contest");
        BasicDBObject query = new BasicDBObject();
	query.put("date_end", BasicDBObjectBuilder.start("$lte", new Date()).get());
        //sort with last finished contest first
        DBCursor cursor = coll.find(query).sort(new BasicDBObject( "date_end" , -1 )).limit(7).skip(skip);
        return JSON.serialize(cursor);
    }

    
    
    
    /* Utdatert test
    public static String getContest(DB db, String idOfDoc) {
        DBCollection coll = db.getCollection("contest");
        ObjectId objectIdOfDoc = new ObjectId(idOfDoc);
        
        BasicDBObject whereQuery = new BasicDBObject();
	whereQuery.put("_id", objectIdOfDoc);
	DBCursor cursor = coll.find(whereQuery);
        
        String toReturn = "";
	while(cursor.hasNext()) {
            DBObject dbobj = cursor.next();
            Tools.formatObjectToJavascript(dbobj, new String[]{"_id", "date_created", "date_end"});
            toReturn += dbobj.toString();
	}
        return toReturn;
    }
*/
}
