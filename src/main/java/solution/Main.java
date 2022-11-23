package solution;

import java.util.Scanner;

class Solution {
    int insertSorted(int arr[], int n, int key, int capacity) {
        int i;

        if (n >= capacity)
            return n;

        for (i = n - 1; (i >= 0 && arr[i] > key); i--) {
            arr[i + 1] = arr[i];
        }

        arr[i + 1] = key;

        return (n + 1);
    }

    public int findKthLargest(int[] v, int kthV) {
        int n = 1;

        for (int i = 1; i < v.length; i++) {
            n = this.insertSorted(v, n, v[i], v.length);
        }

        if(kthV > v.length || kthV <= 0)
            return v[v.length-1]; // return biggest in array

        return v[v.length - kthV]; // return what user wants
    }
}

public class Main {

    public static void main(String[] args) {
        int numOfElements;
        int n = 1;

        Scanner s = new Scanner(System.in);

        System.out.println("Informe o tamanho do vetor desejado: ");
        numOfElements = s.nextInt();

        int arr[] = new int[numOfElements];
        Boolean arrayIsEmpty = true;
        Solution solution = new Solution();

        for (int i = 0; i < numOfElements; i++) {

            System.out.println("Informe o valor a ser inserido no vetor:");

            if (arrayIsEmpty) {
                arr[0] = s.nextInt();
                arrayIsEmpty = false;
            } else {
                n = solution.insertSorted(arr, n, s.nextInt(), numOfElements);
            }
        }

        System.out.println("Valores inseridos:");
        for (int i = 0; i < numOfElements; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nBuscar qual Kesimo (nEzimo maior valor dentre todos) ?");
        int kezimoMaior = s.nextInt();
        System.out.println("\nKezimo {" + kezimoMaior + "} maior valor nesse vetor -> " + solution.findKthLargest(arr, kezimoMaior));

//        Solution solution = new Solution();
//
//        int arr[] = {5,4,3,2,1};

//        System.out.println(solution.findKthLargest(arr, 3));
    }
}
