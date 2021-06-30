package view;

import controller.BarangController;
import controller.MenuControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class ViewTotal extends JFrame implements ActionListener {    
    JLabel lNama = new JLabel("Nama");    
    JLabel lMassa = new JLabel("Massa (gr)");    
    JLabel lHarga = new JLabel("Harga Satuan");
    JLabel lBanyak = new JLabel("Harga Satuan");

    
    
    JLabel dNama, dMassa, dHarga,dBanyak;
    
    JButton bUpdate = new JButton("Update");
    JButton bDelete = new JButton("Delete");
    JButton bBack = new JButton("Kembali");
    private String id;
    
    public void openTotal(String[] data){
        this.id=data[0];
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        
        dNama = new JLabel(data[1]);
        dMassa = new JLabel(data[2]);
        dHarga = new JLabel(data[3]);     
        dBanyak = new JLabel(data[4]);  
        
        setLayout(null);
        
        add(lNama);
        add(lMassa);
        add(lHarga);
        add(dNama);
        add(dMassa);
        add(dHarga);
        add(lBanyak);
        add(dBanyak);
        add(bBack);
        
        
        lNama.setBounds(10, 10, 120, 20);
        dNama.setBounds(130, 10, 200, 20);
        lMassa.setBounds(10, 40, 120, 20);
        dMassa.setBounds(130, 40, 200, 20);
        lHarga.setBounds(10, 70, 120, 20);
        dHarga.setBounds(130, 70, 200, 20);
        lBanyak.setBounds(10, 100, 120, 20);
        dBanyak.setBounds(130, 100, 120, 20);
        bBack.setBounds(10,180,90,20);
        
          
        bBack.addActionListener(this);
        
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
        
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){

        if (e.getSource()==bBack){
            BarangController barang = new BarangController();
            barang.lihatBarang();
            dispose();
        }
        else{
        JOptionPane.showMessageDialog(null, "ERROR");

        }
        
    }
}
