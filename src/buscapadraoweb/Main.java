/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscapadraoweb;

import buscaweb.CapturaRecursosWeb;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Main {
    
    // comprimento das palavras reconhecidas
    public static final int LENGTH = 31;

    // busca char em vetor e retorna indice
    public static int get_char_ref (char[] vet, char ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i] == ref){
                return i;
            }
        }
        return -1;
    }

    // busca string em vetor e retorna indice
    public static int get_string_ref (String[] vet, String ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i].equals(ref)){
                return i;
            }
        }
        return -1;
    }

    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(char[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        int simbol_indice = get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        CapturaRecursosWeb crw = new CapturaRecursosWeb();
        crw.getListaRecursos().add("https://learn.microsoft.com/pt-br/cpp/?view=msvc-170");
        crw.getListaRecursos().add("https://google.github.io/styleguide/cppguide.html");
        crw.getListaRecursos().add("https://www.w3schools.com/cpp/cpp_variables.asp");
        ArrayList<String> listaCodigos = crw.carregarRecursos();
        ArrayList<String> urls = crw.getListaRecursos();

        int indice = 0; // contador para acompanhar a URL correspondente
        for (String codigoHTML : listaCodigos) {

            String url = urls.get(indice++);    
            System.out.println("\n===== Página: " + url + " =====\n");

            //mapa do alfabeto
            char[] alfabeto = new char[63];
            // 0-9
            alfabeto[0] = '0';
            alfabeto[1] = '1';
            alfabeto[2] = '2';
            alfabeto[3] = '3';
            alfabeto[4] = '4';
            alfabeto[5] = '5';
            alfabeto[6] = '6';
            alfabeto[7] = '7';
            alfabeto[8] = '8';
            alfabeto[9] = '9';
            // A-Z
            alfabeto[10] = 'A';
            alfabeto[11] = 'B';
            alfabeto[12] = 'C';
            alfabeto[13] = 'D';
            alfabeto[14] = 'E';
            alfabeto[15] = 'F';
            alfabeto[16] = 'G';
            alfabeto[17] = 'H';
            alfabeto[18] = 'I';
            alfabeto[19] = 'J';
            alfabeto[20] = 'K';
            alfabeto[21] = 'L';
            alfabeto[22] = 'M';
            alfabeto[23] = 'N';
            alfabeto[24] = 'O';
            alfabeto[25] = 'P';
            alfabeto[26] = 'Q';
            alfabeto[27] = 'R';
            alfabeto[28] = 'S';
            alfabeto[29] = 'T';
            alfabeto[30] = 'U';
            alfabeto[31] = 'V';
            alfabeto[32] = 'W';
            alfabeto[33] = 'X';
            alfabeto[34] = 'Y';
            alfabeto[35] = 'Z';
            // a-z
            alfabeto[36] = 'a';
            alfabeto[37] = 'b';
            alfabeto[38] = 'c';
            alfabeto[39] = 'd';
            alfabeto[40] = 'e';
            alfabeto[41] = 'f';
            alfabeto[42] = 'g';
            alfabeto[43] = 'h';
            alfabeto[44] = 'i';
            alfabeto[45] = 'j';
            alfabeto[46] = 'k';
            alfabeto[47] = 'l';
            alfabeto[48] = 'm';
            alfabeto[49] = 'n';
            alfabeto[50] = 'o';
            alfabeto[51] = 'p';
            alfabeto[52] = 'q';
            alfabeto[53] = 'r';
            alfabeto[54] = 's';
            alfabeto[55] = 't';
            alfabeto[56] = 'u';
            alfabeto[57] = 'v';
            alfabeto[58] = 'w';
            alfabeto[59] = 'x';
            alfabeto[60] = 'y';
            alfabeto[61] = 'z';
            // _
            alfabeto[62] = '_';


            // garante que LENGTH não ultrapasse 31
            int MAX_LEN = Math.min(LENGTH, 31);

            // mapa de estados
            String[] estados = new String[MAX_LEN + 1];
            for (int k = 0; k <= MAX_LEN; k++) {
                estados[k] = "q" + k;
            }

            String estado_inicial = "q0";

            //estados finais
            String[] estados_finais = new String[1];
            estados_finais[0] = "q" + MAX_LEN;
            

            //tabela de transição de AFD
            int[][] matriz = new int[MAX_LEN + 1][63];


            // transições de q0 até qLENGTH
            for (int i = 0; i < MAX_LEN; i++) {

                for (int j = 0; j < 63; j++) {
                    matriz[i][j] = -1;
                }

                // índice do estado atual e do próximo estado na matriz
                int from = get_string_ref(estados, "q" + i);
                int to = get_string_ref(estados, "q" + (i + 1));

                // q0 não aceita números
                if (i != 0) {
                    for (char c = '0'; c <= '9'; c++) {
                        matriz[from][get_char_ref(alfabeto, c)] = to;
                    }
                }

                // letras maiúsculas
                for (char c = 'A'; c <= 'Z'; c++) {
                    matriz[from][get_char_ref(alfabeto, c)] = to;
                }
                // letras minúsculas
                for (char c = 'a'; c <= 'z'; c++) {
                    matriz[from][get_char_ref(alfabeto, c)] = to;
                }
                // underscore
                matriz[from][get_char_ref(alfabeto, '_')] = to;
            }


            // estado atual do autômato e último estado lido
            int estado = get_string_ref (estados, estado_inicial);
            int estado_anterior = -1;
            // lista de palavras reconhecidas
            ArrayList<String> palavras_reconhecidas = new ArrayList();

            String palavra = "";


            //varre o código-fonte de um código
            for (int i=0; i<codigoHTML.length(); i++){

                estado_anterior = estado;
                estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
                //se o não há transição
                if (estado == -1){
                    //pega estado inicial
                    estado = get_string_ref(estados, estado_inicial);
                    // se o estado anterior foi um estado final
                    if (get_string_ref(estados_finais, estados[estado_anterior]) != -1){
                        //se a palavra não é vazia adiciona palavra reconhecida
                        if ( ! palavra.equals("")){
                            palavras_reconhecidas.add(palavra);
                        }
                        // se ao analisar este caracter não houve transição
                        // teste-o novamente, considerando que o estado seja inicial
                        i--;
                    }
                    //zera palavra
                    palavra = "";
                    
                }else{
                    // limita palavra enquanto é construída
                    if (palavra.length() < MAX_LEN) {
                        palavra += codigoHTML.charAt(i);
                    } else {
                        // se já atingiu LENGTH, força reset do estado
                        estado = get_string_ref(estados, estado_inicial);
                        palavras_reconhecidas.add(palavra);
                        palavra = "";
                    }
                }
            }

            //foreach no Java para exibir todas as palavras reconhecidas
            for (String p: palavras_reconhecidas){
                System.out.println (p);
            }
        
        System.out.println ("\n");
        }
    }
}
