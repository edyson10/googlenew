package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author edyson
 */
public class FormLugar extends JFrame implements ActionListener{
    
    public JPanel panelLugar; 
    public JComboBox cbxPais, cbxCiudad, cbxLugar;
    public JLabel lblPais, lblCiudad, lblLugar;
    public JButton cmdBuscar;
    
    public FormLugar(){
        
        setTitle("Google Maps");
        getContentPane().setBackground(Color.DARK_GRAY);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 1));
        
        panelLugar = new JPanel();
        cbxPais = new JComboBox();
        cbxCiudad = new JComboBox();
        cbxLugar = new JComboBox();
        lblPais = new JLabel("PAIS");
        lblCiudad = new JLabel("CIUDAD");
        lblLugar = new JLabel("LUGAR");
        cmdBuscar = new JButton();
        
        cmdBuscar.addActionListener(this);
        
        contentPane.add(panelLugar);
        
        Border bordeLugares = new TitledBorder(new EtchedBorder(), "Lugares");
        panelLugar.setBorder(bordeLugares);
        panelLugar.setLayout(new GridLayout(3,2));
        
        cbxPais.addItem("Colombia");
        
        cbxCiudad.addItem("Cucuta");
        cbxCiudad.addItem("Medellin");
        cbxCiudad.addItem("Barranquilla");
        cbxCiudad.addItem("Cali");
        cbxCiudad.addItem("Bogota");
        
        cbxLugar.addItem("Cafe");
        cbxLugar.addItem("University");
        cbxLugar.addItem("School");
        cbxLugar.addItem("Parque");
        cbxLugar.addItem("Hoteles");
        
        panelLugar.add(lblPais);
        panelLugar.add(lblCiudad);
        panelLugar.add(lblLugar);
        panelLugar.add(cbxCiudad);
        panelLugar.add(cbxPais);
        panelLugar.add(cbxLugar);
    }
    
    public static void main(String[] args) {
        FormLugar lugar = new FormLugar();
        lugar.setVisible(true);
        lugar.setBounds(5, 5, 250, 150);
        lugar.setResizable(false);
        lugar.setDefaultCloseOperation(FormLugar.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmdBuscar) {
            
        }
    }
    
}
