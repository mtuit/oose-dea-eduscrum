package nl.ica.oose;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Mick on 15/02/2017.
 */
public class TerugTeller extends UnicastRemoteObject implements ITerugTeller{
    private int value;
    private ArrayList<ICallback> listeners = new ArrayList<ICallback>();

    public TerugTeller() throws RemoteException {
    }


    public void setValue(int value) throws RemoteException {
        this.value = value;
    }

    public int getValue() throws RemoteException {
        return this.value;
    }

    public void decrement() throws RemoteException {
        if (checkIfMultipleOfNumber(this.value, 25)) {
            for (ICallback callbacks : listeners) {
                callbacks.notifyChange(this.value);
            }
        }
        this.value -= 1;
    }

    public void addCallbackListener(ICallback callback) {
        listeners.add(callback);
    }

    public boolean checkIfMultipleOfNumber (int value, int number) {
        return value % number == 0;
    }

}
