package nl.ica.oose.dea;

import org.junit.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by Mick on 16/02/2017.
 */
public class SorterTest {
	Sorter sut;
	ArrayList<Integer> listUnsorted;
	ArrayList<Integer> listSorted;

	@Before
	public void setUp() throws RemoteException {
		sut = new Sorter();
	}

	@Test
	public void testSortAlgorithm() throws RemoteException {
		listUnsorted = new ArrayList<Integer>();
		listSorted = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			int temp = (int) (Math.random() * 101);
			listUnsorted.add(temp);
		}

		listSorted = listUnsorted;
		Collections.sort(listSorted);

		assertEquals(listSorted, sut.sort(listUnsorted));
}

	@Test
	public void testIsEmpty() throws RemoteException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertTrue(sut.sort(list).isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void testNullListSortAlgorithm() throws RemoteException {
		sut.sort(listUnsorted);
	}
}