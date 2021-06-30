package view;

import controller.BarangController;
import controller.MenuControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewDetail extends JFrame implements ActionListener {    
    JLabel lNama = new JLabel("Nama");    
    JLabel lMassa = new JLabel("Massa (gr)");    
    JLabel lHarga = new JLabel("Harga Satuan");
    JLabel lBanyak = new JLabel("Banyaknya");
    JTextField fBanyak = new JTextField();
    
    
    JLabel dNama, dMassa, dHarga;
    
    JButton bUpdate = new JButton("Update");
    JButton bDelete = new JButton("Delete");
    JButton bTotal =new JButton("Total");
    JButton bBack = new JButton("Kembali");
    private String id;
    
    public void openDetail(String[] data){
        this.id=data[0];
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        
        dNama = new JLabel(data[1]);
        dMassa = new JLabel(data[2]);
        dHarga = new JLabel(data[3]);     
        
        setLayout(null);
        
        add(lNama);
        add(lMassa);
        add(lHarga);
        add(dNama);
        add(dMassa);
        add(dHarga);
        add(lBanyak);
        add(fBanyak);
        add(bBack);
        add(bUpdate);
        add(bDelete);
        add(bTotal);
        
        
        lNama.setBounds(10, 10, 120, 20);
        dNama.setBounds(130, 10, 200, 20);
        lMassa.setBounds(10, 40, 120, 20);
        dMassa.setBounds(130, 40, 200, 20);
        lHarga.setBounds(10, 70, 120, 20);
        dHarga.setBounds(130, 70, 200, 20);
        lBanyak.setBounds(10, 100, 120, 20);
        fBanyak.setBounds(130, 100, 120, 20);
        bBack.setBounds(10,180,90,20);
        bDelete.setBounds(120,180,90,20);
        bUpdate.setBounds(240,180,90,20);
        bTotal.setBounds(70,140,200,20);
        
        bUpdate.setBackground(Color.blue);
        bUpdate.setForeground(Color.white);
        bDelete.setBackground(Color.red);
        bDelete.setForeground(Color.white);
        
        bBack.addActionListener(this);
        bTotal.addActionListener(this);
        bUpdate.addActionListener(this);
        bDelete.addActionListener(this);
        
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bTotal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==bUpdate){
            
            BarangController barang = new BarangController();
            barang.updateBarang(id);
            dispose();
        }
        if(e.getSource()==bDelete){
             BarangController del = new BarangController();
             del.delete(id);
            dispose();
        }
        if(e.getSource()==bTotal){
            BarangController tot = new BarangController();
            String[] data = {
                dNama.getText(), dMassa.getText(), dHarga.getText(), fBanyak.getText()
                };
            tot.totalBarang(id);
            dispose();
        }
        else if(e.getSource()==bBack){
            
            BarangController barang = new BarangController();
            barang.lihatBarang();
            dispose();
            
        }
        
    }
}
