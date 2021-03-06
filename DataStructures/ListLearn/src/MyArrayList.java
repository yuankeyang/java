/**
 * @ClassName:MyArrayList
 * @author Զ��
 * @version V1.0
 */
public class MyArrayList extends MyAbstractList{
	public static final int INITIAL_CAPACITY=16;
	private Object[] data=new Object[INITIAL_CAPACITY];
	public MyArrayList(){
		
	}
	/**
	 * @param objects
	 * @Description:Create a list from an array of objects.
	 */
	public MyArrayList(Object[] objects){
		data=objects;
		size=objects.length;
	}
	/**
	 * @Description:Create a new larger array , double the current size.
	 */
	private void ensureCapacity(){
		if(size>=data.length){
			Object[] newData=new Object[data.length*2];
			System.arraycopy(data, 0, newData, 0, data.length);
			data=newData;
		}
	}
	
	@Override
	public void add(int index, Object o) {
		ensureCapacity();
		//Move the element to the right after the specified index.
		for(int i=size-1;i>=index;i--){
			data[i+1]=data[i];
		}
		//Insert new element to data[index].
		data[index]=o;
		//Increase size by 1.
		size++;
	}

	@Override
	public void clear() {
		data=new Object[INITIAL_CAPACITY];
	}

	@Override
	public boolean contains(Object o) {
		for(int i=0;i<size;i++){
			if(o.equals(data[i])) return true;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		return data[index];
	}

	@Override
	public int indexOf(Object o) {
		for(int i=0;i<size;i++)
			if(o.equals(data[i])) return i;
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		for(int i=size-1;i>=0;i--)
			if(o.equals(data[i])) return i;
		return -1;
	}

	@Override
	public Object remove(int index) {
		Object o=data[index];
		//Shift data to the left.
		for(int j=index;j<size-1;j++)
			data[j]=data[j+1];
		//Decrement size.
		size--;
		return o;
	}

	@Override
	public Object set(int index, Object o) {
		Object old=data[index];
		data[index]=o;
		return old;
	}

	@Override
	public String toString() {
		StringBuffer result=new StringBuffer("[");
		for(int i=0;i<size;i++){
			result.append(data[i]);
			if(i<size-1) result.append(", ");
		}
		return result.toString()+"]";
	}
	
}
