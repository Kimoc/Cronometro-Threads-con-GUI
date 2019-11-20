
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//START inizia los trheads que haran de contadores 
		/*
		 * 
		 *   Hilo 1 == contador segundos
		 *   Hilo 2 == contador minutos
		 *   Hilo 3 == contador horas
		 * 
		 * 
		 * */
		
		
		
		
		JLabel Horas = new JLabel("00");
		Horas.setFont(new Font("Courier 10 Pitch", Font.BOLD, 70));
		Horas.setBounds(50, 67, 103, 65);
		contentPane.add(Horas);
		
		JLabel Minutos = new JLabel("00");
		Minutos.setFont(new Font("Courier 10 Pitch", Font.BOLD, 70));
		Minutos.setBounds(165, 67, 103, 65);
		contentPane.add(Minutos);
		
		JLabel Segundos = new JLabel("00");
		Segundos.setFont(new Font("Courier 10 Pitch", Font.BOLD, 70));
		Segundos.setBounds(291, 67, 103, 65);
		contentPane.add(Segundos);
		
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
		
		btnStop.setBounds(271, 183, 114, 25);
		contentPane.add(btnStop);
		
		
		//START BUTTON 
		Hilo1.setBounds(291, 30, 66, 25);
		contentPane.add(Hilo1);
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creamos Iniziamos Hilos del cronometro
				HiloSegundos segundosHilo=new HiloSegundos(Segundos);
				segundosHilo.start();
				HiloMinutos minutosHilo=new HiloMinutos(Minutos);
				minutosHilo.start();
				
				
				
				
				//SI APRETAMOS STOP SE INTERRUMPEN LOS THREADS
				btnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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

