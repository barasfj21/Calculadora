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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
		btnMas.setBounds(264, 64, 41, 31);
		contentPane.add(btnMas);
		
		btnMenos = new JButton("-");
		btnMenos.setBounds(264, 111, 41, 31);
		contentPane.add(btnMenos);
		
		textField = new JTextField();
		textField.setBounds(251, 223, 74, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblResultado = new JLabel("Result");
		lblResultado.setBounds(275, 198, 49, 14);
		contentPane.add(lblResultado);
		
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
		btnClear.setBounds(243, 273, 89, 23);
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
			}
			if(capturador.getSource()==btnMenos){
				senalOperacion = true;
			}
			if(capturador.getSource()==btnClear){
				
			}
		}	
	}
	private class AccionesPanel2 implements ActionListener{ //maneja las acciones de los botones y menuitems de la ventana
		public void actionPerformed(ActionEvent capturador) {//captura los objetos en accion
			if(capturador.getSource()==btn_0){
				segundoOperando = cero;
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
			asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);
		}
	}
}
