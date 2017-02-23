package nl.ica.oose.dea;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Condition;


/**
 * Created by Mick on 16/02/2017.
 */
public class Sorter extends UnicastRemoteObject implements ISorter{


	public Sorter() throws RemoteException {
	}

	public ArrayList<Integer> sort(ArrayList<Integer> list) throws NullPointerException, RemoteException{
    	if (list == null) {
    		throw new NullPointerException();
		}

		Collections.sort(list);
    	return list;
    }
}
