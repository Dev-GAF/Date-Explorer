# Projeto - Date Explorer

Data Explorer é um aplicativo interativo que permite ao usuário consultar e manipular datas de maneira simples e dinâmica. O usuário pode escolher entre duas opções principais: manipular uma data e mantê-la alterada ao longo das interações, ou visualizar uma data sem alterá-la, reiniciando-a a cada consulta.

Desenvolvido com Java, o projeto utiliza uma classe Data para representar e manipular as datas. Ele oferece funcionalidades como avançar ou retroceder dias, tanto individualmente quanto em quantidades maiores.

## 🎯 Funcionalidades

- 🔄 **Manipulação Persistente:** Avance ou retroceda uma data e continue manipulando o valor atualizado.
- 🔍 **Consulta de Datas:** Veja versões futuras ou passadas de uma data sem alterar o valor original.
- 🧠 **Reutilização Inteligente:** O valor original da data é salvo e reutilizado em consultas.
- 🧼 **Limpeza de Terminal:** Comandos para deixar o terminal limpo e organizado.
- 📋 **Validações e Menus Dinâmicos:** Entrada de dados com validação e menus reutilizáveis.

## ⚙ Tecnologias Utilizadas

- 💻 Java SE 8+
- 🧪 Terminal interativo
- 🧠 Programação orientada a objetos

## 📱 Interface

Menu baseado em texto com as seguintes opções:

### Menu Principal:

- (1) Manipular a Data
- (2) Ver Qualquer Data

### Manipulação:

Permite avançar ou retroceder um ou mais dias. As alterações são persistentes durante a execução do programa.

### Visualização:

Sempre reinicia a data para o valor original, sem modificá-la.

---

## 💡 Funcionalidades do Código

- **Data Original:** A primeira data inserida é armazenada como base.
- **Persistência em execução:** Manipulações são mantidas entre interações.
- **Resgate da data inicial:** Sempre que necessário, a data volta ao estado original.

## ▶ Como Executar o Projeto

### 📚 Requisitos

- Java JDK 8 ou superior
- Terminal com `javac` e `java` configurados

## 📄 Licença

### Este projeto está licenciado sob a MIT License. Consulte o arquivo LICENSE para mais detalhes.

