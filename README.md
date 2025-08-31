# RegexWebSearch

## Descrição

Este projeto implementa um **Autômato Finito Determinístico (AFD)** em Java para reconhecer palavras formadas pelos caracteres `0-9`, `A-Z`, `a-z` e `_` dentro do código-fonte de páginas web.  
O programa acessa páginas web, lê seu conteúdo HTML e extrai todas as palavras válidas segundo o alfabeto definido.

O objetivo é exercitar conceitos de **linguagens formais e expressões regulares** aplicados à **recuperação de informações na web**.

---

## Estrutura do Projeto
RegexWebSearch
└─ src
├─ buscapadraoweb
│ └─ Main.java
└─ buscaweb
└─ CapturaRecursosWeb.java

- `Main.java`: contém a implementação do AFD e a lógica para percorrer o HTML e extrair palavras.  
- `CapturaRecursosWeb.java`: classe auxiliar que captura o código-fonte de páginas web.

---

## Como Compilar e Rodar

1. Abra o terminal e navegue até a pasta `src`:

```powershell
cd "c:\Users\User\Documents\GitHub\RegexWebSearch\src\"

2. Compile os arquivos Java:

javac buscapadraoweb\Main.java buscaweb\CapturaRecursosWeb.java

3. Execute o programa:

java buscapadraoweb.Main
