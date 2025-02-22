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
            System.out.println("\n==================================");
            System.out.println("\tMENU PRINCIPAL");
            System.out.println("==================================");

            while (data == null) 
			{
                try 
				{
                    System.out.print("Digite uma data no formato dd/mm/yyyy: ");
                    String dataInserida = entrada.readLine();

                    data = Data.transformarEmData(dataInserida);
                } 
				catch (Exception erro) 
				{
                    System.err.println("Erro: " + erro.getMessage());
                }
            }

            byte opcao;
            try 
			{
                System.out.println("==================================");
                System.out.println("(1) - Manipular esta Data");
                System.out.println("(2) - Ver qualquer Data");
                System.out.println("(0) - Encerrar Programa");
                System.out.println("==================================");
                System.out.print("Digite uma opção: ");
                opcao = Byte.parseByte(entrada.readLine());
            } 
			catch (IOException erro) 
			{
                opcao = 9;  // Atribui um valor qualquer
            } catch (NumberFormatException erro) 
			{
                System.err.println("\nByte inserido inválido!");
                opcao = 9;
            }

            // Limpar o terminal
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
                case 0:
                    break;

                case 1:
                    try 
					{
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
                        System.out.print("\nDigite uma opção: ");
                        opcaoMenu = Byte.parseByte(entrada.readLine());
                    } 
					catch (IOException erro) 
					{
                        opcaoMenu = 9;  // Atribui um valor qualquer
                    } 
					catch (NumberFormatException erro) 
					{
                        System.err.println("\nByte inserido inválido!");
                        opcaoMenu = 9;
                    }

                    switch (opcaoMenu) 
					{
                        case 0:
                            break;

                        case 1:
                            data.avanceUmDia();
                            System.out.println("\nData: " + data);
                            break;

                        case 2:
                            try 
							{
                                System.out.print("Avançar quantos dias? ");
                                int qtdDias = Integer.parseInt(entrada.readLine());

                                data.avanceVariosDias(qtdDias);
                                System.out.println("\nData: " + data);
                            } 
							catch (IOException erro) 
							{} 
							catch (NumberFormatException erro) 
							{
                                System.err.println("\nByte inserido inválido!");
                            } 
							catch (Exception erro) 
							{
                                System.err.println(erro.getMessage());
                            }
                            break;

                        case 3:
                            data.retrocedaUmDia();
                            System.out.println("\nData: " + data);
                            break;

                        case 4:
                            try 
							{
                                System.out.print("Retroceder quantos dias? ");
                                int qtdDias = Integer.parseInt(entrada.readLine());

                                data.retrocedaVariosDias(qtdDias);
                                System.out.println("\nData: " + data);
                            } 
							catch (IOException erro) 
							{} 
							catch (NumberFormatException erro) 
							{
                                System.err.println("\nByte inserido inválido!");
                            } catch (Exception erro) 
							{
                                System.err.println(erro.getMessage());
                            }
                            break;

                        default:
                            System.err.println("Opção inválida! Tente novamente...");
                            break;
                    }
                    break;

                case 2:
                    try 
					{
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
                        System.out.print("\nDigite uma opção: ");
                        opcaoMenu = Byte.parseByte(entrada.readLine());
                    } 
					catch (IOException erro) 
					{
                        opcaoMenu = 9;  // Atribui um valor qualquer 
                    } catch (NumberFormatException erro) 
					{
                        System.err.println("\nByte inserido inválido!");
                        opcaoMenu = 9;
                    }

                    switch (opcaoMenu) 
					{
                        case 0:
                            break;

                        case 1:
                            System.out.println("\nData: " + data.getDiaSeguinte());
                            break;

                        case 2:
                            try 
							{
                                System.out.print("Avançar quantos dias? ");
                                int qtdDias = Integer.parseInt(entrada.readLine());

                                System.out.println("\nData: " + data.getVariosDiasAdiante(qtdDias));
                            } 
							catch (IOException erro) 
							{} 
							catch (NumberFormatException erro) 
							{
                                System.err.println("\nByte inserido inválido!");
                            } 
							catch (Exception erro) 
							{
                                System.err.println(erro.getMessage());
                            }
                            break;

                        case 3:
                            System.out.println("\nData: " + data.getDiaAnterior());
                            break;

                        case 4:
                            try 
							{
                                System.out.print("Retroceder quantos dias? ");
                                int qtdDias = Integer.parseInt(entrada.readLine());

                                System.out.println("\nData: " + data.getVariosDiasAtras(qtdDias));
                            } 
							catch (IOException erro) 
							{} 
							catch (NumberFormatException erro) 
							{
                                System.err.println("\nByte inserido inválido!");
                            }
							catch (Exception erro) 
							{
                                System.err.println(erro.getMessage());
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
                System.out.println("Deseja continuar? (S/N): ");
                respostaFinalUsuario = entrada.readLine().toUpperCase();
            } 
			catch (IOException erro) 
			{
                respostaFinalUsuario = "N";  // Caso ocorra erro na leitura, assume-se que o usuário quer sair
            } 
			catch (Exception erro) 
			{
                respostaFinalUsuario = "N";  // Caso ocorra qualquer outro erro, assume-se que o usuário quer sair
            }

        } while (respostaFinalUsuario.equals("S"));

		System.out.println("Programa Encerrado.");
		System.out.println("==================================");
		System.out.println("OBRIGADO POR USAR ESTE PROGRAMA!");
		System.out.println("==================================");
	}
}
