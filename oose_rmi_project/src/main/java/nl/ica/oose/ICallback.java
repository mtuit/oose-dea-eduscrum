package nl.ica.oose;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Mick on 15/02/2017.
 */
public interface ICallback extends Remote{

    public void notifyChange(int value) throws RemoteException;

}
