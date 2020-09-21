import java.util.*;

public class Util {
    
    public Scanner entrada = new Scanner(System.in);
    
    public int menu() 
    {
        int op;

        System.out.println("\nMenu de opções");
        System.out.println("1 - Inserir cidade");
        System.out.println("2 - Remover cidade");
        System.out.println("3 - Inserir rodovia");
        System.out.println("4 - Remover rodovia");
        System.out.println("5 - Verificar rodovias");
        System.out.println("6 - Graus dos vértices");
        System.out.println("7 - Exibir grafo");
        System.out.println("8 - Verificar euleriano");
        System.out.println("9 - Verificar completo");
        System.out.println("10 - Verificar totalmente desconexo");
        System.out.println("11 - Grafo complementar");
        System.out.println("12 - Carregar grafo");
        System.out.println("13 - Alterar peso aresta");
        System.out.println("14 - Sair");
        System.out.print("\nOpção: ");

        op = Integer.parseInt(entrada.nextLine());

        return (op);
    }
}
