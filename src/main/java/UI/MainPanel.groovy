package UI

import Constants.UIConstants

import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JPanel
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout

class MainPanel extends JPanel{

    GridBagConstraints constraints = null
    JButton bt1,bt2,bt3

    MainPanel(GridBagLayout layoutManager){
        super(layoutManager)
        constraints = new GridBagConstraints()
        setPreferredSize(new Dimension(UIConstants.MAIN_PANEL_LARGURA,UIConstants.MAIN_PANEL_ALTURA))
        setBorder(BorderFactory.createEtchedBorder())
        bt1 = new JButton("TESTE1")
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(bt1, constraints)
        bt2 = new JButton("TESTE2")
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(bt2, constraints)
        bt3 = new JButton("TESTE3")
        constraints.gridx = 2;
        constraints.gridy = 0;
        this.add(bt3, constraints)

    }
}
