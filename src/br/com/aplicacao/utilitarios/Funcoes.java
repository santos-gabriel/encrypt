
package br.com.aplicacao.utilitarios;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Properties;

/**
 *
 * @author Gabriel
 */
public class Funcoes {

    public static String getEncript(String senha){
        //método para encriptar string
        try{
            //hash armazena senha encriptada com instancia MD5
            BigInteger hash = new BigInteger (1, MessageDigest.getInstance("MD5").digest(senha.getBytes()));
            return hash.toString(16); //retorna senha encriptada
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static Properties getProp(String path){
        //método para pegar os valores do arquivo de configurações
        Properties props = new Properties();
        //instancia um objeto properties
        try {
            props.load(new FileInputStream(path)); //lê o arquivo de configurações
            return props;                          //retorna as propriedades do arquivo de configurações
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
