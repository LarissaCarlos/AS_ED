import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        int[] elementos = {1, 2, 3, 4, 5, 6};
        adicionarElementos(arvore, elementos);
        mostrarArvore(arvore);
        percorrerArvoreRecursivamente(arvore, "EmOrdem");
        percorrerArvoreRecursivamente(arvore, "PreOrdem");
        percorrerArvoreRecursivamente(arvore, "PosOrdem");
    }

    public static void adicionarElementos(ArvoreBinaria arvore, int[] elementos) {
        Arrays.sort(elementos);
        adicionarElementosRecursivamente(arvore, elementos, 0, elementos.length - 1);
    }

    private static void adicionarElementosRecursivamente(ArvoreBinaria arvore, int[] elementos, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            arvore.adicionar(elementos[meio]);
            adicionarElementosRecursivamente(arvore, elementos, inicio, meio - 1);
            adicionarElementosRecursivamente(arvore, elementos, meio + 1, fim);
        }
    }

    public static void mostrarArvore(ArvoreBinaria arvore) {
        arvore.mostrarArvore();
    }

    public static void percorrerArvoreRecursivamente(ArvoreBinaria arvore, String tipoPercorrido) {
        System.out.print("Percorrendo " + tipoPercorrido + ": ");
        if (Objects.equals(tipoPercorrido, "EmOrdem")) {
            arvore.percorrerEmOrdem();
        } else if (tipoPercorrido.equals("PreOrdem")) {
            arvore.percorrerPreOrdem();
        } else if (tipoPercorrido.equals("PosOrdem")) {
            arvore.percorrerPosOrdem();
        } else {
            System.out.println("Tipo de percurso inválido.");
        }
    }
}