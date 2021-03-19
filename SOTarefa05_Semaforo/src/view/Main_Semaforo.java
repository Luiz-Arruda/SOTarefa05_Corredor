package view;

import java.util.concurrent.Semaphore;

import controller.Semaforo;

public class Main_Semaforo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissao = 1;
		String sentido = " ";
		
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int idt = 0; idt < 4; idt ++) {
			if (idt == 1) {
				sentido = "Norte - Sul";
			}
			else if (idt == 2) {
				sentido = "Leste - Oeste";
			}
			else if (idt == 3) {
				sentido = "Sul - Norte";
			}
			else {
				sentido = "Oeste - Leste";
			}
			Thread IDT = new Semaforo(idt, sentido, semaforo);
			IDT.start();
		}
	} // maim
} // classe
