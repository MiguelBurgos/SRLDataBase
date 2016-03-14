/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DBManagement.SRLRepository;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author MiguelAngel
 */
public class SRLDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //create and get reference to rmi registry
            Registry registry = LocateRegistry.createRegistry(1099);
            // Iniciate DB object
            SRLRepository db = new SRLRepository();
            //Register DB object
            registry.rebind("SRLRepository", db);
            System.out.println("SRLDataBase is created!!!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
