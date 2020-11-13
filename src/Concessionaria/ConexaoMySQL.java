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
    
    public static String URL = "jdbc:mysql://localhost:3306/poo2";
    
    public static void cadastrarCarro(String marca, String modelo, String cor, 
            String quantidadePortas, String versao, String tipo, String anoFabricacao,
            String placa, String valor) throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(URL,"root","");
            String query = "INSERT INTO lista_carros(marca, modelo, cor, quantidade_portas, versao, tipo, ano_fabricacao, placa, valor)"+
                                  "VALUES('{1}', '{2}', '{3}', {4}, '{5}', '{6}', {7}, '{8}', '{9}')";
            Statement comandoSql = (Statement) con.createStatement();

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
            
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }    
    }
}
