
public class Compuertas {
	public Boolean NOT(Boolean a) {
		return !a;
	}
	public Boolean NAND(Boolean a,Boolean b,Boolean c,Boolean d) {
		return a&b&c&d;
	}
	public Boolean AND(Boolean a,Boolean b,Boolean c,Boolean d) {
		return NOT(NAND(a,b,c,d));
	}
	public Boolean OR(Boolean a,Boolean b,Boolean c,Boolean d) {
		return NAND(NOT(a),NOT(b),NOT(c),NOT(d));
	}
	public Boolean NOR(Boolean a,Boolean b,Boolean c,Boolean d) {
		return NOT(OR(a,b,c,d));
	}
	public Boolean XOR(Boolean a,Boolean b,Boolean c,Boolean d) {
		//return NAND(NAND(a,),NAND(),NAND());
	}
	public static void main(String []args) {
		Compuertas asd = new Compuertas();
		System.out.println(asd.NOT(true));
		System.out.println(asd.NAND(true,true,true,true));
	}
}
