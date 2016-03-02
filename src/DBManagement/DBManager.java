/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManagement;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MiguelAngel
 */
public class DBManager {

    private static DBManager _instance = null;
    private Connection _con = null;

    public DBManager() throws RemoteException{
        _con = getMySQLConnection();
    }

    public Connection getConnection() {
        return _con;
    }

    public static synchronized DBManager getInstance() {
        if (_instance == null) {
            try {
                _instance = new DBManager();
            } catch (RemoteException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _instance;
    }

    private static Connection getMySQLConnection() {
        Connection con = null;
        try {
            String strCon = "jdbc:mysql://127.0.0.1/srl?user=root&password=";
            con = DriverManager.getConnection(strCon);
        } catch (SQLException se) {
            System.out.println(se);
        }
        return contras;
    }

}
