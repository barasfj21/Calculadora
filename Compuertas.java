
public class Compuertas {
	public Boolean NOT(Boolean a) {
		return !a;
	}
	public Boolean NAND(Boolean a,Boolean b,Boolean c,Boolean d) {
		return !(a&b&c&d);
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
	public static Boolean XOR(Boolean a,Boolean b) {
		return (NAND(NAND(a,NAND(b,a,true,true),true,true),NAND(b,NAND(b,a,true,true),true,true),true,true));
    }
	public static void main(String []args) {
		Compuertas asd = new Compuertas();
		System.out.println(asd.NOT(true));
		System.out.println(asd.NAND(true,true,true,true));
	}
}
