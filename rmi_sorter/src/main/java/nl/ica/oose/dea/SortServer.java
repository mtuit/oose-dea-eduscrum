package nl.ica.oose.dea;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Mick on 20/02/2017.
 */
public class SortServer {

	public static void main(String[] args)  {
		ISorter sorter1, sorter2;

		try {
			sorter1 = new Sorter();
			//sorter2 = new Sorter();

			Registry r = LocateRegistry.createRegistry(1099);
			r.rebind("sorter1", sorter1);
			//r.rebind("sorter2", sorter2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
