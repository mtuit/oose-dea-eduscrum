package nl.ica.oose.dea;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

/**
 * Created by Mick on 20/02/2017.
 */
public class SortClient {
	ArrayList<Integer> joinedList = new ArrayList<Integer>();

	public void join(ArrayList<Integer> list) {
		for (Integer i : list) {
			joinedList.add(i);
		}
	}

	public ArrayList<ArrayList<Integer>> spliceArray(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> spliceList = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> head = new ArrayList<Integer>();
		ArrayList<Integer> tail = new ArrayList<Integer>();

		for (Integer i : list) {
			if (i <= list.size() / 2) {
				head.add(i);
			} else {
				tail.add(i);
			}
		}

		spliceList.add(head);
		spliceList.add(tail);
		return spliceList;
	}

	private ArrayList<Integer> generateRandomList(int length) {
		ArrayList<Integer> list = new ArrayList<Integer>(length);
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * length + 1);
			list.add(rand);
		}
		return list;
	}

	public void sort() throws RemoteException, NotBoundException, MalformedURLException {
		ArrayList<Integer> list = generateRandomList(1000);
		ArrayList<ArrayList<Integer>> lists = spliceArray(list);

		for (int i = 0; i < lists.size(); i++) {
			ISorter sorter = (ISorter) Naming.lookup("sorter1");
			ArrayList<Integer> result = sorter.sort(lists.get(i));
			join(result);
		}

		for (Integer i : joinedList) {
			System.out.println("Nummer:" + i);
		}
	}

	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
		SortClient sc = new SortClient();
		sc.sort();
	}

}
