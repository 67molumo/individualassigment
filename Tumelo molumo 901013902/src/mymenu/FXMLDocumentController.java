
package mymenu;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
      @FXML
    private TextField Amount_paid;

    @FXML
    private ComboBox<?> Combobox;

    @FXML
    private TextField DisplayChange;

    @FXML
    private TextField DisplayTotall;

    @FXML
    private Button change;

    @FXML
    private RadioButton chocolateCakebtn;

    @FXML
    private RadioButton cupcakesbtn;

    @FXML
    private RadioButton custardAndJellybtn;

    @FXML
    private Button exitbtn;
    
    @FXML
    private CheckBox marconBeefbtn;

    @FXML
    private Button resetbtn;

    @FXML
    private CheckBox riceBeefbtn;

    @FXML
    private CheckBox riceChickbtn;

    @FXML
    private Button totalbnt;

    
    
     double amount_paid;
     double total;
     double difference,price,price1;
     int var;
     String var2,foodName,dissertName;
    @FXML
    void CustardJellyClick(ActionEvent event)
    {
          try
        {
            if(custardAndJellybtn.isSelected())
               chocolateCakebtn.setSelected(false);
                cupcakesbtn.setSelected(false);
        }catch(NumberFormatException e)
        {
            System.out.println("Error "+e);
        }
        
        

    }

    @FXML
    void Exit(ActionEvent event)
    {
        System.exit(0);
        Platform.exit();

    }

    @FXML
    void Reset(ActionEvent event) 
    {
         DisplayTotall.setText("0");
         Amount_paid.setText("0");
         DisplayChange.setText("0");
       
          riceChickbtn.setSelected(false);
          riceBeefbtn.setSelected(false);
          marconBeefbtn.setSelected(false);
          custardAndJellybtn.setSelected(false);
          chocolateCakebtn.setSelected(false);
          cupcakesbtn.setSelected(false);
          
        

    }

    
   
       @FXML
    ComboBox<String>combobox;
    ObservableList<String>list=FXCollections.observableArrayList("Coke","Fanta","Sprite");

    @FXML
    void Totalresul(ActionEvent event) throws IOException 
    {
        try
        {
        
            if(riceBeefbtn.isSelected())
            {
                total=+130;
                price=130;
                foodName="RiceBeef";
            }
            if(riceChickbtn.isSelected())
            {
                total+=100;
                 price=100;
                foodName="RiceChicken";
            }
            if(marconBeefbtn.isSelected())
            {
                total+=150;
                 price=150;
                foodName="marcaronBeef";
            }
             if(custardAndJellybtn.isSelected())
            {
                total+=50;
                price1=50;
                dissertName="custard and Jelly";
            }
            else if(chocolateCakebtn.isSelected())
            {
                total+=20;
                price1=20;
                dissertName="chocolate cake";
            }
            else if(cupcakesbtn.isSelected())
            {
                total+=30;
                price1=30;
                dissertName="cupcake";
            }
             
           if("Coke".equals(combobox.getValue()))
             {
                 total+=20;
                 var=20;
                 var2="Coke";
             }
             if("Fanta".equals(combobox.getValue()))
             {
                 total+=23;
         
                 var=23;
                 var2="Fanta";
             }
             if("Sprite".equals(combobox.getValue()))
             {
                 total+=24;
                 var=24;
                 var2="Sprite";
             }
               DisplayTotall.setText(Double.toString(total));
                FileWriter output=new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\myMenu\\molumo.txt",true);
                output.write("-------------***MY MENU**-----------------M"+"\n");
                output.write( foodName+"--------------------------M"+price+"\n");
                output.write( dissertName+"------------------------M"+price1+"\n");
                output.write( var2+"-------------------------------M"+var+"\n");
                System.out.println("Data written succesfully");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("THE RECORD HAS BEEN SUCCESSFULY STORED IN A NOTEPAD");
                alert.showAndWait();
                        
                output.close();
             
        }catch(NumberFormatException e)
        {
            System.out.println("error "+e);
        }
    }

    @FXML
    void chocolatecakeClick(ActionEvent event) 
    {
         try
        {
             if(chocolateCakebtn.isSelected())
               custardAndJellybtn.setSelected(false);
                cupcakesbtn.setSelected(false);
          
            
            
        }catch(NumberFormatException e)
        {
            System.out.println("Error "+e);
        }
        

    }

    @FXML
    void cupcakesClick(ActionEvent event) 
    {
         try
        {
            if(cupcakesbtn.isSelected())
               custardAndJellybtn.setSelected(false);
                chocolateCakebtn.setSelected(false);
          
           
            
        }catch(NumberFormatException e)
        {
            System.out.println("Error "+e);
        }
        

    }

 
    @FXML
    void resultChange(ActionEvent event) 
    {
        try
        {
            amount_paid=Integer.parseInt(Amount_paid.getText());
            DisplayTotall.setText(Double.toString(total));
            difference= amount_paid-=total;
            DisplayChange.setText(Double.toString(difference));
        }catch(NumberFormatException e)
        {
            System.out.println("Error "+e);
        }
       
        

    }


    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        combobox.setItems(list);
    }    
   
    
}
