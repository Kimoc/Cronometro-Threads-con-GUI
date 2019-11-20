
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazCrono extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCrono frame = new InterfazCrono();
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
	public InterfazCrono() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//START inizia los trheads que haran de contadores 
		/*
		 * 
		 *   Hilo 1 == contador milisegundos
		 *   Hilo 2 == contador segundos
		 *   Hilo 3 == contador minutos
		 * 
		 * 
		 * */
		
		JLabel minutosLabel = new JLabel("00");
		minutosLabel.setFont(new Font("Courier 10 Pitch", Font.BOLD, 70));
		minutosLabel.setBounds(50, 67, 103, 65);
		contentPane.add(minutosLabel);
		
		JLabel segundosLabel = new JLabel("00");
		segundosLabel.setFont(new Font("Courier 10 Pitch", Font.BOLD, 70));
		segundosLabel.setBounds(165, 67, 103, 65);
		contentPane.add(segundosLabel);
		
		JLabel miliSegundosLabel = new JLabel("000");
		miliSegundosLabel.setFont(new Font("Courier 10 Pitch", Font.BOLD, 70));
		miliSegundosLabel.setBounds(291, 67, 201, 65);
		contentPane.add(miliSegundosLabel);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Bitstream Charter", Font.BOLD, 70));
		label_3.setBounds(139, 66, 66, 55);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Bitstream Charter", Font.BOLD, 70));
		label_4.setBounds(263, 66, 66, 55);
		contentPane.add(label_4);
		
		JLabel Hilo3 = new JLabel("HILO 3");
		Hilo3.setBounds(59, 30, 66, 25);
		contentPane.add(Hilo3);
		
		JLabel Hilo2 = new JLabel("HILO 2");
		Hilo2.setBounds(165, 30, 66, 25);
		contentPane.add(Hilo2);
		
		JLabel Hilo1 = new JLabel("HILO 1");
		
		
		//STOP BUTTON
		JButton btnStop = new JButton("Stop");
		
		btnStop.setBounds(291, 183, 114, 25);
		contentPane.add(btnStop);
		
		
		//START BUTTON 
		Hilo1.setBounds(318, 30, 66, 25);
		contentPane.add(Hilo1);
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creamos e Iniziamos Hilos del cronometro
				HiloMiliSegundos milisegundosHilo=new HiloMiliSegundos(miliSegundosLabel);
				milisegundosHilo.start();
				HiloSegundos segundosHilo=new HiloSegundos(segundosLabel);
				segundosHilo.start();
				HiloMinutos minutosHilo=new HiloMinutos(minutosLabel);
				minutosHilo.start();
				
				
				
				
				//SI APRETAMOS STOP SE INTERRUMPEN LOS THREADS
				btnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						milisegundosHilo.stop();
						segundosHilo.stop();
						minutosHilo.stop();
					}
				});
				
			}
		});
		btnStart.setBounds(50, 183, 114, 25);
		contentPane.add(btnStart);
		
		
		
		
	}
}

