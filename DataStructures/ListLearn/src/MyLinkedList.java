/**
 * @author Ô¶¿Í
 *
 */
public class MyLinkedList extends MyAbstractList{
	private Node first,last;
	private static class Node{
		Object element;
		Node next;
		public Node(Object o){
			element=o;
		}
	}
	public MyLinkedList(){}
	public MyLinkedList(Object[] objects){
		super(objects);
	}
	/**
	 * @Description:Return the first element in the list 
	 * @return Object
	 */
	public Object getFirst() {
		if(size==0) return null;
		else return first.element;
	}
	/**
	 * @Description:Return the last element in the list
	 * @return Object
	 */
	public Object getLast() {
		if(size==0) return null;
		else return last.element;
	}
	public void addFirst(Object o){
		Node newNode=new Node(o);
		newNode.next=first;
		first=newNode;
		size++;
		
		if(last==null)
			last=first;
	}
	public void addLast(Object o) {
		if(last==null){
			first=last=new Node(o);
		}else{
			last.next=new Node(o);
			last=last.next;
		}
		size++;
	}

	@Override
	public void add(int index, Object o) {
		if(index==0) addFirst(o);
		else if(index>=size) addLast(o);
		else{
			Node current=first;
			for(int i=0;i<index;i++){
				current=current.next;
			}
			Node temp=current.next;
			current.next=new Node(o);
			(current.next).next=temp;
			size++;
		}
	}
	public Object removeFirst() {
		if(size==0) return null;
		else{
			Node temp=first;
			first=first.next;
			size--;
			if(first==null) last=null;
			return temp.element;
		}
	}
	public Object removeLast(){
		if(size==0) return null;
		else{
			Node temp=last;
			Node previous=first;
			for(int i=1;i<size-1;i++){
				previous=previous.next;
			}
			last=previous;
			size--;
			if(last==null) first=null;
			return temp.element;
		}
	}
	public Object remove(int index) {
		if((index<0)||(index>=size)) return null;
		else if(index==0) return removeFirst();
		else if(index==size-1) return removeLast();
		else {
			Node previous=first;
			for(int i=1;i<index;i++){
				previous=previous.next;
			}
			Node current=previous.next;
			previous.next=current.next;
			size--;
			return current.element;
		}
	}

	@Override
	public void clear() {
		first=last=null;
	}

	@Override
	public boolean contains(Object o) {
		Node current=first;
		for(int i=0;i<size;i++){
			if(o.equals(current.element)) return true;
			current=current.next;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		if((index<0)||(index>=size)) return null;
		else{
		Node current=first;
		for(int i=0;i<index;i++)
			current=current.next;
		return current;
		}
	}

	@Override
	public int indexOf(Object o) {
		Node current=first;
		for(int i=0;i<size;i++){
			if(o.equals(current.element)) return i;
			else current=current.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		for(int i=size-1;i>=0;i--)
			if(o.equals(get(i))) return i;
		return -1;
	}


	@Override
	public Object set(int index, Object o) {
		Node current=first;
		Object old=null;
		for(int i=0;i<index;i++)
			current=current.next;
		old=current.element;
		current.element=o;
		return old;
	}
	@Override
	public String toString() {
		StringBuffer result=new StringBuffer("[");
		Node current=first;
		for(int i=0;i<size;i++){
			result.append(current.element);
			current=current.next;
			if(current!=null)
				result.append(",");
			else
				result.append("]");
		}
		return result.toString();
	}
	
	
}
