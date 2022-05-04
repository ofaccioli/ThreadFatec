/**
 * Classe CarroController responsável por receber atributos da classe principal
 * e passa-los à classe que contém as Threads, além de executá-las
 * @author Augusto Luiz Silva
 * @date 20/03/18
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroController implements ActionListener{
	private JLabel jose;
	private JLabel clauss;
	private JButton btnIniciar;
	
	/**
	 * Construtor
	 * @param delorean é a label contendo o veículo delorean que disputará a corrida
	 * @param ecto é a label contendo o veículo ecto-1 que disputará a corrida
	 * @param btnIniciar é o botão responsável por iniciar a corrida
	 * @param delorean_nome é a label com o nome do delorean
	 * @param ecto_nome é a label com o nome do delorean
	 */
	public CarroController(JLabel delorean, JLabel ecto, JButton btnIniciar) {
		this.jose = delorean;
		this.clauss = ecto;
		this.btnIniciar = btnIniciar;
	}
	
	/**
	 * Método que chama o método executa
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		jose.setBounds(-180, 235, 328, 180);
		clauss.setBounds(-225, 315, 328, 180);
		
		executa();
	}
	
	/**
	 * Método que cria objetos da classe ThreadCarro, passando parâmtros a ela e executa as threads
	 */
	public void executa() {
		int podio = 0;
		ThreadCarro tjose = new ThreadCarro(jose, btnIniciar, podio);
		ThreadCarro tclauss = new ThreadCarro(clauss, btnIniciar, podio);
		
		tjose.start();
		tclauss.start();
	}
}
