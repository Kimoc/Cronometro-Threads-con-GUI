import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;

public class HiloSegundos implements Runnable{
    Thread hilo1;
	JLabel labelSegundos;
	int contadorSegundos;
	private final AtomicBoolean running = new AtomicBoolean(false);//FLAG
	
    public HiloSegundos(JLabel labelSegundos) {
    	//this.hilo1=new Thread(this,"HiloSegundos");
    	this.labelSegundos=labelSegundos;
    	this.contadorSegundos=0;
	}
    
    //PARA PARAR EL THREAD
    public void stop() {
        running.set(false);
    }
    //Genera nuevo hilo y lo inizia
    public void start() {
        hilo1 = new Thread(this);
        hilo1.start();
    }
	@Override
	public void run() {
		running.set(true);//flag
		while(running.get()) {
		
				try {
					//Para que de 0 a 10 se imprima con 2 digitos
					if(contadorSegundos<10) {
						labelSegundos.setText("0"+String.valueOf(contadorSegundos++));
					}else{
						labelSegundos.setText(String.valueOf(contadorSegundos++));
					}
					//Para cada Segundo
					Thread.sleep(1000);
					
					
				} catch (InterruptedException e) {
					//Cambiando el estado del flag desde el boton Stop obligamos que salte la expepcion
					//Y como esa excepcion ocurre en el mismo trhead podemos utilizar el metodo de interrupt().
					Thread.currentThread().interrupt();//interrumpimos el hilo
					e.printStackTrace();
					
				}
				if(contadorSegundos>=60) {
					contadorSegundos=0;
				}
			
			
		}
	}

	
	
	
}

