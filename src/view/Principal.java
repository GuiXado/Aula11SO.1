package view;

import br.gui.pilhagenerica.*;
import br.gui.listagenerica.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.FifaController;

public class Principal {

	public static void main (String[] args) {
		FifaController fifa = new FifaController();
		Pilha<String> pilha = new Pilha<>();
		Lista<String> lista = new Lista<>();
		
		String caminho = "C:\\temp";
		String nome = "data.csv";
		
		try {

			int opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Empilha Brasileiros\n"
					+ "2 - Lista Jovens com Pontuação Alta"));
			
			switch (opc) {
				case 1:
					pilha = fifa.empilhaBrasileiros(caminho, nome);
					fifa.desmpilhaBonsBrasileiros(pilha);
					break;
				case 2:
					lista = fifa.listaRevelacoes(caminho, nome);
					fifa.buscaListaBonsJovens(lista);
					break;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
