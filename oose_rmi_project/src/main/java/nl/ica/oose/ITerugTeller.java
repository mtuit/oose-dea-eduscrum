package nl.ica.oose;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Mick on 15/02/2017.
 */
public interface ITerugTeller extends Remote {

    public void setValue(int value) throws RemoteException;

    public int getValue() throws RemoteException;

    public void decrement() throws RemoteException;

    public void addCallbackListener(ICallback callback) throws RemoteException;

}
