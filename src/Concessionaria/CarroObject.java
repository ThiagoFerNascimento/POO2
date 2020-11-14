/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concessionaria;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;

/**
 *
 * @author tfn-3
 */
public class CarroObject {
    
    private String modelo;
    private String marca;
    private String cor;
    private String quantidadePortas;
    private String versao;
    private String tipo;
    private String anoFabricacao;
    private String placa;
    private String valor;
    
    public CarroObject(String marca, String modelo, String cor, 
            String quantidadePortas, String versao, String tipo, String anoFabricacao,
            String placa, String valor) {
        
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.quantidadePortas = quantidadePortas;
        this.versao = versao;
        this.tipo = tipo;
        this.anoFabricacao = anoFabricacao;
        this.placa = placa;
        this.valor = valor;
    }
    
    public void registrarCarro(String useDB) {
        
        switch(useDB) {
        
            case "MongoDB" : 
                this.cadastrarCarroNoMongoDB(this.marca, this.modelo, this.cor, 
                this.quantidadePortas, this.versao, this.tipo, this.anoFabricacao,
                this.placa, this.valor);
                break;
            
            case "MySQL" :
                this.cadastrarCarroNoMySQL(this.marca, this.modelo, this.cor, 
                this.quantidadePortas, this.versao, this.tipo, this.anoFabricacao,
                this.placa, this.valor);
                break;
            
            default : 
                useDB = useDB == null ? "Nome DB não fornecido." : useDB;
                
                System.out.println("[ Java ] O banco de dados ("+useDB+") não existente. Por favor, Escolha entre [\"MongoDB\" ou \"MySQL\"] na classe Main.java.");
                break;
        }
    }
    
    private void cadastrarCarroNoMySQL(String marca, String modelo, String cor, 
            String quantidadePortas, String versao, String tipo, String anoFabricacao,
            String placa, String valor) {

        try {

            ConexaoMySQL mySql = new ConexaoMySQL();
            mySql.conectar();
            
            mySql.cadastrarCarro(this.marca, this.modelo, this.cor, 
            this.quantidadePortas, this.versao, this.tipo, this.anoFabricacao,
            this.placa, this.valor);
            
            mySql.fecharConexao();

        } catch(SQLException e) {
            
            System.out.println("[ MySQL ] Erro ao tentar cadastrar o documento.");
        }
    }
    
    private void cadastrarCarroNoMongoDB(String marca, String modelo, String cor, 
            String quantidadePortas, String versao, String tipo, String anoFabricacao,
            String placa, String valor) {
        
        ConexaoMongoDB mongo = new ConexaoMongoDB();
        mongo.conectar();
        
        mongo.cadastrarCarro(this.marca, this.modelo, this.cor,
            this.quantidadePortas, this.versao, this.tipo, this.anoFabricacao,
            this.placa, this.valor);
        
        mongo.fecharConexao();
    }
} 