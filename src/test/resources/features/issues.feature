#language: pt

Funcionalidade: Registro e Gerenciamento de Issues
  Como um usuário do Mantis
  Quero registrar e gerenciar bugs
  Para reportar problemas de software

  @create-issue @regressao
  Cenário: Criar nova issue
    Dado que estou logado como administrador
    Quando acesso a tela Create Issue
    E preencho os campos obrigatórios
    E salvo a issue
    Então a issue deve ser criada e aparecer na lista de issues do projeto

  Cenário: Atualizar issue existente
    Dado que estou na tela de detalhes de uma issue
    Quando altero o status para "Atribuído"
    E salvo
    Então a issue deve ser atualizada corretamente

  Cenário: Fechar uma issue
    Dado que estou na tela de detalhes de uma issue
    Quando altero o status para "Fechado"
    E salvo
    Então a issue deve ser exibida como encerrada