import java.util.Scanner;
import java.io.FileReader; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;


public class Grafo 
{
    public Scanner entrada = new Scanner(System.in); // objeto para entrada de dados
    public String nomeArquivo = "grafo.txt"; // arquivo texto que contém o grafo
    String[] vertices = new String[10];
    
    public int vi, vf, nV;

    public void informaAresta()
    {
        System.out.print("Cidade inicial: ");
        vi = Integer.parseInt(entrada.nextLine());
        System.out.print("Cidade final: ");
        vf = Integer.parseInt(entrada.nextLine());
    }
    public void insereVertice(int [][]G)
    {
        System.out.print("Informe a cidade a ser adicionada: ");
        String v = entrada.nextLine();
        v.length();
        //Precisa desenvolver a logica ainda
        for (int i = 0; i < nV; i++) {
            
        }
        nV ++;
    }
    // carrega o grafo do arquivo para a matriz
    public int carregaGrafo(int[][] G, String[] nomes) throws IOException {
        try(BufferedReader bufLeitura = new BufferedReader(new FileReader(nomeArquivo))) 
        {
            File arq = new File(nomeArquivo);

            int numVertices, numArestas, i;
            String aresta;
            String[] tokens;

            if (!arq.exists())
            {
                System.out.println("Arquivo com o grafo inexistente.");
                return (0);
            } else 
            {
                numVertices = Integer.parseInt(bufLeitura.readLine());
                for (i = 0; i < numVertices; i++) {
                    nomes[i] = bufLeitura.readLine();
                }
            }

            numArestas = Integer.parseInt(bufLeitura.readLine());

            for (i = 0; i < numArestas; i++) {
                aresta = bufLeitura.readLine();

                tokens = aresta.split(" ");

                G[Integer.parseInt(tokens[0]) - 1][Integer.parseInt(tokens[1]) - 1] = Integer.parseInt(tokens[2]);
                G[Integer.parseInt(tokens[1]) - 1][Integer.parseInt(tokens[0]) - 1] = Integer.parseInt(tokens[2]);
            }
            nV = numVertices;
            return (numVertices);  
        }
    }
    // remove um vértice (sua linha e sua coluna da matriz)
    public void removeVertice(int[][] G)
    {
        int i, j, n;
        
        System.out.printf("Informe a cidade a ser removida");
        n = Integer.parseInt(entrada.nextLine());

        for (j = 0; j <= n - 1; j++) {
            for (i = n; i < G.length - 1; i++) {
                G[i][j] = G[i+1][j];
            }
            G[i][j] = 0;
        }
          

        for (i = 0; i <= n - 1; i++) {
            for (j = n; j < G.length - 1; j++) {
                G[i][j] = G[i][j+1];
            }
            G[i][j] = 0;
        }

        for (i = n; i < G.length - 1; i++) {
            for (j = n; j < G.length - 1; j++) {
                G[i][j] = G[i+1][j+1];
            }
        } 

        for (i = n; i < G.length - 1; i++){
            G[i][G.length-1] = 0; 
        }    
        for (j = n; j < G.length - 1; j++){
            G[G.length-1][j] = 0;
        }
        G[G.length-1][G.length-1] = 0;
        nV --;
    }    

    // insere uma aresta no grafo
    public void insereAresta(int[][] G, int vi, int vf)
    {        
        G[vi-1][vf-1] = 1;
        G[vf-1][vi-1] = 1;
    }   

    // remove uma aresta no grafo
    public void removeAresta(int[][] G, int vi, int vf)
    {        
        G[vi-1][vf-1] = 0;
        G[vf-1][vi-1] = 0;
    }

    public boolean arestaExiste(int[][] G, int vi, int vf)
    {
        if (G[vi-1][vf-1] != 0)
            return true;
        else
            return false;
    }
    public int numeroArestas(int[][] G)
    {
        int i, j, cont=0;

        for (i = 1; i <= nV; i++) {
            for (j = 1; j <= nV; j++) {
                if (arestaExiste(G, i, j))
                    cont++;                               
            }
        }
        return cont;
    }
    public Boolean verificaEuleriano(int[][] G)
    {
        int i, j, cont;

        for (i = 1; i <= nV; i++) {
            cont = 0;
            for (j = 1; j <= nV; j++) {
                if (arestaExiste(G, i, j))
                    cont++;                               
            }
            if(cont %2 != 0)
                return false;
        }
        return true;
    }
    public Boolean grafoCompleto(int[][] G)
    {
        //formula grafo completo
        int grafCompl = (nV * (nV-1))/2;

        if(numeroArestas(G) > grafCompl)
            return true;        
        return false;
    }
    public Boolean grafoDesconexo(int[][] G)
    {   
        if(numeroArestas(G) == 0)
            return true;
        return false;
    } 
    
    public void exibeGraus(int[][] G)
    {
        int i, j, cont=0;

        for (i = 1; i <= nV; i++) {
            cont = 0;
            for (j = 1; j <= nV; j++) {
                if (arestaExiste(G, i, j))
                    cont++;                               
            }
            System.out.printf("O grau do vértice %d é: %d\n", i, cont);
        }
    }

    // exibe o grafo
    public void exibeGrafo(int[][] G)
    {
        int i, j;

        for (i = 1; i <= nV; i++) {
            System.out.printf("Cidades adjacentes a %s: ", vertices[i-1]);
            for (j = 1; j <= nV; j++) {
                if (arestaExiste(G, i, j))
                    System.out.printf("%s (distância: %d), ", vertices[j-1], G[i-1][j-1]);
            }
            System.out.printf("\n");
        }         
    }
}
