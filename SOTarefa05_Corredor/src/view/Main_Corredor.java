package view;

import java.util.concurrent.Semaphore;

import controller.Corredor;

public class Main_Corredor {

	public static void main(String[] args) {
		
		int permissoes = 1;
		
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idt =0; idt < 4; idt++) {
			Thread IDT = new Corredor(idt, semaforo);
			IDT.start();
		}
		
		
	} // main
} // classe
