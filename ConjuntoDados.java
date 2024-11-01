import java.util.Random;

public class ConjuntoDados {
    public static Registro[][] gerarConjuntosDados(int[] tamanhosDados, int len_tamanhosDados) {
        Registro[][] conjuntos = new Registro[len_tamanhosDados][];
        for (int i = 0; i < len_tamanhosDados; i++) {
            int tamanho = tamanhosDados[i];
            conjuntos[i] = new Registro[tamanho];
            Random rand = new Random(42); // Seed fixa para reprodutibilidade
            for (int j = 0; j < tamanho; j++) {
                long codigo = 100000000L + Math.abs(rand.nextLong()) % 900000000L;
                conjuntos[i][j] = new Registro(codigo);
            }
        }
        return conjuntos;
    }
}
