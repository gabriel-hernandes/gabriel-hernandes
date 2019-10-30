package BO;

import DAO.CadastrarUsuarioDAO;

import java.util.HashMap;

public class CadastrarUsuarioBO {

    public boolean cadastrarUsuario(HashMap<String, String> informacoes){
        boolean resultado = false;
        informacoes.put("Dia", informacoes.get("Data").substring(0,2));
        informacoes.put("Mes", informacoes.get("Data").substring(2,4));
        informacoes.put("Ano", informacoes.get("Data").substring(4,8));
        CadastrarUsuarioDAO cadastrarUsuarioDAO = new CadastrarUsuarioDAO();
        resultado = cadastrarUsuarioDAO.cadastrarUsuario(informacoes);
        return resultado;
    }
}
