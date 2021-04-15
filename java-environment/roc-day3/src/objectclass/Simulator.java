package objectclass;

public class Simulator {

	public static void main(String[] args) {
		Info info_1 = new Info(1001, "Info Object");
		Info info_2 = new Info(1002, "Other Object");
		System.out.println(info_1 == info_2);
		
		System.out.println(info_1.equals(info_2));
		
		// implicitly call toString method on object
		System.out.println(info_1);
		System.out.println(info_2);
	}

}
