#language: pt

Funcionalidade: Gerenciamento de Usuários
Como um administrador
Quero gerenciar contas de usuários
Para controlar o acesso ao sistema

Cenário: Criar novo usuário
Dado que estou logado como administrador
Quando acesso a tela de gerenciamento de usuários
E clico em "Criar novo usuário"
E preencho os dados obrigatórios
E salvo o usuário
Então o novo usuário deve ser criado com sucesso

Cenário: Editar dados de usuário
Dado que estou na tela de gerenciamento de usuários
Quando seleciono um usuário existente
E altero seu e-mail
E salvo a alteração
Então o sistema deve exibir a mensagem "Usuário atualizado com sucesso"

Cenário: Desativar usuário
Dado que estou na tela de gerenciamento de usuários
Quando seleciono um usuário existente
E altero seu status para "desativado"
Então o usuário não deve mais conseguir realizar login