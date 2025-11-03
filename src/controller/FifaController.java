package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import br.gui.listagenerica.Lista;
import br.gui.pilhagenerica.Pilha;

public class FifaController implements IFifaController {

	@Override
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		Pilha<String> pilha = new Pilha<>();
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader( leitor);
			String linha = buffer.readLine();
			while (linha != null ) {
				if (linha.toLowerCase().contains("brazil")) {
					pilha.push(linha);
					//System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException ("Arquivo Inválido");
		}
		return pilha;
	}

	@Override
	public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
		try {
		
			while (!pilha.isEmpty()) {
				String jogador = pilha.pop();
				String[] dados = jogador.split(",");
				System.out.printf("[Jogador: %-20s Overall: %s]%n", dados[2], dados[7]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
		Lista<String> lista = new Lista<>();
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader( leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null ) {
				String[] jogador = linha.split(",");
				int idade = Integer.parseInt(jogador[3]);
				if (idade <= 20) {
					try {
						lista.addLast(linha);
						//System.out.println(linha);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException ("Arquivo Inválido");
		}
		
		return lista;
	}

	@Override
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
		try {
			int tam = lista.size();
			for (int i = 0; i < tam; i++) {
				String jogador = lista.get(i);
				String[] dados = jogador.split(",");
				int overall = Integer.parseInt(dados[7]);
				if (overall > 80) {
					System.out.printf("[Jogador: %-20s Idade: %-10s Overall: %s]%n", dados[2], dados[3], dados[7]);
				}
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
