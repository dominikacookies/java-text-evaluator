package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	@Override
	public boolean add(E element )
	{
		// TODO: Implement this method
		LLNode<E> currentNode = tail.prev;
		LLNode<E> newNode = new LLNode<E>(element, currentNode, tail);
		tail.prev = newNode;
		currentNode.next = newNode;
		size++;
		return true;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	@Override
	public E get(int index)
	{
		// TODO: Implement this method.
		if (index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException("Index" + index + "is out of bounds");
		} else {
			LLNode<E> node = head;
			for (int i=0 ; i < index+1; i++) {
				node = node.next;
			}
			return node.data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	@Override
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if (index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException("Index" + index + "is out of bounds");
		} else {
			LLNode<E> currentNodeAtIndex = head;
			for (int i=0 ; i < index+1; i++) {
				currentNodeAtIndex = currentNodeAtIndex.next;
			}
			LLNode<E> previousNode = currentNodeAtIndex.prev;
			LLNode<E> newNode = new LLNode<E>(element, previousNode, currentNodeAtIndex);
			previousNode.next = newNode;
			currentNodeAtIndex.prev = newNode;
			size++;
		}
	}


	/** Return the size of the list */
	@Override
	public int size()
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	@Override
	public E remove(int index)
	{
		// TODO: Implement this method
		if (index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException("Index" + index + "is out of bounds");
		}

		E nodeToRemoveData = head.data;

		if (index == 0) {
			LLNode<E> nodeToRemove = head.next;
			nodeToRemoveData = nodeToRemove.data;
			LLNode<E> newHeadNode = nodeToRemove.next;
			newHeadNode.prev = head;
			head.next = newHeadNode;
		}

		if (index == size-1) {
			LLNode<E> nodeToRemove = tail.prev;
			nodeToRemoveData = nodeToRemove.data;
			LLNode<E> newTailNode = nodeToRemove.prev;
			newTailNode.next = tail;
			tail.prev = newTailNode;
		}

		if (index > 0 && index < size-1) {
			LLNode<E> currentNodeInLoop = head;
			LLNode<E> previousNode = head;
			LLNode<E> nextNode = head;

			for (int i=1 ; i < index+2; i++) {
				currentNodeInLoop = currentNodeInLoop.next;

				if (i == index+1) {
					nextNode = currentNodeInLoop;
				}

				if (i== index) {
					nodeToRemoveData = currentNodeInLoop.data;
				}

				if (i == index-1) {
					previousNode = currentNodeInLoop;
				}
			}

			previousNode.next = nextNode;
			nextNode.prev = previousNode;
		}

		size--;
		return nodeToRemoveData;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	@Override
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if (index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException("Index" + index + "is out of bounds");
		} else {
			LLNode<E> currentNodeAtIndex = head;
			for (int i=0 ; i < index+1; i++) {
				currentNodeAtIndex = currentNodeAtIndex.next;
			}

			LLNode<E> nextNode = currentNodeAtIndex.next;
			LLNode<E> previousNode = currentNodeAtIndex.prev;
			LLNode<E> newNode = new LLNode<E>(element, previousNode, nextNode);
			previousNode.next = newNode;
			nextNode.prev = newNode;
			return (E) currentNodeAtIndex.data;
		}
	}
}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e)
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e, LLNode prevNode, LLNode nextNode) {
		this.data = e;
		this.next = nextNode;
		this.prev = prevNode;
	}

}
