package nl.ica.oose.dea;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Mick on 16/02/2017.
 */
public interface ISorter extends Remote {

    public ArrayList<Integer> sort(ArrayList<Integer> list) throws NullPointerException, RemoteException;

}
