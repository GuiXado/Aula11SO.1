package controller;

import java.io.IOException;
import br.gui.pilhagenerica.*;
import br.gui.listagenerica.*;

public interface IFifaController {
	
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
	public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException;
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException;
	
}
