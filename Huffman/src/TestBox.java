
public class TestBox {
	public static void main(String[] args){
		String s = "00000";
		s += 220;
		String n = s.substring(s.length()-5);
		System.out.println(n);
	}
}
