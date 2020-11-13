
package Concessionaria;

import java.sql.SQLException;

public class Main extends ConexaoMySQL {
    public static void main(String []args) throws SQLException {
        new TCadastro();
    }
}
