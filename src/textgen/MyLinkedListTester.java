/**
 *
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

	}


	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
//
	}


	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		// TODO: Add more tests here
		// removing from the start of the list
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		//removing from the middle of a list
		int b = longerList.remove(6);
		assertEquals("Remove: check a is correct ", 6, b);
		assertEquals("Remove: check element 6 is correct ", (Integer)7, longerList.get(6));
		assertEquals("Remove: check size is correct ", 9, longerList.size());

		// removing from the end of a list
		int c = longerList.remove(8);
		assertEquals("Remove: check c is correct ", 9, c);
		// check that index 9 no longer exists
		try {
			longerList.get(8);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		assertEquals("Remove: check size is correct ", 8, longerList.size());

		try {
			list1.remove(-2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list1.remove(5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
	}

	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// TODO: implement this test
		assertEquals("Add: check size is correct ", 3, list1.size());
		list1.add(12);
		assertEquals("Add: check element 3 is correct ", (Integer)12, list1.get(3));
		assertEquals("Add: check size is correct ", 4, list1.size());

		try {
			list1.add(null);
			fail("Check adding null element");
		} catch (NullPointerException e) {

		}
	}


	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Short list length", 2, shortList.size());
		assertEquals("Long list length", 2, shortList.size());
		assertEquals("List1 length", 10, longerList.size());

	}



	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// TODO: implement this test
		assertEquals("Remove: check size is correct ", 3, list1.size());
		assertEquals("Remove: check element 1 is correct ", (Integer)21, list1.get(1));
		list1.add(1,12);
		assertEquals("Remove: check element 1 is correct ", (Integer)12, list1.get(1));
		assertEquals("Remove: check size is correct ", 4, list1.size());

		//Assert exceptions
		try {
			list1.add(-1, 201);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			list1.add(11, 201);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			list1.add(null);
			fail("Check adding null element");
		} catch (NullPointerException e) {

		}
	}

	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		int a = list1.set(1,12);
		assertEquals("Remove: check a is correct ", 21, a);
		assertEquals("Remove: check element 1 is correct ", (Integer)12, list1.get(1));
		assertEquals("Remove: check size is correct ", 3, list1.size());

		String b = shortList.set(0, "D");
		assertEquals("Remove: check a is correct ", "A", b);
		assertEquals("Remove: check element 1 is correct ", (String)"D", shortList.get(0));
		assertEquals("Remove: check size is correct ", 2, shortList.size());

		int c = longerList.set(9, 121);
		assertEquals("Remove: check a is correct ", 9, c);
		assertEquals("Remove: check element 1 is correct ", (Integer)121, longerList.get(9));
		assertEquals("Remove: check size is correct ", 10, longerList.size());

		//Assert exceptions
		try {
			longerList.set(-1, 201);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			longerList.set(11, 201);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

	}
}
