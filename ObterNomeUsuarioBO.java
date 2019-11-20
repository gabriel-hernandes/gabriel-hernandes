package BO;

import DAO.ObterNomeUsuarioDAO;

 /**Classe para objetos do tipo string, onde serão contidos, as informações referentes ao nome do usuario
*/

public class ObterNomeUsuarioBO {

    public String obterNomeUsuario(String usuario){
        String nome;
        String[] nomeCompleto;
        ObterNomeUsuarioDAO obterNomeUsuarioDAO = new ObterNomeUsuarioDAO();
        nomeCompleto = obterNomeUsuarioDAO.obterNomeUsuario(usuario).split(" ");
        nome = nomeCompleto[0];
        return nome;
    }
}
