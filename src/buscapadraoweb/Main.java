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
        crw.getListaRecursos().add("https://www.w3schools.com/cpp/cpp_variables.asp");
        crw.getListaRecursos().add("https://google.github.io/styleguide/cppguide.html");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        for (String codigoHTML : listaCodigos) {
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


            //mapa de estados
            String[] estados = new String[32];
            estados[0] = "q0";
            estados[1] = "q1";
            estados[2] = "q2";
            estados[3] = "q3";
            estados[4] = "q4";
            estados[5] = "q5";
            estados[6] = "q6";
            estados[7] = "q7";
            estados[8] = "q8";
            estados[9] = "q9";
            estados[10] = "q10";
            estados[11] = "q11";
            estados[12] = "q12";
            estados[13] = "q13";
            estados[14] = "q14";
            estados[15] = "q15";
            estados[16] = "q16";
            estados[17] = "q17";
            estados[18] = "q18";
            estados[19] = "q19";
            estados[20] = "q20";
            estados[21] = "q21";
            estados[22] = "q22";
            estados[23] = "q23";
            estados[24] = "q24";
            estados[25] = "q25";
            estados[26] = "q26";
            estados[27] = "q27";
            estados[28] = "q28";
            estados[29] = "q29";
            estados[30] = "q30";
            estados[31] = "q31";


            String estado_inicial = "q0";

            //estados finais
            String[] estados_finais = new String[1];
            estados_finais[0] = "q31";

            //tabela de transição de AFD para reconhecimento números de dois dígitos
            int[][] matriz = new int[32][63];
            //transições de q0
            // A-Z
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'A')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'B')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'C')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'D')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'E')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'F')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'G')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'H')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'I')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'J')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'K')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'L')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'M')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'N')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'O')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'P')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'Q')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'R')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'S')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'T')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'U')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'V')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'W')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'X')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'Y')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'Z')] = get_string_ref(estados, "q1");
            // a-z
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'a')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'b')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'c')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'd')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'e')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'f')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'g')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'h')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'i')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'j')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'k')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'l')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'm')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'n')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'o')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'p')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'q')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'r')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 's')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 't')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'u')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'v')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'w')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'x')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'y')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, 'z')] = get_string_ref(estados, "q1");
            // _
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '_')] = get_string_ref(estados, "q1");

            //transições de q1 até q31
            for (int i = 1; i < 31; i++) {
                int from = get_string_ref(estados, "q" + i);
                int to = get_string_ref(estados, "q" + (i + 1));

                for (char c = '0'; c <= '9'; c++) {
                    matriz[from][get_char_ref(alfabeto, c)] = to;
                }
                for (char c = 'A'; c <= 'Z'; c++) {
                    matriz[from][get_char_ref(alfabeto, c)] = to;
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    matriz[from][get_char_ref(alfabeto, c)] = to;
                }
                matriz[from][get_char_ref(alfabeto, '_')] = to;
            }


            int estado = get_string_ref (estados, estado_inicial);
            int estado_anterior = -1;
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
                    //se houver transição válida, adiciona caracter a palavra
                    palavra += codigoHTML.charAt(i);
                }
            }


            //foreach no Java para exibir todas as palavras reconhecidas
            for (String p: palavras_reconhecidas){
                System.out.println (p);
            }
        }

    }



}
