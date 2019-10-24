package UI

import Constants.UIConstants

import javax.swing.JButton
import javax.swing.JPanel
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.GridLayout

class HeaderPanel extends JPanel{

    GridBagConstraints constraints = null

    HeaderPanel(GridBagLayout layoutManager){
        super(layoutManager)
        constraints = new GridBagConstraints()
        setPreferredSize(new Dimension(UIConstants.HEADER_PANEL_LARGURA,UIConstants.HEADER_PANEL_ALTURA))
        JButton bt = new JButton("CABECA")
        constraints.gridx = 0
        constraints.gridy = 0
        add(bt,constraints)

    }
}
