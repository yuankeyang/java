
/**
 * @author Ô¶¿Í
 * @Description:Test class
 *
 */
public class TestList {

	public static void main(String[] args) {
		MyList list=new MyLinkedList();
		list.add("America");
		System.out.println("(1)"+list);
		list.add(0,"China");
		System.out.println("(2)"+list);
		list.add("Canada");
		System.out.println("(3)"+list);
		list.add("Russia");
		System.out.println("(4)"+list);
		System.out.println(list.remove("Canada"));
		System.out.println("(5)"+list);
	}

}
