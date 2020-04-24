
package br.com.aplicacao.conexao;

import br.com.aplicacao.utilitarios.Funcoes;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class MySql {
  
    private static String USER;                                      //armazena usuário do banco
    private static String SENHA;                                     //armazena senha do banco
    private static String URL;                                       //armazena url de conexão
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //armazena driver de conexão

    private static String getPath(){
        //método que retorna arquivo de configuração
        try {
            return new File("").getCanonicalPath()+"\\aplicacao.properties"; //concatena o diretório raiz do projeto com o arquivo de configurações
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Connection getConnection (){
        //método que abre conexão com o banco
        Properties prop = Funcoes.getProp(getPath());
        //instancia o objeto properties
        URL = "jdbc:mysql://"+prop.getProperty("prop.host")+":"+prop.getProperty("prop.port")+"/"+prop.getProperty("prop.banco")+"?useTimezone=true&serverTimezone=UTC";
        //prop.getProperty retorna o valor da propriedade passada como parâmetro
        USER = prop.getProperty("prop.user");
        SENHA = prop.getProperty("prop.pass") + "SENHA_AQUI"; //concatena o valor da propriedade de senha com o restante da senha (para não expor a senha do banco completamente no arquivo de configurações)
     
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, SENHA);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados ");
            System.err.print(e.getStackTrace());
            return null;
        }
        
    }
    
    public static void closeConnection (Connection con){
        //fecha conexão
        try{
            if (con != null)
                con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados ");
            System.err.print(e.getStackTrace());
        }
        
    }
    
    
    public static void closeConnection (Connection con, PreparedStatement stmt){
        //fecha conexão e preparedStatement
        closeConnection(con);
        try{
            if (stmt != null)
                stmt.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados ");
            System.err.print(e.getStackTrace());
        }
        
    }
    
    
    public static void closeConnection (Connection con, PreparedStatement stmt, ResultSet rs){
        //fecha conexão, preparedStatement e resultSet
        closeConnection(con, stmt);
        try{
            if (rs != null)
                rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados ");
            System.err.print(e.getStackTrace());
        }
        
    }
    
}
