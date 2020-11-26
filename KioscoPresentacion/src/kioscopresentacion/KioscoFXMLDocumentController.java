/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioscopresentacion;

import control.FacadeLibreria;
import entidades.DTOConsulta;
import entidades.DTOReporte;
import entidades.DTOResumen;
import entidades.Denominacion;
import entidades.Libro;
import entidades.Linea;
import interfaces.IFacadeLibreria;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cacab
 */
public class KioscoFXMLDocumentController implements Initializable {

    private IFacadeLibreria facadeLibreria = new FacadeLibreria();

    @FXML
    private Label LAfechahora;
    @FXML
    private Label LANumPrestamo;
    @FXML
    private ComboBox<Libro> ComboLibros;

    private final ObservableList<Libro> libros = FXCollections.observableArrayList();

    @FXML
    private TextField TXTCantidad;
    @FXML
    private TableView<Linea> TALineas;

    private final ObservableList<Linea> diomedes = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Linea, Libro> CLibro;
    @FXML
    private TableColumn<Linea, Integer> CCantidad;
    @FXML
    private TableColumn<Linea, Double> CPrecio;
    @FXML
    private TableColumn<Linea, Double> Csubtotal;
    @FXML
    private Button BTNEliminar;
    @FXML
    private TextField TXTCantidadMonedas;
    @FXML
    private ComboBox<Denominacion> CBDenominacion;

    private final ObservableList<Denominacion> monedas = FXCollections.observableArrayList();

    @FXML
    private Button BTNAgregarMonedas;
    @FXML
    private Label LAVueltos;
    @FXML
    private Button BTNConsultar;
    @FXML
    private TextField TXTNumPrestamo;
    @FXML
    private Text txtNumprestamo;
    @FXML
    private Label LAError;
    @FXML
    private Button BTNGenerarReporte;
    @FXML
    private Button BTNTerminarPrestamo;
    @FXML
    private Button BTNNuevoPrestamo;
    @FXML
    private Button BTNAgregarLinea;

    /**
     * Initializes the controller class.
     */
    private void configureTable() {
        PropertyValueFactory<Linea, Libro> NombreLibro = new PropertyValueFactory<Linea, Libro>("Libro");
        CLibro.setCellValueFactory(NombreLibro);
        PropertyValueFactory<Linea, Integer> CantidadLibro = new PropertyValueFactory<Linea, Integer>("Cantidad");
        CCantidad.setCellValueFactory(CantidadLibro);
        PropertyValueFactory<Linea, Double> PrecioLibro = new PropertyValueFactory<Linea, Double>("Precio");
        CPrecio.setCellValueFactory(PrecioLibro);
        PropertyValueFactory<Linea, Double> SubTotalLibro = new PropertyValueFactory<Linea, Double>("SubTotal");
        Csubtotal.setCellValueFactory(SubTotalLibro);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LocalDateTime localDate = LocalDateTime.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy hh:mm a");
        String formattedString = localDate.format(formatter);
        this.LAfechahora.setText(formattedString);
        final List<Libro> libro = this.facadeLibreria.getCatalogo();
        libros.setAll(libro);
        ComboLibros.setItems(libros);
        final List<Denominacion> dens = new ArrayList<>();
        for (Denominacion den : Denominacion.values()) {
            dens.add(den);
        }
        monedas.setAll(dens);
        CBDenominacion.setItems(monedas);
        configureTable();
    }

    @FXML
    private void NuevoPrestamo(ActionEvent event) {
        if (this.facadeLibreria.crearNuevoPrestamo()) {
            this.LAError.setText("PRESTAMO CREADO CORRECTAMENTE");
        } else {
            this.LAError.setText("EL PRESTAMO NO HA SIDO CREADO CORRECTAMENTE");
        }
    }

    @FXML
    private void cantidadLibros(ActionEvent event) {
    }

    @FXML
    private void AgregarLinea(ActionEvent event) {
        int numi = Integer.valueOf(this.TXTCantidad.getText());
        Libro libro = this.ComboLibros.getValue();
        DTOResumen resumen = this.facadeLibreria.agregarLinea(libro, numi);
        if (resumen.getMensaje() == null) {
            diomedes.setAll(resumen.getLineas());
            TALineas.setItems(diomedes);
        } else {
            this.LAError.setText(resumen.getMensaje());
        }
    }

    @FXML
    private void EliminarLinea(ActionEvent event) {
        Linea linea = this.TALineas.getSelectionModel().getSelectedItem();
        DTOResumen informe = this.facadeLibreria.eliminarLinea(linea);
    }

    @FXML
    private void AgregarMonedas(ActionEvent event) {
        int numi = Integer.valueOf(this.TXTCantidad.getText());
        Denominacion den = this.CBDenominacion.getValue();
        DTOResumen resumen = this.facadeLibreria.introducirMonedas(den, numi);
        if (resumen.getMensaje() == null) {
            diomedes.setAll(resumen.getLineas());
            TALineas.setItems(diomedes);
        } else {
            this.LAError.setText(resumen.getMensaje());
        }
    }

    @FXML
    private void consultarPrestamo(ActionEvent event) {
    }


    @FXML
    private void generarReporte(ActionEvent event) {
        DTOReporte reporte = facadeLibreria.reporteDiario();
    }

    @FXML
    private void TerminarPrestamo(ActionEvent event) {
        DTOResumen consulta = this.facadeLibreria.terminarPrestamo();
    }


}
