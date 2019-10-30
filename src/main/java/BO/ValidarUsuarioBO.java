package BO;

import Constants.UIConstants;
import DAO.ValidarUsuarioDAO;

import java.util.Map;

public class ValidarUsuarioBO {

    boolean validado;

    public String validarUsuario(String usuario, String senha){
        validado = false;
        String mensagem;
        ValidarUsuarioDAO validaDAO = new ValidarUsuarioDAO();
        Map<String,String> resutadoQuery = validaDAO.validarUsuario(usuario);
        if(resutadoQuery.get(UIConstants.USUARIO_MAP_KEY) == null){
            validado = false;
            mensagem = UIConstants.AVISO_USUARIO_NAO_ENCONTRADO;
        }else if(resutadoQuery.get(UIConstants.SENHA_MAP_KEY).equalsIgnoreCase(senha)){
            validado = true;
            mensagem = UIConstants.AVISO_LOGIN_EFETUADO_COM_SUCESSO;
        }else{
            validado = false;
            mensagem =UIConstants.AVISO_SENHA_INVALIDA;
        }
        return mensagem;
    }
}
