# Exercício Conta Bancária

Este exercício é dado na parte de revisão de Conceitos Básicos de Orientação a Objetos da disciplina GAC106 - Práticas de Programação Orientada a Objetos.

Basta seguir os passos apresentados a seguir.

## Orientações Gerais

- Você deve fazer um passo de cada vez, testá-lo, fazer o commit e enviar suas alterações.
Somente depois disso é que você deve passar para o próximo passo.

- **ATENÇÃO**: **desligue o GitHub Copilot para fazer o exercício!**
  - Se você utilizá-lo você não estará realmente exercitando os conceitos aprendidos e
    não terá o domínio adequado para desenvolver as habilidades necessárias para se tornar
	um bom programador/desenvolvedor.
  - Sem contar ainda a questão do plágio.
  - Os exercícios trazem exemplos de código em Java, e você também pode consultar os
    slides das aulas teóricas de revisão.

- Esse arquivo README pode ser melhor visualizado no VS Code (com formatação adequada) 
  abrindo-o no modo de visualização. Para isso, basta apertar Ctrl+Sfhit+V com ele aberto.

## Passo 1 - Representando uma conta bancária

Esse e os próximos exercícios se referem às operações de uma conta bancária.
Nesse primeiro passo, crie uma classe para representar uma conta bancária, que atenda às necessidades abaixo.
Lembre-se de usar adequadamente os modificadores de visibilidade (`public` ou `private`) dos atributos e métodos.

- As contas devem possuir o nome do titular da conta, um saldo e um limite.
- Devem existir métodos para consultar o nome do titular e o saldo.
- Devem existir métodos para saque e para depósito de valores na conta.
- A conta pode ter saldo negativo no máximo até o limite estabelecido.
  - Exemplo: se o limite da conta for R$ 500, significa que o saldo pode chegar ao valor mínimo de -R$ 500.
- A classe não deve ter nenhuma interação com o usuário (ou seja, dentro dela não deve existir exibição de mensagens, nem obtenção de dados do usuário).

Neste passo ainda não é possível testar o seu código.
De todo modo, ao terminar, faça o commit e sincronize as suas alterações (use `passo1` no comentário do commit).

- Obs.: se precisar fazer novo commit com alguma correção, use o comentário `passo1 - correções`.

## Passo 2 - Representando um caixa eletrônico

Crie agora uma outra classe que represente um Caixa Eletrônico.
Nesta classe, por enquanto, crie um atributo para guardar uma única conta
(**dica**: siga exatamente o que pede o enunciado, portanto, não crie vetor nem ArrayList de contas nesse passo).

Em seguida implemente um menu com as opções abaixo e implemente métodos separados para tratar cada opção.

```
1. Criar Conta
2. Consultar Saldo
3. Depositar
4. Sacar
5. Sair
```

Por fim, altere a classe que tem o método `main`, para que nele seja criado um objeto da classe que representa o caixa eletrônico e dispare a execução do menu.

- Dica 1: lembre-se de há um exemplo de implementação de menu no Campus Virtual (repositório Carro).
- Dica 2: repare que se o usuário acessar as opções que alteram a conta, antes da conta ser criada, ocorrerá um erro de `NullPointerException`. Podemos facilmente evitar esse problema, verificando primeiro se o atributo que representa a conta é diferente de `null` (e informando apropriadamente ao usuário).

Teste suas alterações!
Depois, faça o commit e sincronize suas alterações (use `passo2` no comentário do commit).

## Passo 3 - Sobrecarga de construtores

Altere a classe que representa as contas bancárias de forma que ela passe a ter dois construtores.

- Os dois construtores devem receber o nome do titular da conta e o valor do limite da conta.
- E apenas um deles deve receber o valor do saldo inicial da conta. Portanto, no outro construtor o saldo deve ser inicializado com zero.

Altere então a classe do caixa eletrônico para que existam duas opções diferentes de criação de contas.

