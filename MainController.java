package application;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

import java.sql.SQLException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	public  MainModel mainModel = new MainModel();
	@FXML private Label lbl;
	@FXML private  TextField f_name;
	@FXML private  TextField f_sum;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int sum3 = mainModel.getSum();		
		lbl.setText(String.valueOf(sum3));
	}
	
	public void AddSum(ActionEvent event){
		
		String name = f_name.getText();		
		int sum = Integer.parseInt(f_sum.getText());
		
		try{
			mainModel.insertSum(name, sum);
			}
		
		catch (Exception e){
			
		}
		f_name.setText("");
		f_sum.setText("");
		int sum1 = mainModel.getSum();		
		lbl.setText(String.valueOf(sum1));
	
	}
}

