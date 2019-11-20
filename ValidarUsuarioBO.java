package BO;

import Constants.UIConstants;
import DAO.ValidarUsuarioDAO;

import java.util.Map;

 /** A função da classe é checar se o usuario e senha são validos para liberar o login do usuario
*/

public class ValidarUsuarioBO {

    boolean validado;

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

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
