package org.example;

/**
 * Launcher que delega en {@link App}. Útil para ejecutar desde el IDE
 * sin problemas de "JavaFX runtime components are missing".
 */
public class Main {
    public static void main(String[] args) {
        App.main(args);
    }
}
