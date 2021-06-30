package view;

import controller.BarangController;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class ViewMenu extends JFrame implements ActionListener{
    private JLabel lJudul;
    private JButton bTambah, bLihat;


public ViewMenu(){  
        setTitle("Menu");
        lJudul = new JLabel("Main Menu", SwingConstants.CENTER);
        bTambah = new JButton(" Tambah Data");
        bLihat = new JButton(" Lihat Data ");
        
        setLayout(new GridLayout(4,4));
        add(lJudul);
        add(bTambah);
        add(bLihat);
        
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        bTambah.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bLihat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        bTambah.addActionListener(this);  
        bLihat.addActionListener(this);  
        
    }
   
     public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == bTambah)
            {
                BarangController tambah = new BarangController();
                tambah.tambahBarang();
                dispose();
            }
            
            
            if(e.getSource() == bLihat)
            {
                BarangController barang = new BarangController();
                barang.lihatBarang();
                dispose();
            }
            
        }
}


