package UI;

import Constants.UIConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class MainPanel extends JPanel {
    MainFrame mainframe;
    GridBagConstraints constraints = null;
    JButton botaoCadastrar;
    JPanel logotipoPanel;
    JPanel cadastroPainel;
    JLabel label;
    JLabel informacoesPessoaisLabel;
    JLabel nomeCompletoLabel;
    JLabel nrRGPessoalLabel;
    JLabel nrCPFPessoalLabel;
    JLabel nrRegistroEmpresaLabel;
    JLabel dtNascimentoLabel;
    JLabel informacoesLogin;
    JLabel nomeDeUsuarioLabel;
    JLabel senhaLabel;
    JLabel repetirSenhaLabel;
    JTextField nomeDeUsuarioTextField;
    JPasswordField senhaTextField;
    JPasswordField repetirSenhaTexteField;
    JTextField nomeCompletoLabelTextField;
    JFormattedTextField nrRGPessoalLabelTextField;
    JFormattedTextField nrCPFPessoalLabelTextField;
    JTextField nrRegistroEmpresaLabelTextField;
    JFormattedTextField dtNascimentoTextField;

    public MainFrame getMainframe() {
        return mainframe;
    }

    public void setMainframe(MainFrame mainframe) {
        this.mainframe = mainframe;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    public ImageIcon getImagemBotao() {
        return imagemBotao;
    }

    public void setImagemBotao(ImageIcon imagemBotao) {
        this.imagemBotao = imagemBotao;
    }

    ImageIcon imagemBotao;

    MainPanel(MainFrame mainFrame, GridBagLayout layoutManager){
        super(layoutManager);
        this.mainframe = mainFrame;
        constraints = new GridBagConstraints();
        setPreferredSize(new Dimension(UIConstants.MAIN_PANEL_LARGURA,UIConstants.MAIN_PANEL_ALTURA));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEtchedBorder());
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(UIConstants.LOGOTIPO_SISTEMA));
            imagemBotao = new ImageIcon(image);
        }catch(IOException e){ e.printStackTrace();}
        label = new JLabel(imagemBotao);
        this.add(label);

    }

    public void criarTelaCadastro(){
        remove(label);
        setConstraints(0,0);
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(UIConstants.LOGOTIPO_SISTEMA_MARCA_DAGUA));
            imagemBotao = new ImageIcon(image);
        }catch(IOException e){ e.printStackTrace();}
        label.setIcon(imagemBotao);
        add(label,constraints);
        cadastroPainel = new JPanel();
        cadastroPainel.setOpaque(true);
        cadastroPainel.setLayout(new GridBagLayout());
        cadastroPainel.setBackground(Color.WHITE);
        criarCamposCadastroPessoal();
        criarCamposCadastroLogin();
        criarBotaoCadastrar();
        setConstraints(0,0);
        add(cadastroPainel,constraints);
        revalidate();
        repaint();

    }

    public void criarBotaoCadastrar(){
        botaoCadastrar = new JButton("Cadastrar");
        setConstraints(4,6);
        constraints.anchor = GridBagConstraints.EAST;
        cadastroPainel.add(botaoCadastrar,constraints);
        constraints.anchor = GridBagConstraints.WEST;
    }

    public void criarCamposCadastroPessoal(){
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
        criarCadastroLabelsPessoal();
        criarCadastroTextFieldPessoal();
        adicionarCadastrolabelsPessoal();
        adicionarCadastroTextFieldsPessoal();
    }

    public void criarCamposCadastroLogin(){
        criarCadastroLabelsLogin();
        criarCadastroTextFieldLogin();
        adicionarCadastrolabelsLogin();
        adicionarCadastroTextFieldsLogin();
    }

    public void criarCadastroLabelsLogin(){
        informacoesLogin = new JLabel("Informações de Login: ");
        nomeDeUsuarioLabel = new JLabel("Nome de Usuario: ");
        senhaLabel = new JLabel("Senha: ");
        repetirSenhaLabel = new JLabel("Repita a Senha: ");

    }

    public void criarCadastroTextFieldLogin(){
        nomeDeUsuarioTextField = new JTextField();
        nomeDeUsuarioTextField.setPreferredSize(new Dimension(200,25));
        senhaTextField = new JPasswordField();
        senhaTextField.setPreferredSize(new Dimension(200,25));
        repetirSenhaTexteField = new JPasswordField();
        repetirSenhaTexteField.setPreferredSize(new Dimension(200,25));
    }

    public void adicionarCadastrolabelsLogin(){
        setConstraints(3,0);
        cadastroPainel.add(informacoesLogin,constraints);
        setConstraints(3,2);
        cadastroPainel.add(nomeDeUsuarioLabel,constraints);
        setConstraints(3,3);
        cadastroPainel.add(senhaLabel,constraints);
        setConstraints(3,4);
        cadastroPainel.add(repetirSenhaLabel,constraints);

    }

    public void adicionarCadastroTextFieldsLogin(){
        setConstraints(4,2);
        cadastroPainel.add(nomeDeUsuarioTextField,constraints);
        setConstraints(4,3);
        cadastroPainel.add(senhaTextField,constraints);
        setConstraints(4,4);
        cadastroPainel.add(repetirSenhaTexteField,constraints);
    }

    public void criarCadastroLabelsPessoal(){
        informacoesPessoaisLabel = new JLabel("Informações Pessoais: ");
        nomeCompletoLabel = new JLabel("Nome Completo: ");
        nrRGPessoalLabel = new JLabel("RG: ");
        nrCPFPessoalLabel = new JLabel("CPR: ");
        nrRegistroEmpresaLabel = new JLabel("Numero de Registo da Empresa");
        dtNascimentoLabel = new JLabel("Data de nascimento: ");
    }

    public void criarCadastroTextFieldPessoal(){
        nomeCompletoLabelTextField = new JTextField();
        nomeCompletoLabelTextField.setPreferredSize(new Dimension(200,25));
        nrRGPessoalLabelTextField = new JFormattedTextField(UIConstants.MASCARA_RG);
        nrRGPessoalLabelTextField.setPreferredSize(new Dimension(200,25));
        nrCPFPessoalLabelTextField = new JFormattedTextField(UIConstants.MASCARA_CPF);
        nrCPFPessoalLabelTextField.setPreferredSize(new Dimension(200,25));
        nrRegistroEmpresaLabelTextField = new JTextField();
        nrRegistroEmpresaLabelTextField.setPreferredSize(new Dimension(200,25));
        dtNascimentoTextField = new JFormattedTextField(UIConstants.MASCARA_DATA);
        dtNascimentoTextField.setPreferredSize(new Dimension(200,25));

    }

    public void adicionarCadastrolabelsPessoal(){
        setConstraints(0,0);
        cadastroPainel.add(informacoesPessoaisLabel,constraints);
        setConstraints(0,2);
        cadastroPainel.add(nomeCompletoLabel,constraints);
        setConstraints(0,3);
        cadastroPainel.add(nrRGPessoalLabel,constraints);
        setConstraints(0,4);
        cadastroPainel.add(nrCPFPessoalLabel,constraints);
        setConstraints(0,5);
        cadastroPainel.add(dtNascimentoLabel,constraints);
        setConstraints(0,6);
        cadastroPainel.add(nrRegistroEmpresaLabel,constraints);
    }

    public void adicionarCadastroTextFieldsPessoal(){
        setConstraints(1,2);
        cadastroPainel.add(nomeCompletoLabelTextField,constraints);
        setConstraints(1,3);
        cadastroPainel.add(nrRGPessoalLabelTextField,constraints);
        setConstraints(1,4);
        cadastroPainel.add(nrCPFPessoalLabelTextField,constraints);
        setConstraints(1,5);
        cadastroPainel.add(nrRegistroEmpresaLabelTextField,constraints);
        setConstraints(1,6);
        cadastroPainel.add(dtNascimentoTextField,constraints);
    }

    public void setConstraints(int x, int  y){
        constraints.gridx = x;
        constraints.gridy = y;
    }
}
