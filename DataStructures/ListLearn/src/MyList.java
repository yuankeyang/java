/** 
 * @ClassName: MyList 
 * @Description: ���Ա����ӿ� 
 * @author yang yangyuanke35_gmail_com 
 * @date 2015��7��11�� ����12:49:56 
 *  
 */
public interface MyList {
	/** 
	* @Title: add 
	* @Description: ��list��ĩβ���һ����Ԫ�� 
	* @return void    �������� 
	* @throws 
	*/
	public void add(Object o);
	
	/**
	 * @Description:��ָ��λ�����һ����Ԫ��
	 * @param int
	 * @param Object
	 */
	public void add(int index,Object o);
	/**
	 * @Description:���list
	 */
	public void clear();
	/**
	 * @Description:���list����Ԫ��o����true
	 * @param Object
	 * @return boolean
	 */
	public boolean contains(Object o);
	/**
	 * @param int
	 * @return Object
	 */
	public Object get(int index);
	/**
	 * @Description:����list�е�һ��ƥ���Ԫ�ص�index�����򷵻�-1
	 * @param Object
	 * @return int
	 */
	public int indexOf(Object o);
	/**
	 * @Description:listΪ�գ�����true
	 * @return boolean
	 */
	public boolean isEmpty();
	/**
	 * @Description:����list�����һ��ƥ���Ԫ�ص�index�����򷵻�-1
	 * @param Object
	 * @return int
	 */
	public int lastIndexOf(Object o);
	/**
	 * @param Object
	 * @return boolean
	 */
	public boolean remove(Object o);
	/**
	 * @Description:�Ƴ�list��ָ��λ�õ�Ԫ�أ����Ʋ����������Ƴ���Ԫ��
	 * @param int
	 * @return Object
	 */
	public Object remove(int index);
	/**
	 * @Description:�滻ָ��λ�õ�Ԫ�أ����������õ�Ԫ��
	 * @param int
	 * @param Object
	 * @return Object
	 */
	public Object set(int index,Object o);
	/**
	 * @Description:����list��Ԫ����
	 * @return int
	 */
	public int size();
}
