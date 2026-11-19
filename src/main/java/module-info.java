module cinemauq {
    requires javafx.controls;
    requires javafx.fxml;

    exports cinemauq;
    exports cinemauq.enumeraciones;
    exports cinemauq.excepciones;
    exports cinemauq.modelo;
    exports cinemauq.util;

    opens cinemauq.Controladores to javafx.fxml;

    // Necesario para que JUnit instancie las clases de test (que viven en estos paquetes)
    opens cinemauq.enumeraciones;
    opens cinemauq.modelo;
    opens cinemauq.util;
}
