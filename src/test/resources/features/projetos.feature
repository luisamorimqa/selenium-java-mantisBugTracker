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

  @edit-project
  Cenário: Atualizar informações do projeto
    E tenho um projeto ja cadastrado
    Quando acesso o projeto
    E altero suas informações
    Então as alterações devem ser salvas corretamente

  @delete-project
  Cenário: Deletar projeto existente sem issues vinculadas
    E tenho um projeto ja cadastrado
    Quando acesso o projeto
    E clico no botão de deleção
    E confirmo a deleção
    Então o projeto deve ser deletado com sucesso

  @delete-project-com-issues
  Cenário: Deletar projeto existente com issues vinculadas
    E tenho um projeto ja cadastrado
    E o projeto tenha issue vinculada
    Quando acesso o projeto
    E clico no botão de deleção
    E confirmo a deleção
