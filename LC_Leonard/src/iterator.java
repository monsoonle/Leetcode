import java.util.ArrayList;
import java.util.Iterator;

public class iterator {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item1 = new ArrayList<Integer>();
		item1.add(1);
		item1.add(2);
		item1.add(3);
		ArrayList<Integer> item2 = new ArrayList<Integer>();
		item2.add(4);
		item2.add(5);
		item2.add(6);
		lists.add(item1);
		lists.add(item2);
//		
//		Iterator i1 = list.iterator();
//		while (i1.hasNext()) {
//			ArrayList<Integer> temp = (ArrayList<Integer>) i1.next();
//			Iterator i = temp.iterator();
//			while (i.hasNext()) {
//				System.out.println(i.next() + "  ");
//			}
//		}
		for (ArrayList<Integer> list : lists) {
			System.out.println(list.toString());
		}

	}
}
