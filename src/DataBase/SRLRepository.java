/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

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
    
    @Override
    public List<Spectacle> readSpectacles() throws RemoteException{
        List<Spectacle> arr = new ArrayList();

        try {
            String QRY = "SELECT * FROM espectaculos ORDER By id";
            Connection con = DBManager.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QRY);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Date fecha = rs.getDate("fecha");
                Spectacle current = new Spectacle(id, nombre, fecha);
                current = readSeats(current);
                arr.add(current);
            }
//            System.out.println(QRY);
            stmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        
        return arr;
    }
    
    @Override
    public Spectacle readSeats(Spectacle s) throws RemoteException{
        List<Seat> arr = new ArrayList();
        try {
            String QRY = "SELECT * FROM " + getSeatsTableName(s) + " ORDER By id";
//            System.out.println(QRY);
            Connection con = DBManager.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QRY);

            while (rs.next()) {
                int id = rs.getInt("id");
                int state = rs.getInt("disponible");
                arr.add(new Seat(id, state));
            }
//            System.out.println(QRY);
            stmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        s.setSeats(arr);
        return s;
    }
    
    @Override
    public int updateSeats(Spectacle s) throws RemoteException{
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();
            List<Seat> seats = s.getSeats();
            for (Iterator<Seat> iterator = seats.iterator(); iterator.hasNext();) {
                Seat next = iterator.next();

                String SQL = "UPDATE " + getSeatsTableName(s) + " SET disponible=? WHERE id=?";
                PreparedStatement pstmt = con.prepareStatement(SQL);
                pstmt.setInt(1, next.getState());
                pstmt.setInt(2, next.getId());

                iRet = pstmt.executeUpdate();
//                System.out.println(pstmt.toString());
                pstmt.close();
            }
            
        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    @Override
    public int updateSeat(Spectacle sp, Seat se) throws RemoteException{
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "UPDATE " + getSeatsTableName(sp) + " SET disponible=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, se.getState());
            pstmt.setInt(2, se.getId());

            iRet = pstmt.executeUpdate();
//            System.out.println(pstmt.toString());
            pstmt.close();

        } catch (SQLException sqlE) {
            System.out.println(sqlE);
        }

        return iRet;
    }

    private String getSeatsTableName(Spectacle s) {
        String tableName = null;

        try {
            String QRY = "SELECT * FROM espectaculos WHERE nombre='" + s.getName() + "'";
            Connection con = DBManager.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QRY);

            while (rs.next()) {
                tableName = rs.getString("tabla_asientos");
            }

//            System.out.println(stmt.toString());
            stmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        return tableName;
    }
}
