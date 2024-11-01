public class HashDobramento implements FuncaoHash {
    int tamanho;

    public HashDobramento(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int hash(long chave) {
        int soma = 0;
        int n = 2;
        long num = chave;
        while (num > 0) {
            int parte = (int) (num % 100);
            soma += parte;
            num /= 100;
        }
        return soma % tamanho;
    }
}
