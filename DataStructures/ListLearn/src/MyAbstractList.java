/**
 * @ClassName: MyAbstractList 
 * @author Զ��
 * @version V1.0
 *
 */
public abstract class MyAbstractList implements MyList {
	protected int size=0;
	
	/**
	 * @Description:Create a default list.
	 */
	protected MyAbstractList(){
		
	}
	/**
	 * @param Object[]
	 * @Decription:Create a list from an array of objects.
	 */
	protected MyAbstractList(Object[] objects){
		for(int i=0;i<objects.length;i++){
			this.add(objects[i]);
		}
	}
	public void add(Object o){
		add(size,o);
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(indexOf(o)>=0){
			remove(indexOf(o));
			return true;
		}
		else
			return false;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
}
