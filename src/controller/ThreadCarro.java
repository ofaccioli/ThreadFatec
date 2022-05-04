/**
 * Classe ThreadCarro que herda todos os atributos e operações da classe Thread
 * Aqui encontra-se as Thread a serem executadas
 * @author Augusto Luiz Silva
 * @date 20/03/18
 */

package controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadCarro extends Thread{
	private JLabel carro;
	private JButton btnIniciar;
	private static int podio;
	
	/**
	 * Construtor
	 * @param carro é a label contendo o veículo que disputará a corrida
	 * @param btnIniciar é o botão responsável por iniciar a corrida
	 * @param nome é a label com o nome dos carros, sendo utilizada na classificação final
	 * @param pod variável auxiliar que é sempre passada como pod = 0 
	 * a fim de ajudar na lógica da classificação 
	 */
	
	public ThreadCarro(JLabel carro, JButton btnIniciar, int pod) {
		this.carro = carro;
		this.btnIniciar = btnIniciar;
		podio = pod;
	}

	/**
	 * método run que efetua achamada do método executa sem a passagem de parâmetros
	 */
	
	@Override
	public void run() {
		executa();
	}
	
	/**
	 * método que gera randomicamente o posicionamento da label até esta chegar a um ponto
	 * pré-determinado (linha de chegada) e consequentemente exibir a classificação
	 */
	
	private void executa() {
		btnIniciar.setVisible(false);;
		Random random = new Random();
		Rectangle posicao;
		
		posicao = carro.getBounds();
		carro.setBounds(posicao);
		
		
		while(posicao.x < 660) {
			try {
				Thread.sleep(5);
			}
			
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			posicao.x = posicao.x + random.nextInt(5);
			carro.setBounds(posicao);
		}
		
		btnIniciar.setVisible(true);
	}
}