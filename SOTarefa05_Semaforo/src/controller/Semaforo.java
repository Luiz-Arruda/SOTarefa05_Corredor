package controller;

import java.util.concurrent.Semaphore;

public class Semaforo extends Thread {
	private int idThread;
	private Semaphore semaforo;
	private String sentido;
	
	public Semaforo(int idThread, String sentido, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
		this.sentido = sentido;
		
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			Controle();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();	
		}
	}
	
	public void Controle() {
		 
		System.out.println("Carro " + idThread + " movimentando no sentido: " + sentido);
		
	}
}
