package BO

import DAO.ValidarUsuarioDAO

class ValidarUsuarioBO {

    boolean validado = null

    String validarUsuario(String usuario, String senha){
        validado = false
        String mensagem = null
        Map<String,String> resutadoQuery = new HashMap<>()
        ValidarUsuarioDAO validaDAO = new ValidarUsuarioDAO()
        resutadoQuery = validaDAO.validarUsuario(usuario)
        if(resutadoQuery.get(usuario) == null){
            validado = false
            mensagem = "Usuario não Encontrado!"
        }else if(resutadoQuery.get(usuario).equalsIgnoreCase(senha)){
            validado = true
            println "Senha igual verificada!"
            mensagem = "Login Efetuado com sucesso!"
        }else{
            validado = false
            println "Senha negada!"
            mensagem ="Senha não corresponde ao usuario!"
        }
        return mensagem
    }
}
