package ui;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import model.Person;

public class PrincipalController {
	//RELATIONS
	@FXML
    private BorderPane mainPanel;
	//===============================================
	/**
	 * window = 1, if AddWindow is open.<br>
	 * window = 2; if DeleteWindow is open.<br>
	 * window = 3, if SearchWindow by name  is open.<br>
	 * window = 4, if search by last name is open.<br>
	 * window = 5, if search by full name is open.<br>
	 * window = 6, if search by code.<br>
	 * window = 7; if UpdateWindw is open.<br>
	 */
	private int window = 0;

	/**
	 * this variable have the code of person selected on the table.<br>
	 */
	private String codeTemp = "";
	
	private Person p = null;
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
    private Label code;
	
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
    //READ WINDOW
    @FXML
    private Label codeR;

    @FXML
    private Label nameR;

    @FXML
    private Label lastaNameR;

    @FXML
    private Label genderR;

    @FXML
    private Label birthdayDateR;

    @FXML
    private Label heightR;

    @FXML
    private Label nationR;

    @FXML
    private ImageView photo;
    //===============================================================
	public PrincipalController() {
		
	}
	
	/**
	 *this method initialize the tableView at search windows.<br>
	 */
	public void initTable() {
		ObservableList<Person>temp = FXCollections.observableArrayList(
				new Person("1234", "Julian", "Rivera", 'M', "2001/11/29", 171, "Colombiano"),
				new Person("4567", "David", "Jhun", 'M', "2000/02/15", 172, "Coreano"),
				new Person("1596", "David", "Fiat", 'M', "1999/08/12", 175, "Español"),
				new Person("1468", "Rosa", "Melano", 'F', "2006/06/06", 150, "Sueca"));
		
		codigoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("code"));
		nombreCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		apellidoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		sexoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("sex"));
		table.setItems(temp);
		
		addButtonToTable();
	}
	
	/*
	 *this method put a button in each row of the tableView. <br>
	 */
	private void addButtonToTable() {
        Callback<TableColumn<Person, Void>, TableCell<Person, Void>> cellFactory = new Callback<TableColumn<Person, Void>, TableCell<Person, Void>>() {
            @Override
            public TableCell<Person, Void> call(final TableColumn<Person, Void> param) {
                final TableCell<Person, Void> cell = new TableCell<Person, Void>() {

                    private final Button btn = new Button("Editar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                        	p = getTableView().getItems().get(getIndex());
                        	update(event);
                        	System.out.println(p.getName());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        btCol.setCellFactory(cellFactory);

    }
	public void getUpdate() {
		if (p != null) {
			codeTemp = p.getCode();
			naFieldUpdate.setText(p.getName());
			laFiedlUpdate.setText(p.getLastName());
			if (p.getSex() == Person.MASCULINE) {
				maleUpdate.setSelected(true);
			}else {
				femaleUpdate.setSelected(true);
			}
			String aux = p.getDate();
			String[] temp = aux.split("/");
			int day = Integer.parseInt(temp[2]);
			int month = Integer.parseInt(temp[1]);
			int year = Integer.parseInt(temp[0]);
			
			birthdayUpdate.setValue(LocalDate.of(year, Month.of(month), day));
			heFieldUpdate.setText(String.valueOf(p.getHeight()));
			nationFUpdate.setText(p.getNationality());
		}
	}
	
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
				mainPanel.getChildren().clear();
				mainPanel.setCenter(root);
				window = 1;
				
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
     * this method saves the entered information of a new user. <br>
     * @param event
     */
    @FXML
    void save(ActionEvent event) {
    	System.err.println("Funcionalidad proximamente");
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
    			if (p == null) {
					Alert alert = new Alert(AlertType.WARNING);
	    			alert.setTitle("WARNING");
	    			alert.setHeaderText("Debe primero seleccionar una persona de la tabla");
	    			alert.setContentText(null);
	    			alert.showAndWait();
				}else {
					Parent root = fxml.load();
					window = 2;
					mainPanel.getChildren().clear();
					mainPanel.setCenter(root);
					
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
     * this method remove a object of system. <br>
     */
    public void remove() {
    	if (p !=null) {
    		codeTemp = p.getCode();
			code.setText(codeTemp);
			name.setText(p.getName());
			lastaName.setText(p.getLastName());
			if (p.getSex() == Person.MASCULINE) {
				gender.setText("Masculino");
			}else {
				gender.setText("Femenino");
			}
			birthdayDate.setText(p.getDate());
			height.setText(String.valueOf(p.getHeight()));
			nation.setText(p.getNationality());
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Se ha eliminado la persona del sistema");
			alert.showAndWait();
			
			p = null;
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
    			mainPanel.getChildren().clear();
				mainPanel.setCenter(root);
				window = 3;
    			initTable();
				
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
    	if (window != 4) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SearchWindow2.fxml"));
    		fxml.setController(this);
    		
    		try {
    			Parent root = fxml.load();
    			mainPanel.getChildren().clear();
				mainPanel.setCenter(root);
				window = 4;
				initTable();
				
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
    	if (window != 5) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SearchWindow3.fxml"));
    		fxml.setController(this);
    		
    		try {
    			Parent root = fxml.load();
    			mainPanel.getChildren().clear();
				mainPanel.setCenter(root);
				window = 5;
				initTable();
				
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
    	if (window != 6) {
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("SearchWindow4.fxml"));
    		fxml.setController(this);
    		
    		try {
    			Parent root = fxml.load();
    			mainPanel.getChildren().clear();
				mainPanel.setCenter(root);
				window = 6;
				initTable();
				
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
	 */
    @FXML
	void update(ActionEvent event) {
    	if (window != 7) {
    		
    			FXMLLoader fxml = new FXMLLoader(getClass().getResource("UpdateWindow.fxml"));
        		fxml.setController(this);
        		
        		try {
        			if (p == null) {
    				Alert alert = new Alert(AlertType.WARNING);
    	    			alert.setTitle("WARNING");
    	    			alert.setHeaderText("Debe primero seleccionar una persona de la tabla");
    	    			alert.setContentText(null);
    	    			alert.showAndWait();
    				}else {
    					Parent root = fxml.load();
    					mainPanel.getChildren().clear();
    					mainPanel.setCenter(root);
    					window = 7;
						getUpdate();
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
     * this method update a object in the system.<br>
     * @param event
     */
    @FXML
    void actualize(ActionEvent event) {
    	String name = naFieldUpdate.getText();
    	String last = laFiedlUpdate.getText();
    	
    	char sex = ' ';
    	if (maleUpdate.isSelected()) {
			sex = Person.MASCULINE;
		}if (femaleUpdate.isSelected()) {
			sex = Person.FEMENINE;
		}
		LocalDate temp = birthdayUpdate.getValue();
		String date = String.valueOf(temp);
		
		int height = Integer.parseInt(heFieldUpdate.getText());
		String nation = nationFUpdate.getText();
		getNewPerson(new Person(null, name, last, sex, date, height, nation));
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Se ha actualizado la persona en el sistema");
		alert.setHeaderText(null);
		alert.showAndWait();
		
		p = null;
    }
    
    public Person getNewPerson(Person p) {
    	p.setCode(codeTemp);
    	return p;
    }
    
    void showing() {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("ReadWindow.fxml"));
		fxml.setController(this);
		 
		try {
				Parent root = fxml.load();
				Stage stage = new Stage();
				Scene scene = new Scene(root);
		        stage.initModality(Modality.APPLICATION_MODAL);
		        stage.initStyle(StageStyle.DECORATED);
		        stage.setTitle("VISUALIZACION");
		        stage.setResizable(true);
		        stage.setScene(scene);
		        stage.show();
		        
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    @FXML
    void show(ActionEvent event) throws IOException {
    	Person temp = table.getSelectionModel().getSelectedItem();
    	if (temp !=null) {
			showing();
			nameR.setText(temp.getName());
			lastaNameR.setText(temp.getLastName());
			codeR.setText(temp.getCode());
			
			if (temp.getSex() == Person.MASCULINE) {
				genderR.setText("Masculino");
			}else {
				genderR.setText("Femenino");
			}
			birthdayDateR.setText(temp.getDate());
			heightR.setText(String.valueOf(temp.getHeight()));
			nationR.setText(temp.getNationality());
			
			loadImage();
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText("Primero debes buscar una persona y seleccionarla");
			alert.setContentText(null);
			alert.showAndWait();
		}
    }
    
    public void loadImage() throws IOException {
    	String page = "https://thispersondoesnotexist.com/image";
        URL url = new URL(page);
        /*final HttpURLConnection image = (HttpURLConnection) url
                .openConnection();
        image.setRequestProperty(
                "User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
        Image picture = SwingFXUtils.toFXImage(bufferedImage, null);*/
      
        //ImageIcon intento = new ImageIcon(url);
        Image picture = new Image(page);
        photo.setImage(picture);
    }
}
