/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TCadastro extends JFrame{
    
    private String useDB;
    
    private JLabel lblModelo;
    private JTextField txtModelo;
    private JLabel lblMarca;
    private JTextField txtMarca;
    private JLabel lblCor;
    private JTextField txtCor;
    private JLabel lblQtdPortas;
    private JTextField txtQtdPortas;
    
    private JLabel lblVersao;
    private JComboBox cmbVersao;
    private JLabel lblTipo;
    private JComboBox cmbTipo;
    
    private JLabel lblAnoFabricacao;
    private JFormattedTextField txtAnoFabricacao;
    private JLabel lblPlaca;
    private JFormattedTextField txtPlaca;
    private JLabel lblValor;
    private JFormattedTextField txtValor;
    
    private JButton btnEnviar;

    public TCadastro(String useDB){
        
        this.useDB = useDB;
        
        setTitle("Tela Inicial");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        lblModelo = new JLabel("Modelo");
        txtModelo = new JTextField();
        
        lblMarca = new JLabel("Marca");
        txtMarca = new JTextField();
        
        lblCor = new JLabel("Cor");
        txtCor = new JTextField();
        
        lblQtdPortas = new JLabel("Quantidade de portas");
        txtQtdPortas = new JTextField();
        
        lblAnoFabricacao = new JLabel("Ano de Fabricação");
        try {
            txtAnoFabricacao = new JFormattedTextField(new MaskFormatter("####"));
        } catch (ParseException ex) {
            Logger.getLogger(TCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        lblPlaca = new JLabel("Placa");
        try {
            txtPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
        } catch (ParseException ex) {
            Logger.getLogger(TCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lblValor = new JLabel("Valor");
        try {
            txtValor = new JFormattedTextField(new MaskFormatter("R$###.###,##"));
        } catch (ParseException ex) {
            Logger.getLogger(TCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lblVersao = new JLabel("Versão");
        String[] versoes = {"Básico", "Completo"};
        cmbVersao = new JComboBox(versoes);
          
        lblTipo = new JLabel("Tipo");
        String[] tipos = {"Cupê", "Crossover", "Esportivo", "Hatch e Hatchback", "Jipe", "Picape", "Sedan", "SUV", "Van e Minivan"};
        cmbTipo = new JComboBox(tipos);
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraCarro();
            }
        });
        
        lblMarca.setBounds(0, 0, 100, 25);
        txtMarca.setBounds(150, 0, 100, 25);
        
        lblModelo.setBounds(0, 30, 100, 25);
        txtModelo.setBounds(150, 30, 100, 25);
        
        lblCor.setBounds(0, 60, 100, 25);
        txtCor.setBounds(150, 60, 100, 25);
        
        lblQtdPortas.setBounds(0, 90, 200, 25);
        txtQtdPortas.setBounds(150, 90, 100, 25);
           
        lblVersao.setBounds(0, 120, 100, 25);
        cmbVersao.setBounds(150, 120, 100, 25);
        
        lblTipo.setBounds(0, 150, 100, 25);
        cmbTipo.setBounds(150, 150, 100, 25);

        lblAnoFabricacao.setBounds(0, 180, 200, 25);
        txtAnoFabricacao.setBounds(150, 180, 100, 25);
        
        lblPlaca.setBounds(0, 210, 100, 25);
        txtPlaca.setBounds(150, 210, 100, 25);
        
        lblValor.setBounds(0, 240, 100, 25);
        txtValor.setBounds(150, 240, 100, 25);
        
        btnEnviar.setBounds(75, 300, 100, 25);
        
        getContentPane().add(lblMarca);
        getContentPane().add(txtMarca);
        getContentPane().add(lblModelo);
        getContentPane().add(txtModelo);
        getContentPane().add(lblCor);
        getContentPane().add(txtCor);
        getContentPane().add(lblQtdPortas);
        getContentPane().add(txtQtdPortas);
        
        getContentPane().add(lblVersao);
        getContentPane().add(cmbVersao);
        getContentPane().add(lblTipo);
        getContentPane().add(cmbTipo);
        
        getContentPane().add(lblAnoFabricacao);
        getContentPane().add(txtAnoFabricacao);
        getContentPane().add(lblPlaca);
        getContentPane().add(txtPlaca);
        getContentPane().add(lblValor);
        getContentPane().add(txtValor);
        
        getContentPane().add(btnEnviar);
        
        
        setVisible(true);
    }
    
    private void cadastraCarro(){
        
        String modelo = txtModelo.getText();
        String marca = txtMarca.getText();
        String cor = txtCor.getText();
        String qtdPortas = txtQtdPortas.getText();
        String versao = (String)cmbVersao.getSelectedItem();
        String tipo = (String)cmbTipo.getSelectedItem();
        
        String anoFabricacao = txtAnoFabricacao.getText();
        String placa = txtPlaca.getText();
        String valor = txtValor.getText().replace("R$", "").replace(".", "").replace(",", ".");
        
        CarroObject carro = new CarroObject(marca, modelo, cor, qtdPortas, versao, tipo, anoFabricacao, placa, valor);
        carro.registrarCarro(useDB);
        System.out.println("---------------------------\n\n");

        txtModelo.setText("");
        txtMarca.setText("");
        txtCor.setText("");
        txtQtdPortas.setText("");
        cmbVersao.setSelectedIndex(0);
        cmbTipo.setSelectedItem(0);
        
        txtAnoFabricacao.setText("");
        txtPlaca.setText("");
        txtValor.setText("");
        
    }
}