- Uma que pede para o usuário o saldo inicial e outra que não pede.
- Cada opção deve chamar o construtor correspondente.

Como o operador `this` poderia ser utilizado em um dos construtores para evitar replicação de código? (Dica: veja os slides de revisão dos conceitos de OO).

Teste suas alterações!
Depois, faça o commit e sincronize suas alterações.

## Passo 4 - Numeração automática de contas

Neste passo, a ideia é que as contas bancárias tenham um novo atributo para guardar o número da conta e um método que retorne essa informação.

Nós poderíamos receber o número de cada conta no construtor e deixar a classe do caixa eletrônico definir a numeração.
Mas é mais interessante se a própria classe que representa as contas tratar automaticamente a numeração, utilizando o conceito de atributo estático.

Para isso, crie um atributo estático na classe que representa as contas para guardar o número da última conta criada (inicialmente ele deve ter o valor 100).
Repare que são dois atributos diferentes:

- Um é o número da conta em si que é diferente para cada conta (atributo comum).
- E o outro é um atributo estático que indica o número da última conta criada (atibuto estático, que tem o mesmo valor para todas as contas).

No construtor da classe que representa as contas:
- o atributo estático deve ser incrementado, 
- e o seu valor deve ser usado como número da conta que está sendo criada.

Teste suas alterações!
Depois, faça o commit e sincronize suas alterações.

## Passo 5 - Tratando várias contas

Na classe que trata o caixa eletrônico, crie um atributo para guardar uma coleção de contas (pode ser um vetor ou um ArrayList).
- Essa coleção deve substituir o atributo criado no passo 2 para guardar uma única conta.

- Na opção de menu de criar contas, uma nova conta deve ser criada e acrescentada na coleção.
- Após a criação de uma conta, o programa deve exibir o número gerado para a conta de forma que o usuário saiba o número que deve usar nas demais operações.
- Acrescente uma opção de menu chamada `Exibir contas` que exibe o número e o nome do titular de todas as contas.
- E, claro, lembre-se também de alterar as demais opções de menu (consultar saldo, saque e depósito), pois o usuário terá agora que informar o número da conta sobre a qual deseja operar.

Teste suas alterações!
Depois, faça o commit e sincronize suas alterações.

## Passo 6 - Transferência entre contas

Agora que conseguimos criar contas diferentes, podemos fazer transferências entre elas.
Crie um método na classe que representa as contas para realizar a transferência entre duas contas.

- O método deve receber por parâmetro o valor a ser transferido e o objeto da conta de destino.
- O método não deve alterar diretamente o saldo da conta e sim chamar os métodos de saque e depósito apropriadamente.
- Lembre-se que a conta não deve permitir a transferência se o valor solicitado estiver além do limite da conta de origem.

Na classe que representa o caixa eletrônico, crie uma opção de menu para transferência entre contas.

- O usuário deverá escolher qual será a conta de origem e qual será a conta de destino (de acordo com os números das contas).

Teste suas alterações!
Depois, faça o commit e sincronize suas alterações.

## Passo 7 - Rendimento na conta

Suponha que nossa conta é especial e possui um rendimento periódico.
Para tratá-lo faça o seguinte:

- Na classe que representa as contas, crie um atributo estático para guardar o valor da taxa de rendimento (percentual).
- Crie um método `render` que aplica a taxa de rendimento ao saldo da conta. Avalie se tal método deve ser estático ou não.
- Pro fim, crie uma opção de menu na classe que representa o caixa eletrônico para que o usuário possa fazer a conta render.

Teste suas alterações!
Depois, faça o commit e sincronize suas alterações.

## Passo 8 - Alterando rendimento

Crie um método na classe que representa as contas para alterar a taxa de rendimento da conta (e crie uma opção de menu para o usuário informar a nova taxa).

Avalie se o método deve ser estático ou não.

Teste suas alterações!
Depois, faça o commit e sincronize suas alterações.