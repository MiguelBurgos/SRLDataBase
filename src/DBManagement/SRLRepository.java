/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManagement;

import SRL.IRemoteSRL;
import SRL.Seat;
import SRL.Spectacle;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author MiguelAngel
 */
public class SRLRepository extends UnicastRemoteObject implements IRemoteSRL{

    public SRLRepository() throws RemoteException{
    }

    public int save(Object ob) {
        int iRet = -1;
/*        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "INSERT INTO Province (Id, ShortName, Name) values(?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, o.getId());
            pstmt.setString(2, o.getShortName());
            pstmt.setString(3, o.getName());

            iRet = pstmt.executeUpdate();

            System.out.println(pstmt.toString());
            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
      }*/
        return iRet;
    }
    
    public ArrayList<Spectacle> readSpectacles(){
        ArrayList arr = new ArrayList();

        try {
            String QRY = "SELECT * FROM espectaculos ORDER By id";
            Connection con = DBManager.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QRY);

            while (rs.next()) {
                Spectacle current;
                int id = rs.getInt("Id");
                String nombre = rs.getString("nombre");
                Date fecha = rs.getDate("fecha");
                current = new Spectacle(id, nombre, fecha);
                
                String seatsTable = rs.getString("tabla_asientos");
                current = readSeats(current);
                arr.add(current);
            }
            System.out.println(QRY);
            stmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        return arr;
    }
    
    public int updateSeats(Spectacle s) {
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();
            List<Seat> seats = s.getSeats();
            for (Iterator<Seat> iterator = seats.iterator(); iterator.hasNext();) {
                Seat next = iterator.next();

                String SQL = "UPDATE " + getSeatsTable_Name(s) + " SET disponible=? WHERE Id=?";
                PreparedStatement pstmt = con.prepareStatement(SQL);
                pstmt.setBoolean(1, next.isAvailable());
                pstmt.setInt(2, next.getId());

                iRet = pstmt.executeUpdate();
                System.out.println(pstmt.toString());
                pstmt.close();
            }
            
        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    public int updateSeat(Spectacle sp, Seat se) {
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "UPDATE " + getSeatsTable_Name(sp) + " SET disponible=? WHERE Id=?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setBoolean(1, se.isAvailable());
            pstmt.setInt(2, se.getId());

            iRet = pstmt.executeUpdate();
            System.out.println(pstmt.toString());
            pstmt.close();

        } catch (SQLException sqlE) {
            System.out.println(sqlE);
        }

        return iRet;
    }
    
    public Spectacle readSeats(Spectacle s){
        ArrayList arr = new ArrayList();
        try {
            String QRY = "SELECT * FROM " + getSeatsTable_Name(s) + " ORDER By id";
            Connection con = DBManager.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QRY);

            while (rs.next()) {
                int id = rs.getInt("Id");
                boolean available = rs.getBoolean("disponible");
                arr.add(new Seat(id, available));
            }
            System.out.println(QRY);
            stmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        s.setSeats(arr);
        return s;
    }

    private String getSeatsTable_Name(Spectacle s) {
        String tableName = null;

        try {
            String QRY = "SELECT * FROM espectaculos WHERE name=" + s.getName();
            Connection con = DBManager.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QRY);

            while (rs.next()) {
                tableName = rs.getString("tabla_asientos");
            }

            System.out.println(stmt.toString());
            stmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        return tableName;
    }
}
