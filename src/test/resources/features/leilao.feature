# language: pt

@leilao
Funcionalidade: Propondo um lance ao leilao

Um usario pode dar lances validos para um leilao que nao dono. 
Ele só pode dar lances que são maiores do que o valor inicial do leilao.
https://github.com/steppat/leilao
  
  Cenario: Pode dar lances
    Dado o usuario "fulano"
    E um leilao do usuario "beltrano"
    Quando "fulano" dá um lance no leilao do "beltrano"
    Entao o lance é adicionado no leilao
       

  
       