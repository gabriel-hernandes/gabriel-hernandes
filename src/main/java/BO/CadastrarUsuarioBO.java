package BO;

import Constants.UIConstants;
import DAO.CadastrarUsuarioDAO;

import java.util.HashMap;

public class CadastrarUsuarioBO {

    public boolean cadastrarUsuario(HashMap<String, String> informacoes){
        boolean resultado = false;
        informacoes.put(UIConstants.MAPKEY_DIA, informacoes.get(UIConstants.MAPKEY_DATA).substring(0,2));
        informacoes.put(UIConstants.MAPKEY_MES, informacoes.get(UIConstants.MAPKEY_DATA).substring(2,4));
        informacoes.put(UIConstants.MAPKEY_ANO, informacoes.get(UIConstants.MAPKEY_DATA).substring(4,8));
        CadastrarUsuarioDAO cadastrarUsuarioDAO = new CadastrarUsuarioDAO();
        resultado = cadastrarUsuarioDAO.cadastrarUsuario(informacoes);
        return resultado;
    }
}
