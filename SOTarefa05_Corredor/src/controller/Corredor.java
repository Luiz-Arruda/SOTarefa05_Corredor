package controller;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread{
		private int idThread;
		private Semaphore semaforo;
		private static int entrada;
		
		public Corredor(int idThread, Semaphore semaforo) {
			this.idThread = idThread;
			this.semaforo = semaforo;
		}
		
		@Override
		public void run() {
			CalCorredor();
			try {
				semaforo.acquire();
				CalPorta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}  // fim run
		
		public void CalCorredor() {
			int distancia = 200;
			int velocidade = 0;
			int tempo = 0;
			velocidade = (int) (Math.random() * 2 + 4);
			tempo = distancia / velocidade;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}  // fim metodo
		
		public void CalPorta() {
			int tempo = 0;
			while (tempo < 2000) {
				tempo = (int)(Math.random() * 1001 + 1000);
				tempo ++;			
			}
			entrada ++;
			System.out.println("Pessoa " + (idThread + 1) + " entrou " + entrada + " posiçáo");
		}  // fim metodo
}
