# language: pt

Funcionalidade: Apenas usuarios cadastrado podem se logar
  
  Cenario: Um usuario valido consegue se logar
    Dado o usuario valido
    Quando realiza login
    Entao eh redirecionado a pagina de login