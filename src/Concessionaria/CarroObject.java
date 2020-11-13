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
    
    public String registrarCarro() {
        
        String status = "";
        
        try {
            
            Connection conexaoMySQL = ConexaoMySQL.conectarMySQL();
            System.out.println(conexaoMySQL);
            
            
            ConexaoMySQL.cadastrarCarro(this.marca, this.modelo, this.cor, 
            this.quantidadePortas, this.versao, this.tipo, this.anoFabricacao,
            this.placa, this.valor);
            
            status = "Registrado com sucesso";
            
        } catch(SQLException e) {
            
            status = "Falha no registro";            
        }
        
        return status;
    }
}   