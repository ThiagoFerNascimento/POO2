package Concessionaria;

import com.mongodb.BasicDBObject;
import java.net.UnknownHostException;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;
import org.bson.*;

/**
 *
 * @author tfn-3
 */
public class ConexaoMongoDB {
    
    private final String url = "mongodb://localhost:27017";
    
    public void conectar() {
        
        try {   
           MongoClient mongoClient = new MongoClient(new MongoClientURI(url));
           DB database = mongoClient.getDB("poo2");
           DBCollection collection = database.getCollection("carros");
           
           DBObject query = new BasicDBObject("marca", "Fiat");
           DBCursor cursor = collection.find(query);
           
           System.out.println((String)cursor.one().get("placa"));
           
           // https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
           
            System.out.println("Conectado ao poo2");

            for(String name : database.getCollectionNames()) {
               
                System.out.println("Lista de Collections:");
                System.out.println(name);
            }

            mongoClient.close();
//marca, modelo, cor, quantidade_portas, versao, tipo, ano_fabricacao, placa, valor
        }   
        catch(UnknownHostException e)
        {   
           System.out.println(e);
        }  
    }
 }
    


