
package br.com.aplicacao.model.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import br.com.aplicacao.model.bean.UsuarioBean;
import br.com.aplicacao.conexao.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class UsuarioDao {

    private Connection conexao = null;
   
    public UsuarioDao (){
        conexao = MySql.getConnection();  
    }
    
    public void SalvarUf(UsuarioBean user) {
        
        String sql = "INSERT INTO usuarios(login, senha) VALUES (?, ?);";
        PreparedStatement stmt = null;
        
        try {
            
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso ");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar ");
            e.printStackTrace();
        } finally {
            MySql.closeConnection(conexao, stmt);
        }
        
    }
    
    
    public boolean logarUser(UsuarioBean pUser) throws SQLException {
        
        String sql = "SELECT U.* "
                   + "FROM   USUARIOS U "
                   + "WHERE  UPPER(U.LOGIN) = UPPER(?) "
                   + "AND    UPPER(U.SENHA) = UPPER(?);";
        
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
            
            stmt.setString(1, pUser.getLogin());
            stmt.setString(2, pUser.getSenha());
            
            rs = stmt.executeQuery();

            if (rs.next())  
                return true;
            else
                return false;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            MySql.closeConnection(conexao, stmt, rs);
        }
    }


}
