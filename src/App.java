import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("------- MENU DE EXERCÍCIOS ------");
            System.out.println("escolha uma opção:");
            System.out.println("\n1-Ex01  2-Ex02  3-Ex03  4-Ex04  5-Ex05  6-Ex06  0-Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1: System.out.println(Arrays.toString(ex01())); break;
                case 2: System.out.println(Arrays.toString(ex02())); break;
                case 3: System.out.println(Arrays.toString(ex03())); break;
                case 4: int[] v = ex04(); System.out.println(Arrays.toString(v)); System.out.println("Media: " + calcularMedia(v)); break;
                case 5: exibirMatriz(ex05()); break;
                case 6: int[][][] r = ex06(); exibirMatriz(r[0]); exibirMatriz(r[1]); exibirMatriz(r[2]); break;
            }
        }
    }

    /**
     * Metodo auxiliar para ler e validar entrada do usuario
     * @param scanner Scanner para leitura
     * @param mensagem Mensagem a ser exibida
     * @param min Valor minimo (exclusivo)
     * @param max Valor maximo (inclusivo)
     * @return Valor valido lido
     */
    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        int valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextInt();
        } while (valor <= min || valor > max);
        return valor;
    }

    /**
     * Metodo auxiliar para exibir matriz formatada
     * @param matriz Matriz a ser exibida
     */
    private static void exibirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.printf("%4d ", valor);
            }
            System.out.println();
        }
    }

    /**
     * Exercicio 01: Progressao Geometrica
     * @param valorInicial Valor inicial (deve ser <= 20)
     * @return Vetor de 10 elementos com progressao geometrica (triplo) ou null se invalido
     */
    public static int[] progressaoGeometrica(int valorInicial) {
        if (valorInicial > 20) return null;
        int[] N = new int[10];
        N[0] = valorInicial;
        for (int i = 1; i < 10; i++) N[i] = N[i-1] * 3; // mudou pra triplo
        return N;
    }

    /**
     * Exercicio 02: Sequencia Decrescente
     * @param valorInicial Valor inicial (deve ser > 1)
     * @return Vetor de 10 elementos com sequencia decrescente ou null se invalido
     */
    public static int[] sequenciaDecrescente(int valorInicial) {
        if (valorInicial <= 1) return null;
        int[] N = new int[10];
        for (int i = 0; i < 10; i++) N[i] = valorInicial - (i * 2); // agora decresce de 2 em 2
        return N;
    }

    /**
     * Exercicio 03: Vetor Dinamico
     * @param tamanho Tamanho do vetor (deve ser <= 1000)
     * @return Vetor com sequencia de pares ou null se invalido
     */
    public static int[] vetorDinamico(int tamanho) {
        if (tamanho > 1000) return null;
        int[] N = new int[tamanho];
        for (int i = 0; i < tamanho; i++) N[i] = (i + 1) * 2; // agora só pares
        return N;
    }

    /**
     * Exercicio 04: Sequencia Crescente com Soma
     * @param valorInicial Valor inicial
     * @return Vetor de 10 elementos com sequencia crescente
     */
    public static int[] sequenciaCresenteComSoma(int valorInicial) {
        int[] N = new int[10];
        for (int i = 0; i < 10; i++) N[i] = valorInicial + (i * 2); // cresce de 2 em 2
        return N;
    }

    /**
     * Calcula a soma de todos os elementos do vetor
     * @param vetor Vetor para calcular a soma
     * @return Soma de todos os elementos
     */
    public static double calcularMedia(int[] vetor) {
        int soma = 0;
        for (int v : vetor) soma += v;
        return (double) soma / vetor.length; // troquei soma por media
    }

    /**
     * Exercicio 05: Matriz com Valores Incrementais
     * @param tamanho Tamanho da matriz quadrada
     * @return Matriz NxN com valores incrementais iniciando em 1
     */
    public static int[][] matrizIncrementais(int tamanho) {
        int[][] N = new int[tamanho][tamanho];
        int contador = 1; // começa do 1 agora
        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < tamanho; j++)
                N[i][j] = contador++;
        return N;
    }

    /**
     * Exercicio 06: Operacao entre Matrizes
     * @param tamanho Tamanho das matrizes quadradas
     * @return Array com 3 matrizes: [0]=N, [1]=Z, [2]=Multiplicacao
     */
    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        int[][] N = new int[tamanho][tamanho];
        int[][] Z = new int[tamanho][tamanho];
        int[][] Resultado = new int[tamanho][tamanho];

        int contador = 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                N[i][j] = contador;
                Z[i][j] = contador + 1;
                Resultado[i][j] = N[i][j] * Z[i][j]; // agora é multiplicação
                contador++;
            }
        }

        return new int[][][]{N, Z, Resultado};
    }

    // ========================================
    // METODOS REQUERIDOS PELO AUTOGRADER
    // NAO REMOVER - Necessarios para avaliacao automatica
    // ========================================

    public static int[] ex01() {
        Scanner scanner = new Scanner(System.in);
        int valorInicial = lerValor(scanner, "Valor (<=20): ", Integer.MIN_VALUE, 20);
        return progressaoGeometrica(valorInicial);
    }

    public static int[] ex02() {
        Scanner scanner = new Scanner(System.in);
        int valorInicial = lerValor(scanner, "Valor (1<v<100): ", 1, 99);
        return sequenciaDecrescente(valorInicial);
    }

    public static int[] ex03() {
        Scanner scanner = new Scanner(System.in);
        int tamanho = lerValor(scanner, "Valor (1<v<=1000): ", 1, 1000);
        return vetorDinamico(tamanho);
    }

    public static int[] ex04() {
        Scanner scanner = new Scanner(System.in);
        int valorInicial = lerValor(scanner, "Valor (1<v<100): ", 1, 99);
        return sequenciaCresenteComSoma(valorInicial);
    }

    public static int[][] ex05() {
        Scanner scanner = new Scanner(System.in);
        int tamanho = lerValor(scanner, "Valor (3<v<=50): ", 3, 50);
        return matrizIncrementais(tamanho);
    }

    public static int[][][] ex06() {
        Scanner scanner = new Scanner(System.in);
        int tamanho = lerValor(scanner, "Valor (3<v<=50): ", 3, 50);
        return operacaoEntreMatrizes(tamanho);
    }
}

