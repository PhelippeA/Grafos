import java.util.Scanner;
import java.io.IOException;

class Main {    
    static Scanner entrada = new Scanner(System.in); // objeto para entrada de dados
    static String nomeArquivo = "grafo.txt"; // arquivo texto que contém o grafo

    // exibe menu e lê opção do usuário
    public static void main(String[] args) throws IOException {
        int op;       
        int[][] G = new int[10][10]; // matriz de adjacências que armazena o grafo // int[,] G;

        var g = new Grafo();
        var util = new Util();

        g.carregaGrafo(G, g.vertices);
        
        do {
            op = util.menu();
            
            switch (op) { 
                case 1: // inserir vértice
                    g.insereVertice(G);
                    break;

                case 2: // remover vértice
                    g.removeVertice(G);
                    break;

                case 3: // inserir aresta
                    g.informaAresta();
                    if  (g.arestaExiste(G, g.vi, g.vf))
                        System.out.printf("Os vértices %d e %d já são adjacentes.\n\n", g.vi, g.vf);
                    else                    
                        g.insereAresta(G, g.vi, g.vf);
                    break;

                case 4: // remover aresta
                    g.informaAresta();
                    if(g.arestaExiste(G, g.vi, g.vf))
                        g.removeAresta(G, g.vi, g.vf); 
                    else 
                        System.out.printf("Os vértices %d e %d não são adjacentes.\n\n", g.vi, g.vf);                   
                    break;

                case 5: // verificar adjacências
                    g.informaAresta();
                    if (g.arestaExiste(G, g.vi, g.vf))
                        System.out.printf("Os vértices %d e %d são adjacentes.\n\n", g.vi, g.vf);
                    else    
                        System.out.printf("Os vértices %d e %d não são adjacentes.\n\n", g.vi, g.vf);
                    break;

                case 6: // graus dos vértices
                    g.exibeGraus(G);
                    break;

                case 7: // exibir grafo
                    g.exibeGrafo(G);
                    break;

                case 8: // verificar grafo euleriano
                    if(g.verificaEuleriano(G))
                        System.out.printf("Este grafo é euleriano\n\n");
                    else 
                        System.out.printf("Este grafo não é euleriano\n\n");
                    break;

                case 9: // verificar grafo completo
                    if(g.grafoCompleto(G))
                        System.out.printf("Este grafo é completo\n\n");
                    else
                        System.out.printf("Este grafo não é completo\n\n");    
                    break;

                case 10: // verificar grafo totalmente desconexo
                    if(g.grafoDesconexo(G))
                        System.out.printf("Este grafo é totalmente desconexo\n\n");
                    else
                        System.out.printf("Este grafo não é totalmente desconexo\n\n");
                    break;

                case 11: // grafo complementar
                    break;

                case 12: // carregar grafo
                    g.carregaGrafo(G, g.vertices);
                    break;

                case 13: // alterar peso aresta
                    break;
                }
        } while (op != 14);
    }
}