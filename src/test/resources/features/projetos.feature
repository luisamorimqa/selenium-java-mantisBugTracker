#language: pt
Funcionalidade: Gerenciamento de Projetos
  Como administrador ou gerente
  Quero criar e editar projetos
  Para organizar os bugs de forma estruturada

  Cenário: Criar novo projeto
    Dado que estou logado como administrador
    Quando acesso a tela de gerenciamento de projetos
    E clico em "Criar novo projeto"
    E preencho o nome do projeto
    E salvo
    Então o projeto deve ser criado com sucesso

  Cenário: Atualizar informações do projeto
    Dado que estou na tela de gerenciamento de projetos
    Quando edito um projeto existente
    E altero sua descrição
    Então as alterações devem ser salvas corretamente