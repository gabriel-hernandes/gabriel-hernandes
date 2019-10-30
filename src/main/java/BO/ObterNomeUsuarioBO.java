package BO;

import DAO.ObterNomeUsuarioDAO;

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
