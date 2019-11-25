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

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
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
		
		textField = new JTextField();
		textField.setBounds(251, 223, 74, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblResultado = new JLabel("Result");
		lblResultado.setBounds(275, 198, 49, 14);
		contentPane.add(lblResultado);
		
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
		btnClear.setBounds(243, 273, 89, 23);
		contentPane.add(btnClear);
	}
	

}
