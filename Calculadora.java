import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnMas,btnMenos,btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btnClear;
	//Lista con los numeros en boolean
	Boolean[] cero = {false,false,false,false};
	Boolean[] uno = {false,false,false,true};
	Boolean[] dos = {false,false,true,false};
	Boolean[] tres = {false,false,true,true};
	Boolean[] cuatro = {false,true,false,false};
	Boolean[] cinco = {false,true,false,true};
	Boolean[] seis = {false,true,true,false};
	Boolean[] siete = {false,true,true,true};
	Boolean[] ocho = {true,false,false,false};
	Boolean[] nueve = {true,false,false,true};
	
	//primerOperando es el numero de los botones de la izquierda, y segundo los de la derecha
	Boolean[] primerOperando;
	Boolean[] segundoOperando;
	
	//Define si se suma o se resta, F si es resta
	Boolean senalOperacion = false;
	
	//Variable que almacena la respuesta del metodo ALU de compuertas
	String respuesta;
	
	
	Compuertas asd = new Compuertas();
	
	JPanel pnR0Num1 = new JPanel();
	JPanel pnR5Num1 = new JPanel();
	JPanel pnR6Num1 = new JPanel();
	JPanel pnR1Num1 = new JPanel();
	JPanel pnR2Num1 = new JPanel();
	JPanel pnR4Num1 = new JPanel();
	JPanel pnR3Num1 = new JPanel();
	JPanel pnR3Num2 = new JPanel();
	JPanel pnR2Num2 = new JPanel();
	JPanel pnR4Num2 = new JPanel();
	JPanel pnR6Num2 = new JPanel();
	JPanel pnR5Num2 = new JPanel();
	JPanel pnR1Num2 = new JPanel();
	JPanel pnR0Num2 = new JPanel();
	JPanel pnR3Num3 = new JPanel();
	JPanel pnR2Num3 = new JPanel();
	JPanel pnR4Num3 = new JPanel();
	JPanel pnR6Num3 = new JPanel();
	JPanel pnR5Num3 = new JPanel();
	JPanel pnR1Num3 = new JPanel();
	JPanel pnR0Num3 = new JPanel();
	JPanel pnR5Num4 = new JPanel();
	JPanel pnR4Num4 = new JPanel();
	JPanel pnR3Num4 = new JPanel();
	JPanel pnR2Num4 = new JPanel();
	JPanel pnR6Num4 = new JPanel();
	JPanel pnR1Num4 = new JPanel();
	JPanel pnR0Num4 = new JPanel();
	private final JPanel pnOperator = new JPanel();
	private final JPanel pnOperador2 = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn4 = new JButton("4");
		btn4.setBounds(30, 85, 58, 23);
		contentPane.add(btn4);
		
		btn7 = new JButton("7");
		btn7.setBounds(30, 119, 58, 23);
		contentPane.add(btn7);
		
		btn2 = new JButton("2");
		btn2.setBounds(98, 51, 58, 23);
		contentPane.add(btn2);
		
		btn5 = new JButton("5");
		btn5.setBounds(98, 85, 58, 23);
		contentPane.add(btn5);
		
		btn8 = new JButton("8");
		btn8.setBounds(98, 119, 58, 23);
		contentPane.add(btn8);
		
		btn0 = new JButton("0");
		btn0.setBounds(98, 153, 58, 23);
		contentPane.add(btn0);
		
		btn3 = new JButton("3");
		btn3.setBounds(166, 51, 58, 23);
		contentPane.add(btn3);
		
		btn6 = new JButton("6");
		btn6.setBounds(166, 85, 58, 23);
		contentPane.add(btn6);
		
		btn9 = new JButton("9");
		btn9.setBounds(166, 119, 58, 23);
		contentPane.add(btn9);
		
		btnMas = new JButton("+");
		btnMas.setBounds(264, 68, 63, 31);
		contentPane.add(btnMas);
		
		btnMenos = new JButton("-");
		btnMenos.setBounds(264, 111, 41, 31);
		contentPane.add(btnMenos);
		
		btn_1 = new JButton("1");
		btn_1.setBounds(339, 51, 58, 23);
		contentPane.add(btn_1);
		
		btn_4 = new JButton("4");
		btn_4.setBounds(339, 85, 58, 23);
		contentPane.add(btn_4);
		
		btn_7 = new JButton("7");
		btn_7.setBounds(339, 119, 58, 23);
		contentPane.add(btn_7);
		
		btn_2 = new JButton("2");
		btn_2.setBounds(407, 51, 58, 23);
		contentPane.add(btn_2);
		
		btn_5 = new JButton("5");
		btn_5.setBounds(407, 85, 58, 23);
		contentPane.add(btn_5);
		
		btn_8 = new JButton("8");
		btn_8.setBounds(407, 119, 58, 23);
		contentPane.add(btn_8);
		
		btn_0 = new JButton("0");
		btn_0.setBounds(407, 153, 58, 23);
		contentPane.add(btn_0);
		
		btn_3 = new JButton("3");
		btn_3.setBounds(475, 51, 58, 23);
		contentPane.add(btn_3);
		
		btn_6 = new JButton("6");
		btn_6.setBounds(475, 85, 58, 23);
		contentPane.add(btn_6);
		
		btn_9 = new JButton("9");
		btn_9.setBounds(475, 119, 58, 23);
		contentPane.add(btn_9);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(243, 166, 89, 23);
		contentPane.add(btnClear);
		
		btn1 = new JButton("1");
		btn1.setBounds(30, 51, 58, 23);
		contentPane.add(btn1);
		btn0.addActionListener(new AccionesPanel1());
		btn1.addActionListener(new AccionesPanel1());
		btn2.addActionListener(new AccionesPanel1());
		btn3.addActionListener(new AccionesPanel1());
		btn4.addActionListener(new AccionesPanel1());
		btn5.addActionListener(new AccionesPanel1());
		btn6.addActionListener(new AccionesPanel1());
		btn7.addActionListener(new AccionesPanel1());
		btn8.addActionListener(new AccionesPanel1());
		btn9.addActionListener(new AccionesPanel1());
		btnMas.addActionListener(new AccionesPanel1());
		btnMenos.addActionListener(new AccionesPanel1());
		btnClear.addActionListener(new AccionesPanel1());
		btn_0.addActionListener(new AccionesPanel2());
		btn_1.addActionListener(new AccionesPanel2());
		btn_2.addActionListener(new AccionesPanel2());
		btn_3.addActionListener(new AccionesPanel2());
		btn_4.addActionListener(new AccionesPanel2());
		btn_5.addActionListener(new AccionesPanel2());
		btn_6.addActionListener(new AccionesPanel2());
		btn_7.addActionListener(new AccionesPanel2());
		btn_8.addActionListener(new AccionesPanel2());
		btn_9.addActionListener(new AccionesPanel2());
		
		
		
		pnR0Num1.setBackground(Color.RED);
		pnR0Num1.setBounds(56, 215, 51, 10);
		contentPane.add(pnR0Num1);
		
		
		pnR5Num1.setBackground(Color.RED);
		pnR5Num1.setBounds(41, 226, 10, 51);
		contentPane.add(pnR5Num1);
		
		
		pnR6Num1.setBackground(Color.RED);
		pnR6Num1.setBounds(56, 279, 51, 10);
		contentPane.add(pnR6Num1);
		
		
		pnR1Num1.setBackground(Color.RED);
		pnR1Num1.setBounds(111, 226, 10, 51);
		contentPane.add(pnR1Num1);
		
		
		pnR2Num1.setBackground(Color.RED);
		pnR2Num1.setBounds(111, 289, 10, 51);
		contentPane.add(pnR2Num1);
		
		
		pnR4Num1.setBackground(Color.RED);
		pnR4Num1.setBounds(41, 289, 10, 51);
		contentPane.add(pnR4Num1);
		
		
		pnR3Num1.setBackground(Color.RED);
		pnR3Num1.setBounds(56, 340, 51, 10);
		contentPane.add(pnR3Num1);
		
		
		pnR3Num2.setBackground(Color.RED);
		pnR3Num2.setBounds(240, 340, 51, 10);
		contentPane.add(pnR3Num2);
		
		
		pnR2Num2.setBackground(Color.RED);
		pnR2Num2.setBounds(295, 289, 10, 51);
		contentPane.add(pnR2Num2);
		
		
		pnR4Num2.setBackground(Color.RED);
		pnR4Num2.setBounds(225, 289, 10, 51);
		contentPane.add(pnR4Num2);
		
		
		pnR6Num2.setBackground(Color.RED);
		pnR6Num2.setBounds(240, 279, 51, 10);
		contentPane.add(pnR6Num2);
		
		
		pnR5Num2.setBackground(Color.RED);
		pnR5Num2.setBounds(225, 226, 10, 51);
		contentPane.add(pnR5Num2);
		
		
		pnR1Num2.setBackground(Color.RED);
		pnR1Num2.setBounds(295, 226, 10, 51);
		contentPane.add(pnR1Num2);
		
		
		pnR0Num2.setBackground(Color.RED);
		pnR0Num2.setBounds(240, 215, 51, 10);
		contentPane.add(pnR0Num2);
		
		
		pnR3Num3.setBackground(Color.RED);
		pnR3Num3.setBounds(400, 340, 51, 10);
		contentPane.add(pnR3Num3);
		
		
		pnR2Num3.setBackground(Color.RED);
		pnR2Num3.setBounds(455, 289, 10, 51);
		contentPane.add(pnR2Num3);
		
		
		pnR4Num3.setBackground(Color.RED);
		pnR4Num3.setBounds(385, 289, 10, 51);
		contentPane.add(pnR4Num3);
		
		
		pnR6Num3.setBackground(Color.RED);
		pnR6Num3.setBounds(400, 279, 51, 10);
		contentPane.add(pnR6Num3);
		
		
		pnR5Num3.setBackground(Color.RED);
		pnR5Num3.setBounds(385, 226, 10, 51);
		contentPane.add(pnR5Num3);
		
		
		pnR1Num3.setBackground(Color.RED);
		pnR1Num3.setBounds(455, 226, 10, 51);
		contentPane.add(pnR1Num3);
		
		
		pnR0Num3.setBackground(Color.RED);
		pnR0Num3.setBounds(400, 215, 51, 10);
		contentPane.add(pnR0Num3);
		
		
		pnR5Num4.setBackground(Color.RED);
		pnR5Num4.setBounds(491, 226, 10, 51);
		contentPane.add(pnR5Num4);
		
		
		pnR4Num4.setBackground(Color.RED);
		pnR4Num4.setBounds(491, 289, 10, 51);
		contentPane.add(pnR4Num4);
		
		
		pnR3Num4.setBackground(Color.RED);
		pnR3Num4.setBounds(506, 340, 51, 10);
		contentPane.add(pnR3Num4);
		
		
		pnR2Num4.setBackground(Color.RED);
		pnR2Num4.setBounds(561, 289, 10, 51);
		contentPane.add(pnR2Num4);
		
		
		pnR6Num4.setBackground(Color.RED);
		pnR6Num4.setBounds(506, 279, 51, 10);
		contentPane.add(pnR6Num4);
		
		
		pnR1Num4.setBackground(Color.RED);
		pnR1Num4.setBounds(561, 226, 10, 51);
		contentPane.add(pnR1Num4);
		
		
		pnR0Num4.setBackground(Color.RED);
		pnR0Num4.setBounds(506, 215, 51, 10);
		contentPane.add(pnR0Num4);
		pnOperator.setBackground(Color.LIGHT_GRAY);
		pnOperator.setBounds(147, 279, 51, 10);
		
		contentPane.add(pnOperator);
		pnOperador2.setBackground(Color.LIGHT_GRAY);
		pnOperador2.setBounds(166, 261, 10, 51);
		
		contentPane.add(pnOperador2);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(322, 261, 51, 10);
		
		contentPane.add(panel_1);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(322, 302, 51, 10);
		
		contentPane.add(panel_2);
		
		
	}
	private void initOperation(Boolean a,Boolean b){
		pnOperator.setVisible(a);
		pnOperador2.setVisible(b);
	}
	private void initNumber1() {
		
		pnR0Num1.setVisible(false);
		pnR1Num1.setVisible(false);
		pnR2Num1.setVisible(false);
		pnR3Num1.setVisible(false);
		pnR4Num1.setVisible(false);
		pnR5Num1.setVisible(false);
		pnR6Num1.setVisible(false);
	
	}
	private void initNumber2() {
		
		
		pnR0Num2.setVisible(false);
		pnR1Num2.setVisible(false);
		pnR2Num2.setVisible(false);
		pnR3Num2.setVisible(false);
		pnR4Num2.setVisible(false);
		pnR5Num2.setVisible(false);
		pnR6Num2.setVisible(false);
		pnR0Num3.setVisible(false);
		pnR1Num3.setVisible(false);
		pnR2Num3.setVisible(false);
		pnR3Num3.setVisible(false);
		pnR4Num3.setVisible(false);
		pnR5Num3.setVisible(false);
		pnR6Num3.setVisible(false);
	}
	private void initNumber3() {
	
		pnR0Num3.setVisible(false);
		pnR1Num3.setVisible(false);
		pnR2Num3.setVisible(false);
		pnR3Num3.setVisible(false);
		pnR4Num3.setVisible(false);
		pnR5Num3.setVisible(false);
		pnR6Num3.setVisible(false);
	}
	private void initNumber4() {
		
		pnR0Num4.setVisible(false);
		pnR1Num4.setVisible(false);
		pnR2Num4.setVisible(false);
		pnR3Num4.setVisible(false);
		pnR4Num4.setVisible(false);
		pnR5Num4.setVisible(false);
		pnR6Num4.setVisible(false);
	}
	public void loadNumber1(Boolean a,Boolean b,Boolean c,Boolean d) {
		initNumber1();
		Boolean[] data = asd.BinaryConvertDecimal(a, b, c, d);
		pnR0Num1.setVisible(data[0]);
		pnR1Num1.setVisible(data[1]);
		pnR2Num1.setVisible(data[2]);
		pnR3Num1.setVisible(data[3]);
		pnR4Num1.setVisible(data[4]);
		pnR5Num1.setVisible(data[5]);
		pnR6Num1.setVisible(data[6]);
		
	}
	public void loadNumber2(Boolean a,Boolean b,Boolean c,Boolean d) {
		initNumber2();
		Boolean[] data = asd.BinaryConvertDecimal(a, b, c, d);
		pnR0Num2.setVisible(data[0]);
		pnR1Num2.setVisible(data[1]);
		pnR2Num2.setVisible(data[2]);
		pnR3Num2.setVisible(data[3]);
		pnR4Num2.setVisible(data[4]);
		pnR5Num2.setVisible(data[5]);
		pnR6Num2.setVisible(data[6]);
		
	}
	public void loadNumber3(Boolean a,Boolean b,Boolean c,Boolean d) {
		initNumber3();
		Boolean[] data = asd.BinaryConvertDecimal(a, b, c, d);
		pnR0Num3.setVisible(data[0]);
		pnR1Num3.setVisible(data[1]);
		pnR2Num3.setVisible(data[2]);
		pnR3Num3.setVisible(data[3]);
		pnR4Num3.setVisible(data[4]);
		pnR5Num3.setVisible(data[5]);
		pnR6Num3.setVisible(data[6]);
		
	}
	public void loadNumber4(Boolean a,Boolean b,Boolean c,Boolean d) {
		initNumber4();
		Boolean[] data = asd.BinaryConvertDecimal(a, b, c, d);
		pnR0Num4.setVisible(data[0]);
		pnR1Num4.setVisible(data[1]);
		pnR2Num4.setVisible(data[2]);
		pnR3Num4.setVisible(data[3]);
		pnR4Num4.setVisible(data[4]);
		pnR5Num4.setVisible(data[5]);
		pnR6Num4.setVisible(data[6]);
		loadNumber3(false, false, false, data[7]);
		
	}
	private class AccionesPanel1 implements ActionListener{ //maneja las acciones de los botones y menuitems de la ventana
		public void actionPerformed(ActionEvent capturador) {//captura los objetos en accion
			if(capturador.getSource()==btn0){
				primerOperando = cero;
			}
			if(capturador.getSource()==btn1){
				primerOperando = uno;
			}
			if(capturador.getSource()==btn2){
				primerOperando = dos;
			}
			if(capturador.getSource()==btn3){
				primerOperando = tres;
			}
			if(capturador.getSource()==btn4){
				primerOperando = cuatro;
			}
			if(capturador.getSource()==btn5){
				primerOperando = cinco;
			}
			if(capturador.getSource()==btn6){
				primerOperando = seis;
			}
			if(capturador.getSource()==btn7){
				primerOperando = siete;
			}
			if(capturador.getSource()==btn8){
				primerOperando = ocho;
			}
			if(capturador.getSource()==btn9){
				primerOperando = nueve;
			}
			if(capturador.getSource()==btnMas){
				senalOperacion = false;
				initOperation(true, true);
				return;
			}
			if(capturador.getSource()==btnMenos){
				senalOperacion = true;
				initOperation(true, false);
				return;
			}
			if(capturador.getSource()==btnClear){
				initNumber1();
				initNumber2();
				initNumber3();
				initNumber4();
				primerOperando = cero;
				segundoOperando = cero;
				return;
			}
			loadNumber1(primerOperando[0], primerOperando[1], primerOperando[2], primerOperando[3]);
		}
	}
		private class AccionesPanel2 implements ActionListener{ //maneja las acciones de los botones y menuitems de la ventana
			public void actionPerformed(ActionEvent capturador) {//captura los objetos en accion
				if(capturador.getSource()==btn_0){
					segundoOperando = cero;
					System.out.print("Golation");
				}
				if(capturador.getSource()==btn_1){
					segundoOperando = uno;
				}
				if(capturador.getSource()==btn_2){
					segundoOperando = dos;
				}
				if(capturador.getSource()==btn_3){
					segundoOperando = tres;
				}
				if(capturador.getSource()==btn_4){
					segundoOperando = cuatro;
				}
				if(capturador.getSource()==btn_5){
					segundoOperando = cinco;
				}
				if(capturador.getSource()==btn_6){
					segundoOperando = seis;
				}
				if(capturador.getSource()==btn_7){
					segundoOperando = siete;
				}
				if(capturador.getSource()==btn_8){
					segundoOperando = ocho;
				}
				if(capturador.getSource()==btn_9){
					segundoOperando = nueve;
				}
				loadNumber2(segundoOperando[0], segundoOperando[1], segundoOperando[2], segundoOperando[3]);
				ArrayList<Boolean> listaRespuesta = asd.Alu(primerOperando[0], primerOperando[1], primerOperando[2], primerOperando[3], senalOperacion, segundoOperando[0], segundoOperando[1], segundoOperando[2], segundoOperando[3]);
				loadNumber4(listaRespuesta.get(3), listaRespuesta.get(2), listaRespuesta.get(1), listaRespuesta.get(0));
			}
		}
}

