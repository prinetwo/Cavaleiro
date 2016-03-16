package controller;

import java.util.concurrent.Semaphore;

public class Cavaleiro extends Thread {

	private int ID;
	private static Object[] cavaleiro = new Cavaleiro[4];
	private static int i = 0;
	private static Corredor[] corredor = new Corredor[4];
	private int corre;
	private Semaphore semaforo;

	public Cavaleiro(int ID, Corredor[] corredor, Semaphore semaforo) {
		this.ID = ID;
		this.corredor = corredor;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		andando();
		andandoCorredor();
		
		try {
			semaforo.acquire();
			destino();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
	}

	public void andando() {
		int distMax = 500;
		int distPer = 0;

		while (distPer < distMax) {

			distPer += (int) (Math.random() * 24 + 22);
			System.out.println("O cavaleiro " + ID + " andou " + distPer + " mts");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		corre = i;
		i++;
		System.out.println("O cavaleiro " + ID + " chegou e est� pensando no que fazer... ");
	}

	public void andandoCorredor() {
		int distMax = 200;
		int distPerc = 0;
		int tunel = (corredor[corre].getID() + 1);
		
		System.out.println("O cavaleiro " + ID + " escolheu o corredor " + tunel );

		while (distPerc < distMax) {
			distPerc += (int) (Math.random() * 17 + 15);
			System.out.println("O cavaleiro " + ID + " andou " + distPerc + " mts no corredor "+tunel);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void destino() {
		try {
			Thread.sleep(corre * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(
				"\nFinalmente! O cavaleiro " + ID + " chegou ao final de seu corredor! O que o espera mais adiante?");

		if (corredor[corre].getConteudo().contains("Monstro")) {
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("UM TERR�VEL MONSTRO!");
			System.out.println("COM UMA BENGA DE 30 METROS!");
			System.out.println("Que pena! Tanto esfor�o s� para ser estrupado");
			System.out.println("\n\n\nMas ele gosta, � se gosta...");

		}else{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("UMA BELA DE UMA SA�DA CARALHUDA");
			System.out.println("PUTA MERDA, QUE DEL�CIA! AQUELES PUTOS QUE SE FODAM!");
		}
	}

}
