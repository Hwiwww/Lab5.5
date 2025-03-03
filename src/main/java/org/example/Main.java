package org.example;

import org.example.system.Console;

import java.io.File;


public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        console.start(System.in, args);
    }
}