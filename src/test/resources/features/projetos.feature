#language: pt
Funcionalidade: Gerenciamento de Projetos
  Como administrador ou gerente
  Quero criar e editar projetos
  Para organizar os bugs de forma estruturada

  Contexto:
    Dado que estou logado como administrador
    E estou na tela de gerenciamento de projetos

    @add-new-project @regressao
  Cenário: Criar novo projeto
    Quando clico em Criar novo projeto
    E preencho os dados do projeto
    E clico em Adicionar projeto
    Então o projeto deve ser criado com sucesso

  Cenário: Atualizar informações do projeto
    Quando edito um projeto existente
    E altero sua descrição
    Então as alterações devem ser salvas corretamente