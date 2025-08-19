#language: pt
  @login
  Funcionalidade: Login
    Eu como usuário do Mantis
    Quero fazer login
    Para que eu possa acessar as funcionalidades

    Contexto:
      Dado que estou na tela de login do Mantis

    @login-success
    Cenário: Login com sucesso
      Quando preencho login válido
      E preencho a senha válida
      Então a tela inicial deverá ser apresentada

    @login-sem-login
    Cenário: Login sem informar login
      Quando clico no botão Entrar da página de login
      Então devo visualizar uma mensagem de erro "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."

    @login-senha-invalida
    Cenário: Login com senha inválida
      Quando preencho login válido
      E preencho uma senha incorreta
      Então devo visualizar uma mensagem de erro "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."

    @logout
    Cenário: Logout do sistema
      Dado que estou logado no Mantis
      Quando clico em Sair
      Então devo ser redirecionado para a tela de login
