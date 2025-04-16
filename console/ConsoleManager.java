package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import calendario.Data;

public class ConsoleManager 
{
    private static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void limparTerminal() 
    { 
        try 
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
        catch (Exception erro) 
        {
            erro.printStackTrace();
        }
    }

    public static String lerString(String msg) 
    {  
        System.out.print(msg);
        try 
        {
            return entrada.readLine();   
        } 
        catch (IOException e) 
        {
            return "";
        }
    }

    public static int lerInt(String msg) 
    {
        while (true)
        {
            try 
            {
                return Integer.parseInt(lerString(msg));    
            } 
            catch (NumberFormatException e) 
            {
                System.err.println("Número inválido! Digite um número inteiro.");
            }
        }
    }

    public static byte lerByte(String msg) 
    {
        while (true)
        {
            try 
            {
                return Byte.parseByte(lerString(msg));    
            } 
            catch (NumberFormatException e) 
            {
                System.err.println("Número inválido! Digite um número entre -128 e 127.");
            }
        }
    }

    public static String encerrarPrograma(String msg) 
    { 
        while (true) 
        {
            String resposta = lerString(msg).trim().toUpperCase();

            if (resposta.equals("S") || resposta.equals("N")) 
                return resposta;

            System.err.println("Por favor, digite apenas S ou N.");
        }
    }

    public static void subMenu(Data data, String[] opcoes) 
    { 
        System.out.println("==================================");
        System.out.println("\tData: " + data);
        System.out.println("==================================");
        System.out.println("\tEscolha uma opção:");
        
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }

        System.out.println("==================================");
    }
}
