/**
 * Classe principal do programa
 * @author Augusto Luiz Silva
 * @date 20/03/18
 */

package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CarroController;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 *É o método responsável por construir o JFrame, posicionando suas respectivas Labels e button 
	 */
	public Principal(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 860, 550);
		setResizable(false);
		
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(painel);
		painel.setLayout(null);
		JLabel fundo = new JLabel();
		fundo.setBounds(0, 0, 850, 550);
		fundo.setIcon(new ImageIcon("imagens/fundo.png"));
		
		JLabel clauss = new JLabel("");
		clauss.setBounds(-225, 315, 328, 180);
		clauss.setIcon(new ImageIcon("imagens/bonecoclauss1.png"));
		
		painel.add(clauss);
		
		JLabel jose = new JLabel("");
		jose.setBounds(-180, 235, 328, 180);
		jose.setIcon(new ImageIcon("imagens/bonecojose.png"));
		
		painel.add(jose);
		
		
		JLabel nomeBotao = new JLabel();
		nomeBotao.setIcon(new ImageIcon("imagens/start.png"));
		
		
		JButton btnIniciar = new JButton();
		btnIniciar.setBounds(20, 30, 125, 45);
		btnIniciar.setBackground(Color.white);
		btnIniciar.add(nomeBotao);
		
		painel.add(btnIniciar);
		
		painel.add(fundo);
		
		CarroController cc = new CarroController(jose, clauss, btnIniciar);
		
		btnIniciar.addActionListener(cc);
	}
}
