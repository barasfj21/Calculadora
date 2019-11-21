
public class Compuertas {
	public Boolean NOT(Boolean a) {
		return !a;
	}
	public Boolean NAND(Boolean a,Boolean b,Boolean c) {
		return a&b&c;
	}
	public Boolean AND(Boolean a,Boolean b,Boolean c) {
		return NOT(NAND(a,b,c));
	}
	public Boolean OR(Boolean a,Boolean b,Boolean c) {
		return NAND(NOT(a),NOT(b),NOT(c));
	}
	public Boolean NOR(Boolean a,Boolean b,Boolean c) {
		return NOT(OR(a,b,c));
	}
	public Boolean XOR(Boolean a,Boolean b,Boolean c) {
		//return NAND(NAND(a,),NAND(),NAND());
	}
	public static void main(String []args) {
		Compuertas asd = new Compuertas();
		System.out.println(asd.NOT(true));
		System.out.println(asd.NAND(true,true,true));
	}
}
