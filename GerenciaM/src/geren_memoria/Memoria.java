package geren_memoria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Memoria {
	
	static char [] Vmemoria =  new char[30]; //memoria (vetor com 30 espaços)
	Processo[] processos; //vetor de processos
	private int max_process = 5;
	private char dado;
	private int contador_escrita;
	private int contador_leitura;
	private String ARQUIVO = "processos.txt"; //arquivo com espaço de memoria que cada processo ira ultilizar
	private char[] letra_proc;
	int registrador_base = 0;
	int registrador_limite = 0;
	
	
	
	public int getContador_escrita() {
		return contador_escrita;
	}

	public void setContador_escrita(int contador_escrita) {
		this.contador_escrita = contador_escrita;
	}

	public int getContador_leitura() {
		return contador_leitura;
	}

	public void setContador_leitura(int contador_leitura) {
		this.contador_leitura = contador_leitura;
	}

	
	public char getDado() {
		return dado;
	}

	public void setDado(char dado) {
		this.dado = dado;
	}

	
	public Memoria() {
		processos = new Processo[Vmemoria.length];
	}
	

	
	//metodo que ler todo o vetor de memoria 
	public void ler_array() {
		int c = 0;
		System.out.println("");
		System.out.println("---------");
		System.out.println("Endereço | Conteudo");
		for(char a: Vmemoria) {
			String b = String.valueOf(a);
			c++;
			System.out.println(c + "       ->       " + b);
			
			
		}
		System.out.println("");
		System.out.println("---------");
	
	}
	
	//metodo ler o arquivo 
	public void lerarquivo() throws IOException {
		Path path = Paths.get(ARQUIVO); //pega o arquivo 
		//System.out.println(path);
        //carrega o conteudo de ARQUIVO em um ArrayList
        List <String> texto = new ArrayList<>();
                
        try {
        	
            texto = Files.readAllLines(path, StandardCharsets.UTF_8); //ler todo o arquivo e guarda em um "Array"
           // System.out.println(texto);
        }catch(IOException e) {
        	System.out.println(e.getMessage());
        }
        int i = 0;
        int enderecoAtual = 0;
        int limite=0;
        
        //loop  para inicializar os vetores com endereco atual  o limite 
        while(i < texto.size() && i < max_process && limite < Vmemoria.length) {
        	
        	limite = enderecoAtual + Integer.parseInt(texto.get(i)) -1;  
        	
        	if(limite <= Vmemoria.length) {
        		//inicializa um novo processo e passa seus parametros 
        		processos[i] = new Processo(enderecoAtual,limite);
        		enderecoAtual = limite + 1;
        		i++;
        	}else {
        		String msg = "Limite de memoria alcançado no processo: " + (char)(i+65);
        		System.out.println(msg);
        		System.out.println("");
        		System.out.println("---------");
        	}
        	
        }
        	//lista os Processos e adiciona em um Array
        	letra_proc = new char[i];
        	System.out.println("");
			for(int j = 0; j < i ; j++) {
				System.out.println("Processo " + (char)(j+65));
				letra_proc[j] = (char)(j+65);
				
			}
			System.out.println("");
			System.out.println("---------");
	}
	
	
	public void gravar() {
		
		Scanner scan = new Scanner(System.in);
		int i = 0;
		System.out.println("");
		System.out.println("---------");
		System.out.println("Digite a Letra do Processo:");
		char processo_selecionado = scan.next().charAt(0);
		char n_processo_selec = Character.toUpperCase(processo_selecionado);
		System.out.println("Processo Selecionado: " + n_processo_selec);
		
		
		System.out.println("Digite o Endereço:");
		int endereco_logico = scan.nextInt();
		//System.out.println(n_processo_selec);
		
		
		//procura por um letra do processo igual a digitada e retorna os valores da base e limite
		for(i = 0 ; i < letra_proc.length;i++  ) {
			
		
			if(n_processo_selec == letra_proc[i]) {
				
				//System.out.println("i " + i);
				registrador_base = processos[i].getEnd_base();
				registrador_limite = processos[i].getEnd_limite();	
				System.out.println("Registrador base " + registrador_base);
				System.out.println("Registrador limite " + registrador_limite);
			}
			
		}
		
		
		
		int endereco_fisico = endereco_logico  + registrador_base;
		
		//System.out.println(endereco_fisico);
		//System.out.println("base " + registrador_base);
		
		//adiciona ao vetor da memoria o valor 
		if(endereco_fisico <  registrador_limite) {
			System.out.println("");
			System.out.println("---------");
			System.out.println("Digite o valor:");
			Vmemoria[endereco_fisico] = scan.next().charAt(0);
			
		}else {
			String msg = "O processo " + (char)(i+65-1) + " executou uma operacao ilegal("+endereco_fisico+")";
			System.out.println(msg);
			System.out.println("");
			System.out.println("---------");
		}
		
		
		
		
	}
	
	
	
}
