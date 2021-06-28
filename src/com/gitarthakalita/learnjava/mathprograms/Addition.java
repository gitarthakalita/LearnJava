package com.gitarthakalita.learnjava.mathprograms;
import java.util.Scanner;

public class Addition {

    public static void main(String[] args) {
        int n1, n2, sum ;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        n1 = sc.nextInt();
        System.out.println("Enter the second number: ");
        n2 = sc.nextInt();
        sc.close();
        sum = n1 + n2;
        System.out.println("Sum of these numbers are: "+ sum);
    }
}
