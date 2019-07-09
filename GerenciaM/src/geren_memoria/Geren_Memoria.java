/*
 * Gerenciador de Memoria -> base limite
 * Alunos:
 * 	Pedro Marinho
 * 	Luciano Alves
 * 	Matheus Gonçalves
 */
package geren_memoria;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


public class Geren_Memoria {

	Memoria m = new Memoria();
	Scanner scan = new Scanner(System.in);
	
	//metodo recursivo para sempreo programa ficar em loop ate o usuario 
	public String rmemory() throws IOException {
		
		System.out.println("");
		System.out.println("---------");
		System.out.println("Digite a opção desejada: ");
		System.out.println("1. Carregar  || 0. Sair ");
		int i = scan.nextInt();
		if(i == 0) {
			return "bye";
		}
		if(i == 1) {
			m.ler_array();
			m.lerarquivo();
			m.gravar();
		}
		else {
			return rmemory();
		}
		
		return rmemory();
	}
	
	
	
	public static void main(String[] args) throws IOException {

		
	
		
		Geren_Memoria gm = new Geren_Memoria();
		
		
		gm.rmemory();
		
		

		
	
		


	}


	
}
