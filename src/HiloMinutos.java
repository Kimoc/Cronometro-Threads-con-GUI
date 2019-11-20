import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;

public class HiloMinutos implements Runnable{
    Thread hilo2;
	JLabel labelMinutos;
	int contadorMinutos;
	private final AtomicBoolean running = new AtomicBoolean(false);//FLAG
	
	boolean ejecutar;
    public HiloMinutos(JLabel labelMin) {
    //	this.hilo2=new Thread(this,"HiloMinutos");
    	this.labelMinutos=labelMin;
    	this.contadorMinutos=0;
	}
    
    //PARA PARAR EL THREAD
    public void stop() {
        running.set(false);
    }
    //Genera nuevo hilo y lo inizia
    public void start() {
        hilo2 = new Thread(this);
        hilo2.start();
    }
	@Override
	public void run() {
		running.set(true);
		while(running.get()) {
		
				try {
					//Para que de 0 a 10 se imprima con 2 digitos
					if(contadorMinutos<10) {
						labelMinutos.setText("0"+String.valueOf(contadorMinutos++));
					}else{
						labelMinutos.setText(String.valueOf(contadorMinutos++));
					}
					//Para cada minuto
					Thread.sleep(60000);
					
					
				} catch (InterruptedException e) {
					//Cambiando el estado del flag desde el boton Stop obligamos que salte la expepcion
					//Y como esa excepcion ocurre en el mismo trhead actual podemos utilizar el metodo de interrupt().
					Thread.currentThread().interrupt();
					e.printStackTrace();
					
				}
				if(contadorMinutos>=60) {
					contadorMinutos=0;
				}
			
			
		}
	}

	
	
}

