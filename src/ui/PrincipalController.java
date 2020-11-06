package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PrincipalController {
	//RELATIONS
	@FXML
    private BorderPane mainPanel;
	//===============================================
	/**
	 * window = 1, if AddWindow is open.<br>
	 * window = 2; if DeleteWindow is open.<br>
	 * window = 3, if SearchWindow is open.<br>
	 * window = 4; if UpdateWindw is open.<br>
	 */
	private int window = 0;
	
	//=============================================================
	//ADD WINDOW
	@FXML
	private BorderPane addPanel;

	@FXML
	private TextField nameField;

	@FXML
	private TextField lastNField;

	@FXML
	private RadioButton male;

	@FXML
	private RadioButton female;

	@FXML
	private DatePicker birthday;

	@FXML
	private TextField heightField;

	@FXML
	private TextField nationalityField;
	//=============================================================
	//DELETE WINDOW
	@FXML
    private BorderPane deletePanel;

    @FXML
    private Label name;

    @FXML
    private Label lastaName;

    @FXML
    private Label gender;

    @FXML
    private Label birthdayDate;

    @FXML
    private Label height;

    @FXML
    private Label nation; 
    //===========================================================
    //UPDATE WINDOW
    @FXML
    private BorderPane updatePanel;

    @FXML
    private TextField naFieldUpdate;

    @FXML
    private TextField laFiedlUpdate;

    @FXML
    private RadioButton maleUpdate;

    @FXML
    private RadioButton femaleUpdate;

    @FXML
    private DatePicker birthdayUpdate;

    @FXML
    private TextField heFieldUpdate;

    @FXML
    private TextField nationFUpdate;
    //===============================================================
    //SEARCH WINDOW 
    @FXML
    private BorderPane searchPanel;
    
    @FXML
    private Label numberParam;
    
    @FXML
    private TextField completeField;
    
    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> codigoCol;

    @FXML
    private TableColumn<Person, String> nombreCol;

    @FXML
    private TableColumn<Person, String> apellidoCol;

    @FXML
    private TableColumn<Person, String> sexoCol;
    
    @FXML
    private TableColumn<Person, Void> btCol;
    //===============================================================
	public PrincipalController() {
		
	}
	/*
	public void initTable() {
		/ObservableList<Person>temp = FXCollections.observableArrayList(new Person("Julian", "1234", "Rivera", 'M'), new Person("David", "Fiat"), new Person("Johan"));
		
		column1.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		column2.setCellValueFactory(new PropertyValueFactory<Person, Button>("bt"));
		
		table.setItems(temp);
	}*/
	
	/**
	 * This method open the ADD interface.<br>
	 * @param event
	 */
    @FXML
    void add(ActionEvent event) {
    	if (window != 1) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("AddWindow.fxml"));
    		fxml.setController(this);
    		
    		try {
				Parent root = fxml.load();
				window = 1;
				
				switch (window) {
				case 2:
					deletePanel.getChildren().clear();
					deletePanel.setCenter(root);
					break;
				case 3:
					searchPanel.getChildren().clear();
					searchPanel.setCenter(root);
					break;
				case 4:
					updatePanel.getChildren().clear();
					updatePanel.setCenter(root);
					break;
				default:
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					break;
				}
				
			} catch (IOException io) {
				io.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Intento de acceder a una opcion en uso");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }

    /**
	 * This method open the DELETE interface.<br>
	 * @param event
	 */
    @FXML
    void delete(ActionEvent event) {
    	if (window != 2) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("DeleteWindow.fxml"));
    		fxml.setController(this);
    		
    		try {
				Parent root = fxml.load();
				window = 2;
				
				switch (window) {
				case 1:
					addPanel.getChildren().clear();
					addPanel.setCenter(root);
					break;
				case 3:
					searchPanel.getChildren().clear();
					searchPanel.setCenter(root);
					break;
				case 4:
					updatePanel.getChildren().clear();
					updatePanel.setCenter(root);
					break;
				default:
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					break;
				}
				
			} catch (IOException io) {
				io.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Intento de acceder a una opcion en uso");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }

    /**
	 * This method open the SEARCH interface by name.<br>
	 * @param event
	 */
    @FXML
    void searchByName(ActionEvent event) {
    	if (window != 3) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SearchWindow.fxml"));
    		fxml.setController(this);
    		
    		try {
    			Parent root = fxml.load();
    			//initTable();
				window = 3;
				
				switch (window) {
				case 1:
					addPanel.getChildren().clear();
					addPanel.setCenter(root);
					break;
				case 2:
					deletePanel.getChildren().clear();
					deletePanel.setCenter(root);
					break;
				case 4:
					updatePanel.getChildren().clear();
					updatePanel.setCenter(root);
					break;
				default:
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					break;
				}
				
			} catch (IOException io) {
				io.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Intento de acceder a una opcion en uso");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }

    /**
	 * This method open the SEARCH interface by last name.<br>
	 * @param event
	 */
    @FXML
    void searchByLastName(ActionEvent event) {
    	if (window != 3) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SearchWindow2.fxml"));
    		fxml.setController(this);
    		
    		try {
    			Parent root = fxml.load();
				window = 3;
				
				
				switch (window) {
				case 1:
					addPanel.getChildren().clear();
					addPanel.setCenter(root);
					break;
				case 2:
					deletePanel.getChildren().clear();
					deletePanel.setCenter(root);
					break;
				case 4:
					updatePanel.getChildren().clear();
					updatePanel.setCenter(root);
					break;
				default:
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					break;
				}
				
			} catch (IOException io) {
				io.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Intento de acceder a una opcion en uso");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }
    
    /**
	 * This method open the SEARCH interface by full name.<br>
	 * @param event
	 */
    @FXML
    void searchByFullName(ActionEvent event) {
    	if (window != 3) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SearchWindow3.fxml"));
    		fxml.setController(this);
    		
    		try {
    			Parent root = fxml.load();
				window = 3;
				
				switch (window) {
				case 1:
					addPanel.getChildren().clear();
					addPanel.setCenter(root);
					break;
				case 2:
					deletePanel.getChildren().clear();
					deletePanel.setCenter(root);
					break;
				case 4:
					updatePanel.getChildren().clear();
					updatePanel.setCenter(root);
					break;
				default:
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					break;
				}
				
			} catch (IOException io) {
				io.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Intento de acceder a una opcion en uso");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }
    
    /**
	 * This method open the SEARCH interface by code.<br>
	 * @param event
	 */
    @FXML
    void searchByCode(ActionEvent event) {
    	if (window != 3) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SearchWindow4.fxml"));
    		fxml.setController(this);
    		
    		try {
    			Parent root = fxml.load();
				window = 3;
				
				switch (window) {
				case 1:
					addPanel.getChildren().clear();
					addPanel.setCenter(root);
					break;
				case 2:
					deletePanel.getChildren().clear();
					deletePanel.setCenter(root);
					break;
				case 4:
					updatePanel.getChildren().clear();
					updatePanel.setCenter(root);
					break;
				default:
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					break;
				}
				
			} catch (IOException io) {
				io.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Intento de acceder a una opcion en uso");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }
    /**
	 * This method open the UPDATE interface.<br>
	 * @param event
	 */
    @FXML
	void update(ActionEvent event) {
    	if (window != 4) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("UpdateWindow.fxml"));
    		fxml.setController(this);
    		
    		try {
				Parent root = fxml.load();
				window = 4;
				
				switch (window) {
				case 1:
					addPanel.getChildren().clear();
					addPanel.setCenter(root);
					break;
				case 2:
					deletePanel.getChildren().clear();
					deletePanel.setCenter(root);
					break;
				case 3:
					searchPanel.getChildren().clear();
					searchPanel.setCenter(root);
					break;
				default:
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					break;
				}
			} catch (IOException io) {
				io.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Intento de acceder a una opcion en uso");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }
}
