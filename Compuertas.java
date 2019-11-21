
public class Compuertas {
	public Boolean NOT(Boolean a) {
		return !a;
	}
	public Boolean NAND(Boolean a,Boolean b,Boolean c) {
		return a&b&c;
	}
	public static void main(String []args) {
		Compuertas asd = new Compuertas();
		System.out.println(asd.NOT(true));
		System.out.println(asd.NAND(true,true,true));
	}
}
