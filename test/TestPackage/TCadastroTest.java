package TestPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Concessionaria.Main;
import Concessionaria.TCadastro;
import java.sql.SQLException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tfn-3
 */
public class TCadastroTest {
    
    private static String[] args;
    
    //public TCadastroTest() {
    //}
    
    @BeforeClass
    public static void setUpClass() {
     
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void ControleSucesso() {
        
        Assert.assertEquals("Valid", "Valid");
    }
    
    @Test
    public void ControleErro() {
        
        Assert.assertEquals("Valid", "Invalid");
    }
    
}
