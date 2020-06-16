package com.velotn.ui.back.events;

import com.velotn.entity.Evenement;
import com.velotn.service.ServiceEvenement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewEventsController implements Initializable {

    @FXML
    private TableColumn<Evenement, String> nomE;

    @FXML
    private TableColumn<Evenement, Date> heureE;

    @FXML
    private TableColumn<Evenement, Date> dateE;

    @FXML
    private TableColumn<Evenement,Integer> id;

    @FXML
    private TableView<Evenement> listeEvenements;

    @FXML
    private TableColumn<Evenement, String> descriptionE;

    ServiceEvenement se = new ServiceEvenement();

    private final ObservableList<Evenement> data = FXCollections.observableArrayList();
    private List<Evenement> evenements = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listeEvenements();
        } catch (SQLException ex) {
            Logger.getLogger(ViewEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listeEvenements() throws SQLException {
        listeEvenements.setItems(null);
        data.clear();
        evenements = se.readAll();

        for (Evenement evenement : evenements) {
            data.add(evenement);
        }

        //id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomE.setCellValueFactory(new PropertyValueFactory<>("nom"));
        /*heureE.setCellValueFactory(new PropertyValueFactory<>("heure"));
        dateE.setCellValueFactory(new PropertyValueFactory<>("date"));*/
        descriptionE.setCellValueFactory(new PropertyValueFactory<>("description"));

        listeEvenements.setItems(data);
        listeEvenements.setEditable(true);

        //id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nomE.setCellFactory(TextFieldTableCell.forTableColumn());
        /*heureE.setCellFactory(TextFieldTableCell.forTableColumn(new TimeStringConverter()));
        dateE.setCellFactory(TextFieldTableCell.forTableColumn());*/
        descriptionE.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    @FXML
    void SupprimerEvenement(ActionEvent event) throws SQLException
    {
        ObservableList<Evenement> tous,Single ;
        tous=listeEvenements.getItems();
        Single=listeEvenements.getSelectionModel().getSelectedItems();
        Evenement e = Single.get(0);
        se.delete(e);
        Single.forEach(tous::remove);
    }
    public void Change_nom(TableColumn.CellEditEvent bb) throws SQLException{
        Evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
        Evenementselected.setNom((bb.getNewValue().toString()));
        se.update(Evenementselected);
    }
    public void Change_heure(TableColumn.CellEditEvent bb) throws SQLException{
        Evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
        Evenementselected.setHeure(Time.valueOf(bb.getNewValue().toString()));
        se.update(Evenementselected);
    }
    public void Change_date(TableColumn.CellEditEvent bb) throws SQLException{
        Evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
        Evenementselected.setDate(Date.valueOf(bb.getNewValue().toString()));
        se.update(Evenementselected);
    }
    public void Change_desc(TableColumn.CellEditEvent bb) throws SQLException{
        Evenement Evenementselected = listeEvenements.getSelectionModel().getSelectedItem();
        Evenementselected.setDescription((bb.getNewValue().toString()));
        se.update(Evenementselected);
    }
   /*public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<evenement> filteredData = new FilteredList<>(data, b -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(evenements -> {
				// If filter text is empty, display all persons.

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (evenements.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (evenements.getHeure().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
                                } else if (evenements.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
                                } else if (evenements.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
                                }
				     else
				    	 return false; // Does not match.
			});
		});

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<evenement> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(readAll.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		readAll.setItems(sortedData);
    }
    */

}
