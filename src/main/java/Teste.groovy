import DAO.PesquisaDAO
import db.DB

import java.sql.Connection

class Teste {
    public static void main(String[] args) {

        PesquisaDAO pesquisa = new PesquisaDAO()
        Scanner scn = new Scanner(System.in);
        println "Digite o nome do Modelo: "
        String modelo = scn.nextLine()
        println "Digite o nome do Fabricante: "
        String fabricante = scn.nextLine()
        println "Digite o ano do Modelo: "
        String ano = scn.nextLine()

        String id =pesquisa.inserirDados(modelo,fabricante,ano)

        println "Id do cadastro = "+ id
    }
}
