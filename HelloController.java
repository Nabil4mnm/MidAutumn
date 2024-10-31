package cse213.midautumn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.event.ChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class HelloController {

    @FXML
    private ComboBox<String> QuantityComboBox;
    @FXML
    private DatePicker DeliveryPicker;
    @FXML
    private TextField ProductIDTextField;
    @FXML
    private TableView<Product> ItemTableView;
    @FXML
    private TableColumn<Product,Integer> ProductIDColumn;
    @FXML
    private TableColumn<Product,Integer > QuantityColumn;
    @FXML
    private TableColumn<Product,String> MaterialColumn;
    @FXML
    private TableColumn<Product,String> ProductNameColumn;
    @FXML
    private ComboBox<String> MaterialComboBox;
    @FXML
    private TextField ProductNameTextField;

    private ArrayList<Product> products = new ArrayList<>();

    @FXML
    public void initialize() {
        QuantityComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        MaterialComboBox.getItems().addAll("Wood","Cloth","Metal","Board","Other");
        ProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ProductIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        MaterialColumn.setCellValueFactory(new PropertyValueFactory<>("Material"));
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));




    }

    @FXML
    public void AddProductButton(ActionEvent actionEvent) {
        String name;
        if (!ProductNameTextField.getText().isEmpty()) {
            name = ProductNameTextField.getText();

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");

        }
        int ID;
        if (!ProductIDTextField.getText().isEmpty()) {
            ID = Integer.parseInt(ProductIDTextField.getText());
            for (Product product : products) {
                if (product.getId() == ID) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("ID Duplicate");

                }
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
        }
        String Material;
        if (!MaterialComboBox.getSelectionModel().getSelectedItem().isEmpty()) {
            Material = MaterialComboBox.getSelectionModel().getSelectedItem();

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");

        }
        String Quantity;
        if (!QuantityComboBox.getSelectionModel().getSelectedItem().isEmpty()) {
            Quantity = QuantityComboBox.getSelectionModel().getSelectedItem();

        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");

        }
        LocalDate date;
        if (DeliveryPicker.getValue() == null) {
            date = DeliveryPicker.getValue();
            if (date.isBefore(LocalDate.now())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Date cannot be from past");
            }


        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
        }
        Product item = new Product(name,ID,Material,Quantity);
        products.add(item);
        ItemTableView.getItems().add(item);





    }
}