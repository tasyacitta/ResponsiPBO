package view;

import controller.BarangController;
import controller.MenuControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateFormBarang extends JFrame implements ActionListener{
    private JTextField fNama,fMassa,fHarga; //Enkapsulasi
    private JLabel lJudul,lNama,lMassa,lHarga;    
    JButton bSubmit = new JButton("Submit");
    JButton bReset = new JButton("Reset");
    JButton bBack = new JButton("Kembali");
     private String id, kode;
    
    public void openForm(String[] data){
        id = data[0];
        setTitle("Edit Data Barang");
        
        setSize(350,250);

        fNama = new JTextField(data[1],10);
        fMassa = new JTextField(data[2],10);
        fHarga = new JTextField(data[3], 10);
        lJudul = new JLabel("Edit Data Barang", SwingConstants.CENTER);
        lNama = new JLabel("Nama");
        lMassa = new JLabel("Massa (gr)");
        lHarga = new JLabel("Harga Satuan");
       

        setLayout(null);
        add(lJudul);
        add(lNama);
        add(lMassa);
        add(lHarga);
        add(fNama);
        add(fMassa);
        add(fHarga);
        
        add(bSubmit);
        add(bReset);
        add(bBack);

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
        
        bSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bSubmit.addActionListener(this);
        bReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bReset.addActionListener(this);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            if (fMassa.getText().trim().equals("")) {
                setMessage("Massa harus diisi");
            }
            if (fHarga.getText().trim().equals("")) {
                setMessage("Harga harus diisi");
            }
            if (Integer.valueOf(fMassa.getText())<0 ) {
                setMessage("Massa harus positif");
            }
            if (Integer.valueOf(fHarga.getText())<0) {
                setMessage("Harga harus positif");
            }
            else {
                String[] data = {
                      id,   fNama.getText(), fMassa.getText(), fHarga.getText()
                };
                BarangController barang = new BarangController();
                barang.updateBarang(data);
              
            }
        }
        else if(e.getSource()==bReset){
            reset();
        }
        else if(e.getSource()==bBack){
           
            BarangController barang = new BarangController();
            barang.lihatBarang();
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

