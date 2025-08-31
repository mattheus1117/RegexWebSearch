# RegexWebSearch

## Descrição

Este projeto implementa um **Autômato Finito Determinístico (AFD)** em Java para reconhecer palavras formadas pelos caracteres `0-9`, `A-Z`, `a-z` e `_` dentro do código-fonte de páginas web.  
O programa acessa páginas web, lê seu conteúdo HTML e extrai todas as palavras válidas segundo o alfabeto definido.

O objetivo é exercitar conceitos de **linguagens formais e expressões regulares** aplicados à **recuperação de informações na web**.

---

## Como Compilar e Rodar

1. Abra o terminal e navegue até a pasta `src`:

  cd "c:\Users\User\Documents\GitHub\RegexWebSearch\src\"

2. Compile os arquivos Java:

  javac buscapadraoweb\Main.java buscaweb\CapturaRecursosWeb.java

3. Execute o programa:

  java buscapadraoweb.Main
