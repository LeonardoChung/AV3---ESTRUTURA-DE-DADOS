import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] tamanhosTabela = {1000, 10000, 100000};
        int len_tamanhosTabela = 3;

        int[] tamanhosDados = {100000, 500000, 2000000};
        int len_tamanhosDados = 3;

        Registro[][] conjuntosDados = ConjuntoDados.gerarConjuntosDados(tamanhosDados, len_tamanhosDados);

        for (int t = 0; t < len_tamanhosTabela; t++) {
            int tamanhoTabela = tamanhosTabela[t];
            System.out.println("Tamanho da Tabela: " + tamanhoTabela);

            FuncaoHash[] funcoesHash = {
                    new HashDivisao(tamanhoTabela),
                    new HashMultiplicacao(tamanhoTabela),
                    new HashDobramento(tamanhoTabela)
            };

            String[] nomesFuncoesHash = {"Divisão", "Multiplicação", "Dobramento"};
            int len_funcoesHash = 3;

            for (int f = 0; f < len_funcoesHash; f++) {
                FuncaoHash funcaoHash = funcoesHash[f];
                String nomeFuncaoHash = nomesFuncoesHash[f];
                System.out.println("Função Hash: " + nomeFuncaoHash);

                for (int i = 0; i < len_tamanhosDados; i++) {
                    int tamanhoDados = tamanhosDados[i];
                    Registro[] dados = conjuntosDados[i];
                    System.out.println("Tamanho do Conjunto de Dados: " + tamanhoDados);

                    HashTable tabelaHash = new HashTable(tamanhoTabela, funcaoHash);

                    long inicioInsercao = System.currentTimeMillis();
                    for (int k = 0; k < tamanhoDados; k++) {
                        Registro reg = dados[k];
                        tabelaHash.inserir(reg);
                    }
                    long fimInsercao = System.currentTimeMillis();
                    long tempoInsercao = fimInsercao - inicioInsercao;

                    System.out.println("Tempo de Inserção: " + tempoInsercao + " ms");
                    System.out.println("Número de Colisões: " + tabelaHash.colisoes);

                    long inicioBusca = System.currentTimeMillis();
                    int comparacoesTotais = 0;
                    for (int j = 0; j < 5; j++) {
                        Random randBusca = new Random(j);
                        int indiceBusca = randBusca.nextInt(tamanhoDados);
                        Registro regBusca = dados[indiceBusca];

                        int comparacoes = 0;
                        int indiceTabela = tabelaHash.funcaoHash.hash(regBusca.codigo);
                        No atual = tabelaHash.tabela[indiceTabela];
                        while (atual != null) {
                            comparacoes++;
                            if (atual.registro.codigo == regBusca.codigo) {
                                break;
                            }
                            atual = atual.proximo;
                        }
                        comparacoesTotais += comparacoes;
                    }
                    long fimBusca = System.currentTimeMillis();
                    long tempoBusca = fimBusca - inicioBusca;

                    System.out.println("Tempo de Busca (5 buscas): " + tempoBusca + " ms");
                    System.out.println("Número de Comparações (total): " + comparacoesTotais);
                    System.out.println("---------------------------------------");
                }
            }
        }
    }
}
