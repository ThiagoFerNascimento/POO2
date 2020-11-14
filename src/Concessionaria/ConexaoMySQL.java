/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concessionaria;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;


public class ConexaoMySQL {
    
    public String URL = "jdbc:mysql://localhost:3306/poo2";
    private Connection mySql;
    
    public void conectar() throws SQLException {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            if(mySql == null) {
                
                mySql = (Connection) DriverManager.getConnection(URL,"root","");
                System.out.println("[ MySQL ] Uma nova conexão com o MySQL foi criada.");
            
            } else {
                
                 System.out.println("[ MySQL ] Conexao com o MySQL já existente, nova instância não foi criada.");
            }
        
        } catch(ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cadastrarCarro(String marca, String modelo, String cor, 
            String quantidadePortas, String versao, String tipo, String anoFabricacao,
            String placa, String valor) throws SQLException {
       
        if(mySql != null) {
            
            String query = "INSERT INTO lista_carros(marca, modelo, cor, quantidade_portas, versao, tipo, ano_fabricacao, placa, valor)"+
                              "VALUES('{1}', '{2}', '{3}', {4}, '{5}', '{6}', {7}, '{8}', '{9}')";
            Statement comandoSql = (Statement) mySql.createStatement();

            query = query.replace("{1}", marca)
                         .replace("{2}", modelo)
                         .replace("{3}", cor)
                         .replace("{4}", quantidadePortas)
                         .replace("{5}", versao)
                         .replace("{6}", tipo)
                         .replace("{7}", anoFabricacao)
                         .replace("{8}", placa)
                         .replace("{9}", valor);

            comandoSql.execute(query);
            
            System.out.println("[ MySQL ] Documento inserido com sucesso.");
        } else {
        
            System.out.println("[ MySQL ] Houve um erro ao inserir os dados.");
        }
    }
    
    public void fecharConexao() throws SQLException {
            
        
        if(mySql != null) {
            
            mySql.close();
            mySql = null;
            System.out.println("[ MySQL ] Conexão com MySQL finalizada.");
            
        } else {
            
            System.out.println("[ MySQL ] Não há uma conexão com o MySQL aberta neste momento.");
        }
    }
}
