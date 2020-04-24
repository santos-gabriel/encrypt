
package br.com.aplicacao.controler;

import br.com.aplicacao.model.bean.UsuarioBean;
import br.com.aplicacao.model.dao.UsuarioDao;

/**
 *
 * @author Gabriel
 */
public class CtrlUsuario {
  
    
    public static void salvarUser (UsuarioBean u){
        new UsuarioDao().SalvarUf(u);
    }
    
    public static boolean loginUser (UsuarioBean u){
        
        try {
            return new UsuarioDao().logarUser(u);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
        
    }
    
}
