# language: pt

@lance
Funcionalidade: Dando Lances
  
  Cenario: Um usuario só pode dar lance quando não dono do leilao
    Dado o usuario "fulano" que criou um "leilao Tablet" 
    Quando navega para pagina de leiloes
    Entao ele não dar um lance no "leilao Tablet"
    
    
  Cenario: Um usuario pode dar lance em outro leilao
    Dado o usuario "fulano" logado
    Quando quando ele dar um lance valido no leileo do "beltrano"
    Entao o lance é aceito