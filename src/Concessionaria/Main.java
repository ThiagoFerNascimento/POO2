
package Concessionaria;

import java.sql.SQLException;

public class Main extends ConexaoMySQL {
    public static void main(String []args) throws SQLException {
        //TCadastro tCadastro = new TCadastro();
        
        ConexaoMongoDB mongo = new ConexaoMongoDB();
        mongo.conectar();
        
    }
}
