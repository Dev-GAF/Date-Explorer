package menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import calendario.Data;

import java.io.IOException;
//import java.io.*;

public class Menu {
    
    private BufferedReader entrada;
    private Data data;

    public Menu (Data data) 
    {
        this.data    = data;
        this.entrada = new BufferedReader(new InputStreamReader(System.in));
    } 

    public void exibirMenu () 
    {
        try
		{
			while(true) 
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

				byte opcao = Byte.parseByte(entrada.readLine());

				if(opcao==0)
					break;
				
				switch(opcao) 
                {
					case 1:
						

					case 2:
						
						
					case 3:
                        

					case 4:
						

					case 5:
						

					case 6:
						
						
						break;

					case 7:
						

					case 8:
						

					default:
						System.err.println("Opção inválida!");
						break;
				}
			}
		} catch (IOException e)
		{}	
		catch (NumberFormatException e) 
		{
			System.err.println("ERRO! Digite valores inteiros válidos!");
		} 
		catch (Exception e) 
		{
			System.err.println("Erro inesperado: "+ e.getMessage());
		}
    }
}
