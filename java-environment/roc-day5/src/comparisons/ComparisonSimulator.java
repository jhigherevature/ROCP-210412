package comparisons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ComparisonSimulator {
	public static void main(String[] args) {

		Data d_1 = new Data(3, 1.5);
		Data d_2 = new Data(5, 7.3);
		Data d_3 = new Data(37, 3.8);
		Data d_4 = new Data(101, 2.7);
		Data d_5 = new Data(18, 19.4);

		Data[] datas = { d_1, d_2, d_3, d_4, d_5 };

		System.out.println("Comparable:");
		System.out.println(Arrays.toString(datas));
		Arrays.sort(datas);
		System.out.println(Arrays.toString(datas));

		System.out.println("Comparator [ID]:");
		ArrayList<Data> list = new ArrayList<Data>();
		list.add(d_1);
		list.add(d_2);
		list.add(d_3);
		list.add(d_4);
		list.add(d_5);
		System.out.println("Before ID Sort:\n" + list);
		Collections.sort(list, new DataIdComparator());
		System.out.println("ID Sort:\n"+ list);
		
		System.out.println("Comparator [WEIGHT]:");
		System.out.println("Before Weight Sort:\n"+list);
		Collections.sort(list, new DataWeightComparator());
		System.out.println("Weight Sort:\n"+list);
	}
}
