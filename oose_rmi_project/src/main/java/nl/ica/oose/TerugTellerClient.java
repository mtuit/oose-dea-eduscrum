package nl.ica.oose;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Mick on 15/02/2017.
 */
public class TerugTellerClient extends TerugTeller implements ICallback {

    public static void main (String[] args) throws RemoteException, NotBoundException {
        TerugTellerClient ttc = new TerugTellerClient();

    }

    public TerugTellerClient() throws RemoteException, NotBoundException {
        ITerugTeller teller = (ITerugTeller) LocateRegistry.getRegistry().lookup("terugteller");
        teller.setValue(200);
        teller.addCallbackListener(this);

        System.out.println(teller.getValue());
        for (int i = 0; i < 100; i++) {
            teller.decrement();
            System.out.println(teller.getValue());
        }
    }


    public void notifyChange(int value) throws RemoteException {
        System.out.println(value + " is een veelvoud van 25!");
    }
}
