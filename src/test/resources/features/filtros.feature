#language: pt

Funcionalidade: Filtros e Pesquisa
Como usuário do Mantis
Quero aplicar filtros e salvar pesquisas
Para encontrar issues de forma eficiente

Cenário: Pesquisar issue por ID
Dado que estou na tela de "Ver Issues"
Quando informo o ID da issue no campo de busca
Então devo visualizar a issue correspondente

Cenário: Filtrar issues por status
Dado que estou na tela de "Ver Issues"
Quando aplico filtro "Em andamento"
Então apenas issues com esse status devem ser exibidas

Cenário: Salvar filtro personalizado
Dado que estou na tela de "Ver Issues"
Quando aplico um conjunto de filtros
E salvo como filtro personalizado
Então o filtro deve estar disponível para reutilização