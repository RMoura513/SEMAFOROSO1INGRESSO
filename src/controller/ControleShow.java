package controller;

import java.util.concurrent.Semaphore;



public class ControleShow extends Thread{
	
	private int id;
	private Semaphore semaforo;
	private static int ingressos = 100;

	
	
	
	public ControleShow (int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;


}
	
	
	@Override
	public void run() {
//    System.out.println(id);
		Login();
		Compra();
		
		try {
			semaforo.acquire();
			ValidaCompra();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
		
		
	}
	
	
	
	public void Login() {
		int tempo;
		
		tempo = (int) ((Math.random() * 1501) + 500);
		
		if(tempo >= 1000) {
			System.out.println("Comprador #" + id + ": Timeout");
			id = 0;
		}
		else {
			System.out.println("Comprador #" + id + ": Logado");
		}
		}
	
	public void Compra() {
		int tempo;
		
	tempo = (int) ((Math.random()* 2001 )+ 1000);
	
	if (id != 0) {
	
	if (tempo >= 2500) {
		System.out.println("Comprador #" + id + ": Tempo de sessão estourado");
		id = 0;
		
	}
	else {
		System.out.println("Comprador #" + id + ": Processando compra de ingresso");
	}
	}
	}
	
	public void ValidaCompra() {
		int qtdingresso;
		
		qtdingresso = (int) ((Math.random()* 4)+ 1);
		
		if (id != 0) {
		if (qtdingresso <= ingressos) {
			ingressos = ingressos - qtdingresso;
			System.out.println("========== Comprador #" + id + ": Comprou " + qtdingresso + " ingressos ==========");
			System.out.println("========== Quantidade de ingressos restantes: " + ingressos + " ==========");
		}
		}
		
		
	}
	
	
}
