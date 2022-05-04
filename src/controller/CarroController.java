/**
 * Classe CarroController respons�vel por receber atributos da classe principal
 * e passa-los � classe que cont�m as Threads, al�m de execut�-las
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
	 * @param delorean � a label contendo o ve�culo delorean que disputar� a corrida
	 * @param ecto � a label contendo o ve�culo ecto-1 que disputar� a corrida
	 * @param btnIniciar � o bot�o respons�vel por iniciar a corrida
	 * @param delorean_nome � a label com o nome do delorean
	 * @param ecto_nome � a label com o nome do delorean
	 */
	public CarroController(JLabel delorean, JLabel ecto, JButton btnIniciar) {
		this.jose = delorean;
		this.clauss = ecto;
		this.btnIniciar = btnIniciar;
	}
	
	/**
	 * M�todo que chama o m�todo executa
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		jose.setBounds(-180, 235, 328, 180);
		clauss.setBounds(-225, 315, 328, 180);
		
		executa();
	}
	
	/**
	 * M�todo que cria objetos da classe ThreadCarro, passando par�mtros a ela e executa as threads
	 */
	public void executa() {
		int podio = 0;
		ThreadCarro tjose = new ThreadCarro(jose, btnIniciar, podio);
		ThreadCarro tclauss = new ThreadCarro(clauss, btnIniciar, podio);
		
		tjose.start();
		tclauss.start();
	}
}
