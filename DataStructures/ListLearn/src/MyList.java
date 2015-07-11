/** 
 * @ClassName: MyList 
 * @Description: 线性表公共接口 
 * @author yang yangyuanke35_gmail_com 
 * @date 2015年7月11日 上午12:49:56 
 *  
 */
public interface MyList {
	/** 
	* @Title: add 
	* @Description: 在list的末尾添加一个新元素 
	* @return void    返回类型 
	* @throws 
	*/
	public void add(Object o);
	
	/**
	 * @Description:在指定位置添加一个新元素
	 * @param int
	 * @param Object
	 */
	public void add(int index,Object o);
	/**
	 * @Description:清空list
	 */
	public void clear();
	/**
	 * @Description:如果list包含元素o返回true
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
	 * @Description:返回list中第一个匹配的元素的index，否则返回-1
	 * @param Object
	 * @return int
	 */
	public int indexOf(Object o);
	/**
	 * @Description:list为空，返回true
	 * @return boolean
	 */
	public boolean isEmpty();
	/**
	 * @Description:返回list中最后一个匹配的元素的index，否则返回-1
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
	 * @Description:移除list中指定位置的元素，左移操作；返回移除的元素
	 * @param int
	 * @return Object
	 */
	public Object remove(int index);
	/**
	 * @Description:替换指定位置的元素；返回新设置的元素
	 * @param int
	 * @param Object
	 * @return Object
	 */
	public Object set(int index,Object o);
	/**
	 * @Description:返回list中元素数
	 * @return int
	 */
	public int size();
}
