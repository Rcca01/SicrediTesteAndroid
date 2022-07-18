# SicrediTesteAndroid
Teste para Desenvolvedor(a) Android - Sicredi

A linguagem utilizada para o projeto foi o Kotlin e a arquitetura MVVM. 
Tal arquitetura foi escolhida por conta da ideia do projeto, onde armazenar e gerenciar dados relacionados à interface do usuário de uma 
maneira consciente do ciclo de vida é um requisito. A classe ViewModel permite que os dados sobrevivam a alterações de configuração, como rotações de tela.
Já as instâncias do LiveData para que notifique a view apenas em momentos adequados do ciclo de vida.
O MVVM nos fornece componentes com o objetivo de ajudar a desenhar aplicações robustas, testavéis e sustentáveis, sem contar que é um padrão recomendado pela
Google.

Bibliotecas/Frameworks utilizados:
1. Retrofit -> Para realizar a conexão com a API
2. Picasso -> Para realizar a busca e renderização das imagens dos eventos
3. RecycleView -> Para renderizar a lista dos eventos
4. CardView -> Componente disponivel no Material Design para estilo "cartão".
5. Gson -> Para realizar os parses do retorno da API com os models do projeto.
6. idLinkResource -> Para facilitar a estrutura de teste, visto que as telas são carregas via chamadas API
7. Espresso -> Para realizar testes
8. Mockito -> Para realizar a copia/mock de itens do projeto para facilitar a criação de testes 

Foram criados teste de interface e teste unitários de alguns itens do projeto.

Testes de interface:
1. Verificar a renderização da lista de eventos;
2. Clicar em um item da lista;
3. Verificar se houve a abertura do bottomSheetDialog com os detalhes do evento;
4. Fechar tela de detalhes.

Testes unitários:
1. Validação da função para retornar a data correta a partir de um valor Double;
2. Validação da função para retornar o valor em reias(ptBr) de um valor Double Ex. 29.99 -> R$ 29,99
