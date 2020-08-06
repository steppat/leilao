# language: pt

@lance
Funcionalidade: Dando Lances
  
  Cenario: Um usuario pode dar lance em outro leilao
    Dado o usuario "fulano" logado
    Quando ele dá um lance valido no leilao do "beltrano"
    Entao o lance é aceito
    
  Cenario: Um usuario só pode dar lance quando não é dono do leilao
    Dado o usuario "fulano" que criou um "leilao Tablet" 
    Quando ele navega para pagina de leiloes
    Entao o "fulano" não pode dar um lance no leilao criado   
