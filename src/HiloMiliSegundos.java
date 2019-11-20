import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;

public class HiloMiliSegundos implements Runnable{
    Thread hiloMilisegundos;
	JLabel labelMiliSegundos;
	int contadorMiliSegundos;
	private final AtomicBoolean running = new AtomicBoolean(false);//FLAG
	
	boolean ejecutar;
    public HiloMiliSegundos(JLabel labelSegundos) {
    	this.labelMiliSegundos=labelSegundos;
    	this.contadorMiliSegundos=0;
	}
    
    //PARA PARAR EL THREAD
    public void stop() {
        running.set(false);
    }
    //Genera nuevo hilo y lo inizia
    public void start() {
        hiloMilisegundos = new Thread(this);
        hiloMilisegundos.start();
    }
	@Override
	public void run() {
		running.set(true);
		while(running.get()) {
		
				try {
					
				    if(contadorMiliSegundos<100){
						labelMiliSegundos.setText("0"+String.valueOf((contadorMiliSegundos++)));
					}else {
						labelMiliSegundos.setText(String.valueOf((contadorMiliSegundos++)));
					}
					//Para cada milisegundo
					Thread.sleep(1);
					
					
				} catch (InterruptedException e) {
					//Cambiando el estado del flag desde el boton Stop obligamos que salte la expepcion
					//Y como esa excepcion ocurre en el mismo trhead actual podemos utilizar el metodo de interrupt().
					Thread.currentThread().interrupt();
					e.printStackTrace();
					
				}
				if(contadorMiliSegundos>=1000) {
					contadorMiliSegundos=0;
				}
			
			
		}
	}
	
	
	
}