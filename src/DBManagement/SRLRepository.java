/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManagement;

import SRL.IRemoteSRL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MiguelAngel
 */
public class SRLRepository extends UnicastRemoteObject implements IRemoteSRL{

    public SRLRepository() throws RemoteException{
    }

    public int save(Object o) {
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

}
