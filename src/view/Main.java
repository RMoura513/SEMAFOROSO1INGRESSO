package view;

import java.util.concurrent.Semaphore;

import controller.ControleShow;

public class Main {

	public static void main(String[] args) {
		
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int id = 1; id < 301; id++) {
			ControleShow controleshow = new ControleShow(id, semaforo);
			controleshow.start();

	}

}
}
