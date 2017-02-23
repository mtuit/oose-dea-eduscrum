package nl.ica.oose;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Mick on 15/02/2017.
 */
public class TerugTellerServer {

    public static void main (String[] args) {
        ITerugTeller teller;
        try {
            teller = new TerugTeller();
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("terugteller", teller);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
