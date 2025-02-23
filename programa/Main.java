package programa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import calendario.Data;

public class Main 
{
    public static void main(String[] args) 
	{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Data data = null;

        String respostaFinalUsuario;
        do 
		{
            // Limpar o terminal
            try 
			{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
			catch (Exception erro) 
			{
                erro.printStackTrace();
            }

            System.out.println("==================================");
            System.out.println("\tMENU PRINCIPAL");
            System.out.println("==================================");

            while (data==null) 
			{
                try 
				{
                    System.out.print("Digite uma data no formato dd/mm/yyyy: ");
                    String dataInserida = entrada.readLine();

                    data = Data.transformarEmData(dataInserida);
                } 
				catch (Exception erro) 
				{
                    System.err.println("\nErro: " + erro.getMessage());
                }
            }

            System.out.println("==================================");
            System.out.println("(1) - Manipular esta Data");
            System.out.println("(2) - Ver qualquer Data");
            System.out.println("==================================");

            byte opcao;
            do
            {
                try 
                {
                    System.out.print("Digite uma opção: ");
                    opcao = Byte.parseByte(entrada.readLine());

                    if (opcao<1 || opcao>2)
                        System.err.println("Erro! Digite uma das opções válidas...\n");
                } 
                catch (IOException erro) 
                {
                    opcao = 9;  // Atribui um valor qualquer
                } 
                catch (NumberFormatException erro) 
                {
                    System.err.println("\nByte inserido inválido! Por favor, digite novamente...");
                    opcao = 9;
                }
            }
            while (opcao<1 || opcao>2);

            try 
			{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
			catch (Exception erro) 
			{
                erro.printStackTrace();
            }

            byte opcaoMenu;
            switch (opcao) 
			{
                case 1:
                    System.out.println("==================================");
                    System.out.println("\tData: " + data);
                    System.out.println("==================================");
                    System.out.println("\tEscolha uma opção:");
                    System.out.println("(1) - Avançar um dia");
                    System.out.println("(2) - Avançar vários dias");
                    System.out.println("(3) - Retroceder um dia");
                    System.out.println("(4) - Retroceder vários dias");
                    System.out.println("(0) - Sair");
                    System.out.println("==================================");

                    do
                    {
                        try 
                        {
                            System.out.print("Digite uma opção: ");
                            opcaoMenu = Byte.parseByte(entrada.readLine());

                            if (opcaoMenu<0 || opcaoMenu>4)
                                System.err.println("Erro! Digite uma das opções válidas...\n");
                        } 
                        catch (IOException erro) 
                        {
                            opcaoMenu = 9;  // Atribui um valor qualquer
                        } 
                        catch (NumberFormatException erro) 
                        {
                            System.err.println("\nByte inserido inválido! Por favor, digite novamente...");
                            opcaoMenu = 9;
                        }
                    }
                    while (opcaoMenu<0 || opcaoMenu>4);

                    switch (opcaoMenu) 
					{
                        case 0:
                            break;

                        case 1:
                            data.avanceUmDia();
                            System.out.println("\nData: " + data);
                            break;

                        case 2:
                            while (true)
                            {
                                try 
                                {
                                    System.out.print("Avançar quantos dias? ");
                                    int qtdDias = Integer.parseInt(entrada.readLine());

                                    data.avanceVariosDias(qtdDias);
                                    System.out.println("\nData: " + data);
                                    break;
                                } 
                                catch (IOException erro) 
                                {} 
                                catch (NumberFormatException erro) 
                                {
                                    System.err.println("\nint inserido inválido!");
                                } 
                                catch (Exception erro) 
                                {
                                    System.err.println(erro.getMessage());
                                }
                            }
                            break;

                        case 3:
                            data.retrocedaUmDia();
                            System.out.println("\nData: " + data);
                            break;

                        case 4:
                            while (true)
                            {
                                try 
                                {
                                    System.out.print("Retroceder quantos dias? ");
                                    int qtdDias = Integer.parseInt(entrada.readLine());

                                    data.retrocedaVariosDias(qtdDias);
                                    System.out.println("\nData: " + data);
                                    break;
                                } 
                                catch (IOException erro) 
                                {} 
                                catch (NumberFormatException erro) 
                                {
                                    System.err.println("\nint inserido inválido!");
                                } 
                                catch (Exception erro) 
                                {
                                    System.err.println(erro.getMessage());
                                }
                            }
                            break;

                        default:
                            System.err.println("Opção inválida! Tente novamente...");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("==================================");
                    System.out.println("\tData: " + data);
                    System.out.println("==================================");
                    System.out.println("\tEscolha uma opção:");
                    System.out.println("(1) - Obter o dia seguinte");
                    System.out.println("(2) - Obter vários dias adiante");
                    System.out.println("(3) - Obter o dia anterior");
                    System.out.println("(4) - Obter vários dias atrás");
                    System.out.println("(0) - Sair");
                    System.out.println("==================================");
                        
                    do
                    {
                        try 
                        {
                            System.out.print("Digite uma opção: ");
                            opcaoMenu = Byte.parseByte(entrada.readLine());

                            if (opcaoMenu<0 || opcaoMenu>4)
                                System.err.println("Erro! Digite uma das opções válidas...\n");
                        } 
                        catch (IOException erro) 
                        {
                            opcaoMenu = 9;  // Atribui um valor qualquer
                        } 
                        catch (NumberFormatException erro) 
                        {
                            System.err.println("\nByte inserido inválido! Por favor, digite novamente...");
                            opcaoMenu = 9;
                        }
                    }
                    while (opcaoMenu<0 || opcaoMenu>4);
                    
                    switch (opcaoMenu) 
					{
                        case 0:
                            break;

                        case 1:
                            System.out.println("\nData: " + data.getDiaSeguinte());
                            break;

                        case 2:
                            while (true)
                            {
                                try 
                                {
                                    System.out.print("Avançar quantos dias? ");
                                    int qtdDias = Integer.parseInt(entrada.readLine());

                                    System.out.println("\nData: " + data.getVariosDiasAdiante(qtdDias));
                                    break;
                                } 
                                catch (IOException erro) 
                                {} 
                                catch (NumberFormatException erro) 
                                {
                                    System.err.println("\nint inserido inválido!");
                                } 
                                catch (Exception erro) 
                                {
                                    System.err.println(erro.getMessage());
                                }
                            }
                            break;

                        case 3:
                            System.out.println("\nData: " + data.getDiaAnterior());
                            break;

                        case 4:
                            while (true)
                            {
                                try 
                                {
                                    System.out.print("Retroceder quantos dias? ");
                                    int qtdDias = Integer.parseInt(entrada.readLine());

                                    System.out.println("\nData: " + data.getVariosDiasAtras(qtdDias));
                                    break;
                                } 
                                catch (IOException erro) 
                                {} 
                                catch (NumberFormatException erro) 
                                {
                                    System.err.println("\nint inserido inválido!");
                                } 
                                catch (Exception erro) 
                                {
                                    System.err.println(erro.getMessage());
                                }
                            }
                            break;

                        default:
                            System.err.println("Opção inválida! Tente novamente...");
                            break;
                    }
                    break;

                default:
                    System.err.println("Opção inválida! Tente novamente...");
                    break;
            }

            // Tratando a leitura da resposta final corretamente
            try 
			{
                System.out.print("Deseja encerrar o Programa? (S/N): ");
                respostaFinalUsuario = entrada.readLine().toUpperCase();
            } 
			catch (IOException erro) 
			{
                respostaFinalUsuario = "S";  // Caso ocorra erro na leitura, assume-se que o usuário quer sair
            } 
			catch (Exception erro) 
			{
                respostaFinalUsuario = "S";  
            }

        } while (respostaFinalUsuario.equals("N"));

		System.out.println("Programa Encerrado.");
		System.out.println("==================================");
		System.out.println("OBRIGADO POR USAR ESTE PROGRAMA!");
		System.out.println("==================================");
	}
}
