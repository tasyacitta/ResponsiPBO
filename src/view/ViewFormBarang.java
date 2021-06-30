package view;

import controller.BarangController;
import controller.MenuControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFormBarang extends JFrame implements ActionListener{
    JLabel lJudul = new JLabel("Input Barang");
    
    JLabel lNama = new JLabel("Nama");
    final JTextField fNama = new JTextField();
    
    JLabel lMassa = new JLabel("Massa (gr)");
    final JTextField fMassa = new JTextField();
    
    JLabel lHarga = new JLabel("Harga Satuan");
    final JTextField fHarga = new JTextField();
    
    JButton bSubmit = new JButton("Submit");
    JButton bReset = new JButton("Reset");
    JButton bBack = new JButton("Kembali");
    
public void form(){
        setTitle("Input Barang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,250);
        
        
        
        setLayout(null);
        add(lJudul);
        add(lNama);
        add(lMassa);
        add(lHarga);
        add(fNama);
        add(fMassa);
        add(fHarga);
        add(bBack);
        add(bSubmit);
        add(bReset);
        
        
        lJudul.setBounds(10,10,120,20);
        lNama.setBounds(10, 40, 120, 20);
        fNama.setBounds(130, 40, 200, 20);
        lMassa.setBounds(10, 80, 120, 20);
        fMassa.setBounds(130, 80, 200, 20);
        lHarga.setBounds(10, 120, 120, 20);
        fHarga.setBounds(130, 120, 200, 20);
        bBack.setBounds(10,180,320,20);
        bReset.setBounds(200,150,120,20);
        bSubmit.setBounds(75,150,120,20);
        
        bSubmit.setBackground(Color.blue);
        bSubmit.setForeground(Color.white);
        bReset.setBackground(Color.red);
        bReset.setForeground(Color.white);
        
        bBack.addActionListener(this);
        bSubmit.addActionListener(this);
        bReset.addActionListener(this);
        
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bSubmit) {
            if (fNama.getText().trim().equals("")) {
                setMessage("Nama harus diisi");
            }
            else if (fMassa.getText().trim().equals("")) {
                setMessage("Massa harus diisi");
            }
            else if (fHarga.getText().trim().equals("")) {
                setMessage("Harga harus diisi");
            }
            else if (Integer.valueOf(fMassa.getText())<0 ) {
                setMessage("Massa harus positif");
            }
            else if (Integer.valueOf(fHarga.getText())<0) {
                setMessage("Harga harus positif");
            }
            else {
                String[] data = {
                        fNama.getText(), fMassa.getText(), fHarga.getText()
                };
                BarangController barang = new BarangController();
                barang.tambahBarang(data);
              
            }
        }
        else if(e.getSource()==bReset){
            reset();
        }
        else if(e.getSource()==bBack){
           dispose();
            MenuControl menu = new MenuControl();
            menu.openMenu();
            dispose();
        }
    }

    public void reset(){
        fNama.setText("");
        fMassa.setText("");
        fHarga.setText("");
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

}

