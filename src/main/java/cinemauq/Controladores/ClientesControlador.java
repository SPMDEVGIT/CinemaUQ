package cinemauq.Controladores;

import cinemauq.enumeraciones.TipoCliente;
import cinemauq.excepciones.CinemaException;
import cinemauq.modelo.Cliente;
import cinemauq.util.Alertas;
import cinemauq.util.Contexto;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Pestaña "Clientes": formulario de registro y tabla de clientes.
 */
public class ClientesControlador implements Recargable {

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<TipoCliente> cmbTipo;

    @FXML
    private TableView<Cliente> tabla;

    @FXML
    private TableColumn<Cliente, String> colIdentificacion;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colTipo;

    @FXML
    private void initialize() {
        cmbTipo.getItems().setAll(TipoCliente.values());
        colIdentificacion.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getIdentificacion()));
        colNombre.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre()));
        colTipo.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getTipoCliente().toString()));
        recargar();
    }

    @Override
    public void recargar() {
        tabla.getItems().setAll(Contexto.getCinema().getClientes());
    }

    /** Registra un cliente con los datos del formulario. */
    @FXML
    private void registrar() {
        try {
            Cliente cliente = new Cliente(txtIdentificacion.getText(), txtNombre.getText(),
                    cmbTipo.getValue());
            Contexto.getCinema().registrarCliente(cliente);
            txtIdentificacion.clear();
            txtNombre.clear();
            cmbTipo.setValue(null);
            recargar();
            Alertas.informacion("Cliente " + cliente.getNombre() + " registrado");
        } catch (CinemaException e) {
            Alertas.error(e.getMessage());
        }
    }
}