package view;

import java.util.concurrent.Semaphore;

import controller.Cavaleiro;
import controller.Corredor;

public class Main {
	public static void main(String[] args) {
		Corredor corredor[] = new Corredor[4];
		int saida = (int)(Math.random() * 4 + 1);
		Semaphore semaforo = new Semaphore(1);
		for (int i = 0; i < 4; i ++){
			corredor[i] = new Corredor(i, ((i == saida)? "Saída":"Monstro"));
		}
		
		for (int i = 0; i < 4; i ++){
			Thread cavaleiro = new Cavaleiro(i, corredor, semaforo);
			cavaleiro.start();
		}
	}
}
