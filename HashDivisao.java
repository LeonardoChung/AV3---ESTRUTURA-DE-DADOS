public class HashDivisao implements FuncaoHash {
    int tamanho;

    public HashDivisao(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int hash(long chave) {
        return (int) (chave % tamanho);
    }
}
