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
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (button.getModel().isPressed())
					primerOperando = uno;
			}
		});
		button.setBounds(30, 51, 58, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_1.getModel().isPressed())
					primerOperando = cuatro;
			}
		});
		button_1.setBounds(30, 85, 58, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("7");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_2.getModel().isPressed())
					primerOperando = siete;
			}
		});
		button_2.setBounds(30, 119, 58, 23);
		contentPane.add(button_2);
		
		JButton button_4 = new JButton("2");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_4.getModel().isPressed())
					primerOperando = dos;
			}
		});
		button_4.setBounds(98, 51, 58, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_5.getModel().isPressed())
					primerOperando = cinco;
			}
		});
		button_5.setBounds(98, 85, 58, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_6.getModel().isPressed())
					primerOperando = ocho;
			}
		});
		button_6.setBounds(98, 119, 58, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("0");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_7.getModel().isPressed())
					primerOperando = cero;
			}
		});
		button_7.setBounds(98, 153, 58, 23);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("3");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_8.getModel().isPressed())
					primerOperando = tres;
			}
		});
		button_8.setBounds(166, 51, 58, 23);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("6");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_9.getModel().isPressed())
					primerOperando = seis;
			}
		});
		button_9.setBounds(166, 85, 58, 23);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("9");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_10.getModel().isPressed())
					primerOperando = nueve;
			}
		});
		button_10.setBounds(166, 119, 58, 23);
		contentPane.add(button_10);
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_3.getModel().isPressed())
					senalOperacion = false;
			}
		});
		button_3.setBounds(264, 64, 41, 31);
		contentPane.add(button_3);
		
		JButton button_11 = new JButton("-");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_11.getModel().isPressed())
					senalOperacion = true;
			}
		});
		button_11.setBounds(264, 111, 41, 31);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("1");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_12.getModel().isPressed())
					segundoOperando = uno;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);
				
			}
		});
		button_12.setBounds(339, 51, 58, 23);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("4");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_13.getModel().isPressed())
					segundoOperando = cuatro;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);
			}
		});
		button_13.setBounds(339, 85, 58, 23);
		contentPane.add(button_13);
		
		JButton button_14 = new JButton("7");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_14.getModel().isPressed())
					segundoOperando = siete;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);
			}
		});
		button_14.setBounds(339, 119, 58, 23);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("2");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_15.getModel().isPressed())
					segundoOperando = dos;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);

			}
		});
		button_15.setBounds(407, 51, 58, 23);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("5");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_16.getModel().isPressed())
					segundoOperando = cinco;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);

			}
		});
		button_16.setBounds(407, 85, 58, 23);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("8");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_17.getModel().isPressed())
					segundoOperando = ocho;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);

			}
		});
		button_17.setBounds(407, 119, 58, 23);
		contentPane.add(button_17);
		
		JButton button_18 = new JButton("0");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_18.getModel().isPressed())
					segundoOperando = cero;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);

			}
		});
		button_18.setBounds(407, 153, 58, 23);
		contentPane.add(button_18);
		
		JButton button_19 = new JButton("3");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_19.getModel().isPressed())
					segundoOperando = tres;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);

			}
		});
		button_19.setBounds(475, 51, 58, 23);
		contentPane.add(button_19);
		
		JButton button_20 = new JButton("6");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_20.getModel().isPressed())
					segundoOperando = seis;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);

			}
		});
		button_20.setBounds(475, 85, 58, 23);
		contentPane.add(button_20);
		
		JButton button_21 = new JButton("9");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_21.getModel().isPressed())
					segundoOperando = nueve;
				asd.Alu(primerOperando[0],primerOperando[1],primerOperando[2],primerOperando[3],senalOperacion,segundoOperando[0],segundoOperando[1],segundoOperando[2],segundoOperando[3]);

			}
		});
		button_21.setBounds(475, 119, 58, 23);
		contentPane.add(button_21);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(239, 165, 89, 23);
		contentPane.add(btnClear);
		
		
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
		
		loadNumber1(false, false, false, true);
		loadNumber2(false, true, false, false);
		loadNumber4(true, true, false, false);
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
}
