fisrt-exercise-tw-final

Exercício para a segunda etapa do programa Desenvolve da ThoughtWorks.
Foi construído um programa que busca o hotel mais barato de acordo com três opções disponíveis.
O projeto foi dividido em duas pastas a de testes e a de classes com seus respectivos métodos, a classe Hotel é a principal. Nela contém o método searchHotel, que nele podemos fazer a pesquisa de qual é o hotel mais barato ou o com melhor qualificação, e contém métodos secundários que auxiliam no tratamento da entrada ou na resolução do problema. A classe File foi criada para tratar o arquivo de entrada que é solicitado no exercício e a classe Menu serve para inicializar o programa.

As classes de testes foram utilizadas para testar a entrada dos métodos criados e para realizar alguns testes para confirmar que o retorno dos secundários estavam corretos.

Algumas colocações:
1. O arquivo teste deve ter a seguinte estrutura: 
Regular: 16Mar2009, 17Mar2009, 18Mar2009
Rewards: 26Mar2009, 27Mar2009, 28Mar2009
Onde cada linha representa uma reserva feita pelo cliente.
2. Na pasta principal do programa, existe dois arquivos de exemplo que foram utilizados nos testes. O primeiro é o arquivoIncorreto.txt que apresenta uma entrada sem a estrutura desejada e o segundo é o arquivoCorreto.txt que apresenta a estrutura apresentada no ponto anterior;
3. Não foi utilizado os dias ao lado das datas, ex (thur), por não saber se realmente seria colocado na entrada. Em vez disso existe uma função secundária que já retorna o dia da semana que cada data representa;
4. O desenvolvimento do programa foi toda pelo Intellij, para rodar o programa é necessário importar as configurações do JUnit e ter o Java 8+, por conta de certas funções utilizadas;


Antes de cada função existe um breve comentário explicando sua funcionalidade e em algumas tem o porque foi usada aquela determinada lógica.

