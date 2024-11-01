public class HashTable {
    No[] tabela;
    FuncaoHash funcaoHash;
    int colisoes;

    public HashTable(int tamanho, FuncaoHash funcaoHash) {
        this.tabela = new No[tamanho];
        this.funcaoHash = funcaoHash;
        this.colisoes = 0;
    }

    public void inserir(Registro reg) {
        int indice = funcaoHash.hash(reg.codigo);
        No novoNo = new No(reg);

        if (tabela[indice] == null) {
            tabela[indice] = novoNo;
        } else {
            // Colisão ocorreu
            colisoes++;
            No atual = tabela[indice];
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public Registro buscar(long codigo) {
        int indice = funcaoHash.hash(codigo);
        No atual = tabela[indice];
        while (atual != null) {
            if (atual.registro.codigo == codigo) {
                return atual.registro;
            }
            atual = atual.proximo;
        }
        return null;
    }
}
