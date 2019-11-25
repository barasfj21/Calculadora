import java.util.ArrayList;

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
	public Boolean XOR(Boolean a,Boolean b) {
		return (NAND(NAND(a,NAND(b,a,true,true),true,true),NAND(b,NAND(b,a,true,true),true,true),true,true));
	}
	
	public ArrayList<Boolean> Alu(Boolean a1,Boolean a2,Boolean a3,Boolean a4,Boolean SR,Boolean b1,Boolean b2,Boolean b3,Boolean b4) {
		ArrayList<Boolean> listaRespuesta = new ArrayList<Boolean>();
		Boolean[] respuestas = sumador(a4,XOR(SR,b4),SR);
		listaRespuesta.add(respuestas[1]);
		respuestas = sumador(a3,XOR(SR,b3),respuestas[0]);
		listaRespuesta.add(respuestas[1]);
		respuestas = sumador(a2,XOR(SR,b2),respuestas[0]);
		listaRespuesta.add(respuestas[1]);
		respuestas = sumador(a1,XOR(SR,b1),respuestas[0]);
		listaRespuesta.add(respuestas[1]);
		for(int i =listaRespuesta.size()-1; i>=0;i--) {
			System.out.print(listaRespuesta.get(i));
		}
		return listaRespuesta;
	}
	public Boolean[] sumador(Boolean a,Boolean b, Boolean cIn) {
		Boolean cOut = OR(AND(true,a,b,cIn),AND(true,a,b,NOT(cIn)),AND(true,a,NOT(b),cIn),AND(true,NOT(a),b,cIn));
		Boolean R = AND(OR(false,a,b,cIn),OR(false,a,NOT(b),NOT(cIn)),OR(false,NOT(a),b,NOT(cIn)),OR(false,NOT(a),NOT(b),cIn));
		return new Boolean[]{cOut,R};
	}
	
	
	public Boolean[] BinaryConvertDecimal(Boolean a,Boolean b,Boolean c,Boolean d) {
		Boolean[] result = new Boolean[7];
		result[0]=OR(OR(AND(NOT(a),NOT(b),NOT(c),NOT(d)),AND(NOT(a),NOT(b),c,NOT(d)),AND(NOT(a),NOT(b),c,d),AND(NOT(a),b,NOT(c),d)),OR(AND(NOT(a),b,c,NOT(d)),AND(NOT(a),b,c,d),AND(a,NOT(b),NOT(c),NOT(d)),AND(a,NOT(b),NOT(c),d)),false,false);
		result[1]=OR(OR(AND(NOT(a),NOT(b),NOT(c),NOT(d)),AND(NOT(a),NOT(b),NOT(c),d),AND(NOT(a),NOT(b),c,NOT(d)),AND(NOT(a),NOT(b),c,d)),OR(AND(NOT(a),b,NOT(c),NOT(d)),AND(NOT(a),b,c,d),AND(a,NOT(b),NOT(c),NOT(d)),AND(a,NOT(b),NOT(c),d)),false,false);
		result[2]=OR(OR(AND(NOT(a),NOT(b),NOT(c),NOT(d)),AND(NOT(a),NOT(b),NOT(c),d),AND(NOT(a),b,NOT(c),NOT(d)),AND(NOT(a),b,NOT(c),d)),OR(AND(NOT(a),b,c,NOT(d)),AND(NOT(a),b,c,d),AND(a,NOT(b),NOT(c),NOT(d)),AND(a,NOT(b),NOT(c),d)),false,false);
		result[3]=OR(OR(AND(NOT(a),NOT(b),NOT(c),NOT(d)),AND(NOT(a),NOT(b),c,NOT(d)),AND(NOT(a),NOT(b),c,d),AND(NOT(a),b,NOT(c),d)),OR(AND(NOT(a),b,c,NOT(d)),AND(a,NOT(b),NOT(c),NOT(d)),AND(a,NOT(b),NOT(c),d),false),false,false);
		result[4]=OR(OR(AND(NOT(a),NOT(b),NOT(c),NOT(d)),AND(NOT(a),NOT(b),c,NOT(d)),AND(NOT(a),b,c,NOT(d)),AND(a,NOT(b),NOT(c),NOT(d))),false,false,false);
		result[5]=OR(OR(AND(NOT(a),NOT(b),NOT(c),NOT(d)),AND(NOT(a),b,NOT(c),NOT(d)),AND(NOT(a),b,NOT(c),d),AND(NOT(a),b,c,NOT(d))),OR(AND(a,NOT(b),NOT(c),NOT(d)),AND(a,NOT(b),NOT(c),d),false,false),false,false);
		result[6]=OR(OR(AND(NOT(a),NOT(b),c,NOT(d)),AND(NOT(a),NOT(b),c,d),AND(NOT(a),b,NOT(c),NOT(d)),AND(NOT(a),b,NOT(c),d)),OR(AND(NOT(a),b,c,NOT(d)),AND(a,NOT(b),NOT(c),NOT(d)),AND(a,NOT(b),NOT(c),d),false),false,false);
		return result;
	}
	
	
	public static void main(String []args) {
		Compuertas asd = new Compuertas();
		Boolean[] datos=asd.BinaryConvertDecimal(false, false, false, false);
		System.out.println("Numero 0:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(false, false, false, true);
		System.out.println("Numero 1:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(false, false,true, false);
		System.out.println("Numero 2:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(false, false, true, true);
		System.out.println("Numero 3:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(false, true, false, false);
		System.out.println("Numero 4:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(false, true, false, true);
		System.out.println("Numero 5:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(false, true, true, false);
		System.out.println("Numero 6:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(false, true, true, true);
		System.out.println("Numero 7:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(true, false, false, false);
		System.out.println("Numero 8:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		datos=asd.BinaryConvertDecimal(true, false, false, true);
		System.out.println("Numero 9:"+datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" "+datos[5]+" "+datos[6]);
		
	}
}
