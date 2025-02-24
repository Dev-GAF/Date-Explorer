# Projeto - Date Explorer

Data Explorer é um aplicativo interativo que permite ao usuário consultar e manipular datas de maneira simples e dinâmica. O usuário pode escolher entre duas opções principais: manipular uma data e mantê-la alterada ao longo das interações, ou visualizar uma data sem alterá-la, reiniciando-a a cada consulta.

Desenvolvido com Java, o projeto utiliza uma classe Data para representar e manipular as datas. Ele oferece funcionalidades como avançar ou retroceder dias, tanto individualmente quanto em quantidades maiores.

## 🎯 Funcionalidades

* Opção 1 - Manipular Data: Permite ao usuário avançar ou retroceder a data, mantendo as alterações para interações subsequentes.
* Opção 2 - Ver Qualquer Data: Exibe a data sem modificá-la. A cada vez que o usuário escolhe essa opção, a data é "reiniciada" para o valor original inserido.
* Avançar e Retroceder Dias: O usuário pode avançar ou retroceder um ou mais dias da data selecionada através de outro menu.
* Interface Interativa: O sistema apresenta um menu com opções claras para o usuário manipular a data ou visualizar novas datas de maneira intuitiva.

## ⚙ Tecnologias Utilizadas

* Java: Linguagem utilizada para desenvolver a lógica do sistema de manipulação de datas.

## 👨‍💻 Estrutura de dados

A aplicação utiliza a classe Data para representar as datas e manipular as operações de avanço e retrocesso de dias.

### Métodos:

* avanceUmDia(): Avança a data em um dia.
* avanceVariosDias(int qtdDias): Avança a data por uma quantidade especificada de dias.
* retrocedaUmDia(): Retrocede a data em um dia.
* retrocedaVariosDias(int qtdDias): Retrocede a data por uma quantidade especificada de dias.
* getDiaSeguinte(): Retorna a data do dia seguinte.
* getVariosDiasAdiante(int qtdDias): Retorna a data de vários dias à frente.
* getDiaAnterior(): Retorna a data do dia anterior.
* getVariosDiasAtras(int qtdDias): Retorna a data de vários dias atrás.

## 📱 Interface

A interface é baseada em um menu de texto, com as seguintes opções:

### Menu Principal:

* (1) Manipular a Data
* (2) Ver Qualquer Data
  
Quando o usuário escolhe a opção 1, ele pode avançar ou retroceder a data. As alterações são mantidas até a próxima execução do programa. Já na opção 2, a data é "reiniciada" sempre que o usuário escolher uma nova consulta.

## 💡 Funcionalidades do Código

* Cadastro da Data Original: Quando o usuário insere a data pela primeira vez, ela é armazenada como a data original, que será reutilizada sempre que a opção 2 for escolhida.
* Manipulação de Data: Na opção 1, a data pode ser alterada de maneira persistente, avançando ou retrocedendo dias.
* Reinício da Data: Na opção 2, a data é reiniciada para o valor original a cada nova consulta

## 🌱 Melhorias Futuras

1. Refatoração da Classe Main:
* Eliminação de Funcionalidades Repetidas: A classe Main pode ser refatorada para centralizar funcionalidades repetidas, como a validação de entradas e o processamento das opções do menu, em métodos auxiliares. Isso melhoraria a legibilidade e manutenção do código, tornando-o mais limpo e organizado.

## 📄 Licença

### Este projeto está licenciado sob a MIT License. Consulte o arquivo LICENSE para mais detalhes.

