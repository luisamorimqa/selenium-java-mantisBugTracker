#language: pt
Funcionalidade: Permissões e Perfis de Usuário
  Como administrador
  Quero configurar permissões
  Para controlar o que cada perfil pode acessar

  Cenário: Usuário comum não deve acessar administração
    Dado que estou logado como usuário comum
    Quando tento acessar a tela de administração
    Então devo visualizar a mensagem "Acesso negado"