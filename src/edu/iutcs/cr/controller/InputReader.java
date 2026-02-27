package edu.iutcs.cr.controller;

import java.util.Scanner;

/**
 * Singleton wrapper around a single shared {@link Scanner} reading from
 * {@code System.in}.
 * Eliminates scattered {@code new Scanner(System.in)} calls across the
 * codebase.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class InputReader {

    private static InputReader instance;
    private final Scanner scanner;

    private InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public String next() {
        return scanner.next();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public double nextDouble() {
        return scanner.nextDouble();
    }

    public boolean nextBoolean() {
        return scanner.nextBoolean();
    }
}
