package Sessao3;

public class exemplo {
    // vetores multidimensionais

    public static void main(String[] args) {
        int[][] tabela = new int[2][3];

        tabela[0][0] = 10;
        tabela[0][1] = 30;
        tabela[0][2] = 10;
        tabela[1][0] = 50;
        tabela[1][1] = 60;
        tabela[1][2] = 80;

        for (int[] tabela1 : tabela) {
            for (int j = 0; j < tabela1.length; j++) {
                System.out.print(tabela1[j] + " ");
            }
            System.out.println();
        }
    }
}