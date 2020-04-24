
package br.com.aplicacao.model.bean;

import br.com.aplicacao.utilitarios.Funcoes;

/**
 *
 * @author Gabriel
 */
public class UsuarioBean {

    private int codigo;     //armazena código do usuário
    private String login;   //armazena login  do usuário
    private String senha;   //armazena senha  do usuário

    public UsuarioBean() {
    }

    public UsuarioBean(int codigo, String login, String senha) {
        setCodigo(codigo);
        setLogin(login);
        setSenha(senha);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = Funcoes.getEncript(senha); //encripta senha
    }
    
    
}
