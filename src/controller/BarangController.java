package controller;

import view.*;
import model.ModelBarang;

public class BarangController {
    public void tambahBarang(){
        ViewFormBarang view = new ViewFormBarang();
        view.form();
    }

    public void tambahBarang(String[] data){
        ModelBarang barangModel = new ModelBarang();
        barangModel.tambahBarang(data);
    }

    public void lihatBarang(){
        ModelBarang moB = new ModelBarang();
        String[][] data = moB.lihatBarang();
        if(data == null)
            new ViewMenu();
        else
            new ViewBarang(data);     
}
    
    public void lihatBarang(String id){
        ModelBarang moB = new ModelBarang();
        ViewDetail view = new ViewDetail();
        view.openDetail(moB.lihatBarang(id));
    }
    
    public void updateBarang(String id){
        ModelBarang moB = new ModelBarang();
        String kode = moB.getData("id", "barang", "id", id);
        UpdateFormBarang update = new UpdateFormBarang();
        update.openForm(moB.lihatBarang(id));
    }
    public void updateBarang(String[] data){
        ModelBarang moB = new ModelBarang(); 
        moB.updateData(data);
    }
    public void totalBarang(String id){
        ModelBarang moB = new ModelBarang();
        String kode = moB.getData("id", "barang", "id", id);
        ViewTotal view = new ViewTotal();
        view.openTotal(moB.totalBarang(id));
    }
    
    public void delete(String id){
        ModelBarang moB = new ModelBarang(); 
        moB.delete(id);
    } 
    
}
