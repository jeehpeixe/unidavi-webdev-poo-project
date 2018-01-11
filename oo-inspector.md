Encapsulamento

## Ferramenta

> Encapsulamento - deixar somente os métodos importantes expostos
> Encapsulamento - atributos de instancia privados
> Encapsulamento - pode dizer o que o método faz sem dizer como ele faz
> Encapsulamento - mudanças devem ocorrer somente em um só lugar
> Herança - Somente colocar na classe o que diz respeito a ela
> Herança - Não possuir repetição de código
> Herança- A classe filha deve usar todas as propriedades da classe pai
> Herança - Atributos protegidos para que a classe filha possa manipular atributos da classe pai.
> Polimorfismo - A classe de base possui o forma como o processo funciona
> Polimorfismo - A classe filha implementa as regras do funcionamento definido nos processos da classe base
> Polimorfismo - Os métodos da classe pai devem ser construídos na classe filha
> Encapsulamento - cobertura de código superior a 80%

## Inspeção

##### Caso 1 - Encapsulamento - deixar somente os métodos importantes expostos (1 - não usa, 2 - usa)
> Basquete: 2
> Cesta01: 2
> Cesta02: 2
> Cesta03: 2
> ControleJogos: 2
> InterfacePontuacao: 2
> Jogo: 2
> SituacaoJogoEnum: 2
> Time: 2
> TimeBasquete: 2

##### Caso 2 - Encapsulamento - atributos de instancia privados (1 - não usa, 2 - usa)
> Basquete: 2
> Cesta01: 2 (não possui atributos)
> Cesta02: 2 (não possui atributos)
> Cesta03: 2 (não possui atributos)
> ControleJogos: 2
> InterfacePontuacao: 2 (não possui atributos)
> Jogo: 2
> SituacaoJogoEnum: 2
> Time: 2
> TimeBasquete: 2

##### Caso 3 - Encapsulamento - pode dizer o que o método faz sem dizer como ele faz  (1 - não se aplica, 2 - razoavelmente, 3 - completamente)
> Basquete: 3
> Cesta01: 3
> Cesta02: 3
> Cesta03: 3
> ControleJogos: 3
> InterfacePontuacao: 3
> Jogo: 3
> SituacaoJogoEnum: 2
> Time: 3
> TimeBasquete: 3

##### Caso 4 - Encapsulamento - mudanças devem ocorrer somente em um só lugar. (1 - não ocorre, 2 - ocorre)
> Basquete: 2
> Cesta01: 2 (não efetua manipulação)
> Cesta02: 2 (não efetua manipulação)
> Cesta03: 2 (não efetua manipulação)
> ControleJogos: 2
> InterfacePontuacao: 2 (não efetua manipulação)
> Jogo: 2
> SituacaoJogoEnum: 2
> Time: 2
> TimeBasquete: 2

##### Caso 5 - Herança - Somente colocar na classe o que diz respeito a ela (1 - não ocorre, 2 - ocorre)
> Basquete: 2
> Cesta01: 2
> Cesta02: 2
> Cesta03: 2
> ControleJogos: 2
> InterfacePontuacao: 2
> Jogo: 2
> SituacaoJogoEnum: 2
> Time: 2
> TimeBasquete: 2

##### Caso 6 - Herança - Não possuir repetição de código (1 - possui repetição,  2 - possui pouca, 3 - não possui repetição)
> Basquete: 3
> Cesta01: 3
> Cesta02: 3
> Cesta03: 3
> ControleJogos: 3
> InterfacePontuacao: 3
> Jogo: 2
> SituacaoJogoEnum: 3
> Time: 3
> TimeBasquete: 3

##### Caso 7 - Herança- A classe filha deve usar todas as propriedades da classe pai (1 - não usa, 2 - usa)
> Basquete: 2 (nao possui pai)
> Cesta01: 2
> Cesta02: 2
> Cesta03: 2
> ControleJogos: 2 (nao possui pai)
> InterfacePontuacao: 2 (não possui pai)
> Jogo: 2 (nao possui pai)
> SituacaoJogoEnum: 2 (não possui pai)
> Time: 2 (não possui pai)
> TimeBasquete: 2

##### Caso 8 - Herança - Atributos protegidos para que a classe filha possa manipular atributos da classe pai.
> Não houve necessidade de manipulação de propriedades alem das informadas nas classes pai.

##### Caso 9 - Polimorfismo - A classe de base possui o forma como o processo funciona. (1 - Não, 2 - Sim)
> Basquete: 2 (classe de criação da interface com o usuário)
> Cesta01: 2
> Cesta02: 2
> Cesta03: 2
> ControleJogos: 2
> InterfacePontuacao: 2
> Jogo: 2
> SituacaoJogoEnum: 2
> Time:2
> TimeBasquete: 2

##### Caso 10 - Polimorfismo - A classe filha implementa as regras do funcionamento definido nos processos da classe base.  (1 - Não, 2 - Sim)
> Basquete: 2 (nao possui pai)
> Cesta01: 2
> Cesta02: 2
> Cesta03: 2
> ControleJogos: 2 (nao possui pai)
> InterfacePontuacao: 2 (não possui pai)
> Jogo: 2 (nao possui pai)
> SituacaoJogoEnum: 2 (não possui pai)
> Time: 2 (não possui pai)
> TimeBasquete: 2

##### Caso 11 - Polimorfismo - Os métodos da classe pai devem ser construídos na classe filha (1 - Não, 2 - Sim)
> Basquete: 2 (nao possui pai)
> Cesta01: 2
> Cesta02: 2
> Cesta03: 2
> ControleJogos: 2 (nao possui pai)
> InterfacePontuacao: 2 (não possui pai)
> Jogo: 2 (nao possui pai)
> SituacaoJogoEnum: 2 (não possui pai)
> Time: 2 (não possui pai)
> TimeBasquete: 2

##### Caso 12 - Encapsulamento - cobertura de código superior a 80% (1 - abaixo, 2 - superiro 80%, 3 - 100%)
> ControleJogosTest - 3