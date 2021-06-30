package model;

import database.Connector;
import controller.BarangController;
import javax.swing.*;
import java.sql.*;

public class ModelBarang {
    private Connection connection;
    private Statement statement;
    
    public ModelBarang(){
        Connector connector = new Connector();
        connection = connector.getConnection();
}
    public void tambahBarang(String[] data){
        try{
            String query = " insert into barang ( nama, massa, harga) values ( ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
           
            ps.setString (1, data[0]);
            ps.setString (2, data[1]);
            ps.setString (3, data[2]);
            ps.executeUpdate();
            
            connection.close();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String[][] lihatBarang(){                                     
   try{
       int row = 0;
            int numRows = numRows("barang");
            if(numRows==0){
                return null;
            }
            String[][] data = new String[numRows][8];
            statement = connection.createStatement();
            String query = "Select * from barang";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[row][0] = resultSet.getString("id"); 
                data[row][1] = resultSet.getString("nama"); 
                data[row][2] = resultSet.getString("massa");
                data[row][3] = resultSet.getString("harga");
                row++; 
            }
            return data;
            
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
       public String[] lihatBarang(String id){                                     
        try{
            String[] data= new String[4];
            statement = connection.createStatement();
            String query = "select * from barang where id = '"+id+"'";
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[0] = resultSet.getString("id"); 
                data[1] = resultSet.getString("nama"); 
                data[2] = resultSet.getString("massa");
                data[3] = resultSet.getString("harga");
            }
            return data;
        }
           catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
       
       public String[] totalBarang(String id){                                     
        try{
            String[] data= new String[5];
            
            statement = connection.createStatement();
            String query = "select * from barang where id = '"+id+"'";
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[0] = resultSet.getString("id"); 
                data[1] = resultSet.getString("nama"); 
                data[2] = resultSet.getString("massa");
                data[3] = resultSet.getString("harga");
            }
            return data;
        }
           catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
       
public int numRows(String barang){
        int jmlData = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from barang";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public String getData(String column, String table, String where, String value){
        try{
            String data = new String();
            statement = connection.createStatement();
            String query = "select "+column+" from "+table+" where "+where+" = '" + value + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data = resultSet.getString(column);
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public void updateData(String[] data){
        try{
            
            String query = "UPDATE barang SET nama = '"+data[1]+"', massa = '"+data[2]+"', harga = '"+data[3]+"' WHERE id = '"+data[0]+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);    
            JOptionPane.showMessageDialog(null, "Berhasil");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(String id){
        try {
            String query = " delete from barang where id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, id);
            preparedStmt.execute();
            connection.close();

            JOptionPane.showMessageDialog(null, "Hapus Sukses");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Penghapusan Data Gagal");
        }
        BarangController barangController = new BarangController();
        barangController.lihatBarang();
    }
}