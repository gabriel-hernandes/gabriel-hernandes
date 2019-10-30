package UI;

import Constants.UIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RodapePanel extends JPanel {
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel getReleaseInformationbox() {
        return releaseInformationbox;
    }

    public void setReleaseInformationbox(JPanel releaseInformationbox) {
        this.releaseInformationbox = releaseInformationbox;
    }

    public JPanel getCadastroBox() {
        return cadastroBox;
    }

    public void setCadastroBox(JPanel cadastroBox) {
        this.cadastroBox = cadastroBox;
    }

    public JLabel getReleaseInformationLabel() {
        return releaseInformationLabel;
    }

    public void setReleaseInformationLabel(JLabel releaseInformationLabel) {
        this.releaseInformationLabel = releaseInformationLabel;
    }

    public JLabel getCadastroLabel() {
        return cadastroLabel;
    }

    public void setCadastroLabel(JLabel cadastroLabel) {
        this.cadastroLabel = cadastroLabel;
    }

    public JButton getCadastroButton() {
        return cadastroButton;
    }

    public void setCadastroButton(JButton cadastroButton) {
        this.cadastroButton = cadastroButton;
    }

    MainFrame mainFrame;
    JPanel releaseInformationbox;
    JPanel cadastroBox;
    JLabel releaseInformationLabel;
    JLabel cadastroLabel;
    JButton cadastroButton;

    RodapePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(UIConstants.RODAPE_PANEL_LARGURA,UIConstants.RODAPE_PANEL_ALTURA));
        createReleaseInformation();
        createCadastroBox();
        cadastroButtonAction();
    }

    void createReleaseInformation(){
        releaseInformationbox = new JPanel();
        releaseInformationbox.setPreferredSize(new Dimension(UIConstants.RELEASE_INFORMATION_LABEL_LARGURA,UIConstants.RELEASE_INFORMATION_LABEL_ALTURA));
        releaseInformationbox.setLayout(null);
        releaseInformationLabel = new JLabel();
        releaseInformationLabel.setText(UIConstants.VERSAO_SISTEMA_ATUAL);
        releaseInformationLabel.setBounds(10,8,300,20);
        releaseInformationbox.add(releaseInformationLabel);
        releaseInformationbox.setBounds(10, 0,300,35);
        add(releaseInformationbox, BorderLayout.WEST);
    }

    void createCadastroBox(){
        cadastroBox = new JPanel();
        cadastroBox.setLayout(new GridBagLayout());
        GridBagConstraints contraint = new GridBagConstraints();
        cadastroLabel = new JLabel();
        cadastroLabel.setText(UIConstants.MENSAGEM_POSSUI_CADASTRO);
        cadastroButton = new JButton(UIConstants.BOTAO_CADASTRAR);
        contraint.insets = new Insets(0,0,0,10);
        cadastroBox.add(cadastroLabel,contraint);
        cadastroBox.add(cadastroButton,contraint);
        add(cadastroBox, BorderLayout.EAST);
    }

    void cadastroButtonAction(){
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
    }

    void abrirTelaCadastro(){
        mainFrame.mainPanel.criarTelaCadastro();
        mainFrame.repaint();
    }
}
