package programa;

import console.ConsoleManager;
import calendario.Data;

public class Main 
{
    public static void main(String[] args) 
	{
        Data data = null;

        String respostaFinalUsuario;
        do 
		{
            ConsoleManager.limparTerminal();

            System.out.println("==================================");
            System.out.println("\tMENU PRINCIPAL");
            System.out.println("==================================");

            while (data==null) 
			{
                try 
				{
                    String dataInserida = ConsoleManager.lerString("Digite uma data no formato dd/mm/yyyy: ");
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
                opcao = ConsoleManager.lerByte("Digite uma opção: ");
                if (opcao<1 || opcao>2)
                    System.err.println("Erro! Digite uma das opções válidas...\n");
            }
            while (opcao<1 || opcao>2);

            ConsoleManager.limparTerminal();

            byte opcaoMenu;
            switch (opcao) 
			{
                case 1:
                    ConsoleManager.subMenu(data, new String[] {
                        "(1) - Avançar um dia",
                        "(2) - Avançar vários dias",
                        "(3) - Retroceder um dia",
                        "(4) - Retroceder vários dias",
                        "(0) - Sair"
                    });

                    do
                    {
                        opcaoMenu = ConsoleManager.lerByte("Digite uma opção: ");

                        if (opcaoMenu<0 || opcaoMenu>4)
                            System.err.println("Erro! Digite uma das opções válidas...\n");
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
                            int qtdDias = ConsoleManager.lerInt("Avançar quantos dias? ");
                            try 
                            {
                                data.avanceVariosDias(qtdDias);
                                System.out.println("\nData: " + data);
                                break;
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
                            int qtdDiasVoltar = ConsoleManager.lerInt("Retroceder quantos dias? ");
                            try 
                            {
                                data.retrocedaVariosDias(qtdDiasVoltar);
                                System.out.println("\nData: " + data);
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

                case 2:
                    ConsoleManager.subMenu(data, new String[] {
                        "(1) - Obter o dia seguinte",
                        "(2) - Obter vários dias adiante",
                        "(3) - Obter o dia anterior\"",
                        "(4) - Obter vários dias atrás",
                        "(0) - Sair"
                    });
                        
                    do
                    {
                        opcaoMenu = ConsoleManager.lerByte("Digite uma opção: ");

                        if (opcaoMenu<0 || opcaoMenu>4)
                            System.err.println("Erro! Digite uma das opções válidas...\n");
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
                            int diasAdiante = ConsoleManager.lerInt("Avançar quantos dias? ");
                            try 
                            {
                                System.out.println("\nData: " + data.getVariosDiasAdiante(diasAdiante));
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
                            int diasAtras = ConsoleManager.lerInt("Retroceder quantos dias? ");
                            try 
                            {
                                System.out.println("\nData: " + data.getVariosDiasAtras(diasAtras));
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

            respostaFinalUsuario = ConsoleManager.encerrarPrograma("Deseja encerrar o Programa? (S/N): ").toUpperCase();
            
        } while (respostaFinalUsuario.equals("N"));

		System.out.println("\nPrograma Encerrado.");
		System.out.println("==================================");
		System.out.println("OBRIGADO POR USAR ESTE PROGRAMA!");
		System.out.println("==================================");
	}
}
