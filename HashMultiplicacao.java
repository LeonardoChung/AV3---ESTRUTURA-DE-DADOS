public class HashMultiplicacao implements FuncaoHash {
    int tamanho;
    final double A = 0.6180339887; // Constante (raiz de 5 - 1)/2

    public HashMultiplicacao(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int hash(long chave) {
        double frac = (chave * A) % 1;
        return (int) (tamanho * frac);
    }
}
