import java.util.ArrayList;
import java.util.List;

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
	public static void main(String []args) {
		Compuertas asd = new Compuertas();
		asd.Alu(false,true,false,true,true,false,false,true,false);
	}
}
