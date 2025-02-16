package programa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		byte opcao;
		do 
		{
			try
			{
				System.out.println("\nEscolha uma opção:");
				System.out.println("(1) - Avançar um dia");
				System.out.println("(2) - Avançar vários dias");
				System.out.println("(3) - Retroceder um dia");
				System.out.println("(4) - Retroceder vários dias");
				System.out.println("(5) - Obter o dia seguinte");
				System.out.println("(6) - Obter vários dias adiante");
				System.out.println("(7) - Obter o dia anterior");
				System.out.println("(8) - Obter vários dias atrás");
				System.out.println("(0) - Sair");
				System.out.print("\nDigite uma opção: ");
				opcao = Byte.parseByte(entrada.readLine());

			}
			catch (IOException erro)
			{
				opcao=9;
			} // Sei que não vai dar esse erro
			catch (NumberFormatException erro) 
			{
				System.err.println("\nByte inserido inválido!");
				opcao=9;
			}

			try
			{
				switch (opcao) 
				{
					case 1:
						break;

					case 2:
						break;
						
					case 3:
						break;

					case 4:
						break;

					case 5:
						break;

					case 6:
						break;

					case 7:
						break;

					case 8:
						break;

					default:
						System.err.println("Opção inválida! Tente novamente...");
				}
			
			}
			catch (Exception erro) 
			{
				System.err.println("Erro inesperado: "+ erro.getMessage());
			}	
		} 
		while(opcao!=0);
	}
}


