package Constants;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class UIConstants {
    //Constantes utilizadas no User Inteface

    //Mensagem do Titulo
    public static final String TITULO_SISTEMA_DE_CONTROLE = "Sistema de Controle de Frotas";
    public static final String LOGOTIPO_SISTEMA = "img\\logotipo\\RageLogo.png";
    public static final String LOGOTIPO_SISTEMA_MARCA_DAGUA = "img\\logotipo\\RageLogoTransparente.png";
    public static final String LOGOTIPO_SISTEMA_ICONE = "img\\logotipo\\RageIcon.png";
    //Menu Principal
    public static final String BOTAO_CADASTRAR_MOTORISTA = "img\\logotipo\\cadastrarMotorista.png";
    public static final String BOTAO_CADASTRAR_VEICULO = "img\\logotipo\\cadastrarVeiculo.png";

    //Constantes de dimensão
    public static final int FRAME_ALTURA = 600;
    public static final int FRAME_LARGURA = 900;

    //Main Panel Constants
    public static final int MAIN_PANEL_ALTURA = 530;
    public static final int MAIN_PANEL_LARGURA = 900;

    public static final String MASCARA_RG_STRING = "##.###.###-##";
    public static final String MASCARA_CPF_STRING = "##/##/####";
    public final static String MASCARA_DATA_STRING = "###.###.###-##";



    //Header constants
    public static final int HEADER_PANEL_ALTURA = 35;
    public static final int HEADER_PANEL_LARGURA = 900;
    public static final int INFORMATIONBOX_PANEL_ALTURA = 40;
    public static final int INFORMATIONBOX_PANEL_LARGURA = 300;
    public static final int CADASTROBOX_PANEL_ALTURA = 40;
    public static final int CADASTROBOX_PANEL_LARGURA = 100;
    public static final int LOGINBOX_PANEL_ALTURA = 40;
    public static final int LOGINBOX_PANEL_LARGURA = 300;
    public static final String MENSAGEM_SOLICITANDO_LOGIN = "SCF - Favor efetuar login para iniciar o sistema";

    //Constantes de Login
    public static final String DEFFAULT_USUARIO_TEXTBOX = "Usuario";
    public static final String DEFFAULT_SENHA_TEXTBOX = "Senha";
    public static final String BOTAO_LOGIN_TEXT = "Login";
    public static final String POPUP_FRAME_TITULO = "AVISO!";
    public static final String POPUP_PANEL_TITULO = "Login";
    public static final String AVISO_USUARIO_NAO_INFORMADO = "Favor Informar usuario!";
    public static final String AVISO_SENHA_NAO_INFORMADO = "Favor Informar Senha!";
    public static final String AVISO_USUARIO_NAO_ENCONTRADO = "Usuario não Encontrado!";
    public static final String AVISO_LOGIN_EFETUADO_COM_SUCESSO = "Login Efetuado com sucesso!";
    public static final String AVISO_SENHA_INVALIDA = "Senha não corresponde ao usuario!";
    public static final String USUARIO_MAP_KEY = "USUARIO";
    public static final String SENHA_MAP_KEY = "SENHA";
    public static final String NOME_USUARIO_LABEL = "Bem vindo ";

    //Rodape constants
    public static final int RODAPE_PANEL_ALTURA = 35;
    public static final int RODAPE_PANEL_LARGURA = 900;
    public static final int RODAPE_PANEL_LINHAS = 1;
    public static final int RODAPE_PANEL_COLUNAS = 18;

    //Cadastro Constants
    public static final String AVISO_POPUP_CADASTRO = "Cadastro";
    public static final String MENSAGEM_POSSUI_CADASTRO = "Não possui cadastro?";
    public static final String BOTAO_CADASTRAR = "Cadastrar";
    public static final String MAPKEY_NOME = "Nome";
    public static final String MAPKEY_RG = "RG";
    public static final String MAPKEY_CPF = "CPF";
    public static final String MAPKEY_REGISTRO = "Registro";
    public static final String MAPKEY_DATA = "Data";
    public static final String MAPKEY_USUARIO = "Usuario";
    public static final String MAPKEY_SENHA = "Senha";
    public static final String MAPKEY_SENHA_REPETIDA = "SenhaRepetida";
    public static final String MAPKEY_DIA = "Dia";
    public static final String MAPKEY_MES = "Mes";
    public static final String MAPKEY_ANO = "Ano";

    public static final String AVISO_CAMPO_NOME_NULO = "Favor informar Nome Completo";
    public static final String AVISO_CAMPO_RG_NULO = "Favor informar numero de RG";
    public static final String AVISO_CAMPO_CPF_NULO = "Favor informar numero de CPF";
    public static final String AVISO_CAMPO_DATA_NULO ="Favor informar Data de nascimento";
    public static final String AVISO_CAMPO_REGISTRO_NULO = "Favor informar numero de registro";
    public static final String AVISO_CAMPO_USUARIO_NULO = "Favor informar um nome de usuario";
    public static final String AVISO_CAMPO_SENHA_NULO = "Favor informar uma senha";
    public static final String AVISO_CAMPO_SENHA_REPETIDA_INVALIDA = "As senhas não são iguais";

    public static final String AVISO_USUARIO_CADASTRADO_SUCESSO = "Usuadio cadastrado com Sucesso!";
    public static final String AVISO_ERRO_AO_CADASTRAR_USUARIO = "Ocorreu um erro ao tentar cadastrar o Usuario";
    public static final String AVIS_FALHA_CADASTRO_NO_BANCO_DE_DADOS = "Falha ao cadastrar usuario no banco de dados causado por: ";

    public static final String LABEL_INFORMACOES_LOGIN = "Informações de Login: ";
    public static final String LABEL_USUARIO_CADASTRO = "Nome de Usuario: ";
    public static final String LABEL_SENHA_CADASTRO = "Senha: ";
    public static final String LABEL_REPITA_SENHA_CADASTRO = "Repita a Senha: ";

    public static final String LABEL_INFORMACOES_PESSOAIS = "Informações Pessoais: ";
    public static final String LABEL_INFORMACOES_NOME = "Nome Completo: ";
    public static final String LABEL_INFORMACOES_RG = "RG: ";
    public static final String LABEL_INFORMACOES_CPF = "CPF: ";
    public static final String LABEL_INFORMACOES_REGISTRO = "Numero de Registo da Empresa";
    public static final String LABEL_INFORMACOES_DATA = "Data de nascimento: ";

    //Release information box
    public static final int RELEASE_INFORMATION_LABEL_ALTURA = 35;
    public static final int RELEASE_INFORMATION_LABEL_LARGURA = 300;
    public static final String VERSAO_SISTEMA_ATUAL = "Release Alpha 0.0.1 - 30/10/2019";

}
