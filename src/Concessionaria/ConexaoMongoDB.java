package Concessionaria;

import com.mongodb.BasicDBObject;
import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
/**
 *
 * @author tfn-3
 */
public class ConexaoMongoDB {
    
    private final String url = "mongodb://localhost:27017";
    private MongoClient mongoClient;
    
    public void conectar() {
        
        try {   
            
           if(mongoClient == null) {
               
               mongoClient = new MongoClient(new MongoClientURI(url));
               System.out.println("[ Mongo ] Uma nova conexão com o MongoDB foi criada.");
               
           } else {
               System.out.println("[ Mongo ] Conexao com o MongoDB já existente, nova instância não foi criada.");
           }
        }   
        catch(UnknownHostException e)
        {   
           System.out.println(e);
        }  
    }
    
    public void cadastrarCarro(String marca, String modelo, String cor, 
            String quantidadePortas, String versao, String tipo, String anoFabricacao,
            String placa, String valor) {
        
        if(mongoClient != null) {
        
            DB database = mongoClient.getDB("poo2");
            DBCollection collection = database.getCollection("carros");
            
            BasicDBObject document = new BasicDBObject();
            document.put("marca", marca);
            document.put("modelo", modelo);
            document.put("cor", cor);
            document.put("quantidade_portas", quantidadePortas);
            document.put("versao", versao);
            document.put("tipo", tipo);
            document.put("ano_fabricacao", anoFabricacao);
            document.put("placa", placa);
            document.put("valor", valor);
            
            collection.insert(document);
            
            System.out.println("[ Mongo ] Documento inserido com sucesso.");
        } else {
            
            System.out.println("[ Mongo ] Houve um erro ao inserir o documento.");
        }
    }
    
    public void fecharConexao() {
        
        if(mongoClient != null) {
            System.out.println("[ Mongo ] Conexão com MongoDB finalizada.");
            mongoClient.close();
        
        } else {
            System.out.println("[ Mongo ] Não há conexão com MongoDB aberta neste momento.");
        }
    }
 }