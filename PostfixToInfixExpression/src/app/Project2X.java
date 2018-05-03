/*
* File: Project2X.java
* Author: Mohamed Nheri
* Date: 04/06/2018
* Purpose: This class will constrcut the Gui of the application 
* and process the evaluation based on user input
*/
package app;

import java.awt.event.ActionEvent;
import javax.swing.*;


public class Project2X {
    //Declaring the component variables of the GUI
    private JFrame      frmProject;
    private JPanel      pnlMain;
    
    private JLabel      lblPostfix;
    private JTextField  txtPostfix;

    private JButton     btnConstruct;    

    private JLabel      lblInfix;
    private JTextField  txtInfix;
    
    /**
     * Metthod that will initialize the GUI 
     * of the application
     */
    private void InitializeUI(){
        frmProject = new JFrame("Infix expression Generator");
        frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlMain = (JPanel) frmProject.getContentPane();
        frmProject.setLayout(null);
        
        lblPostfix = new JLabel("Enter Postfix Expression");
        lblPostfix.setBounds(10, 10, lblPostfix.getPreferredSize().width, lblPostfix.getPreferredSize().height);
        pnlMain.add(lblPostfix);
        
        txtPostfix = new JTextField("", 20);
        txtPostfix.setBounds(160, 10, txtPostfix.getPreferredSize().width, txtPostfix.getPreferredSize().height);
        pnlMain.add(txtPostfix);

        btnConstruct = new JButton("Construct Tree");
        btnConstruct.setBounds(150,50, btnConstruct.getPreferredSize().width, btnConstruct.getPreferredSize().height);
        
        btnConstruct.addActionListener((ActionEvent e) -> {
            clickedBtnConstruct();
        });
        pnlMain.add(btnConstruct);
        
        lblInfix = new JLabel ("Infix Expression");
        lblInfix.setBounds(10, 100, lblInfix.getPreferredSize().width, lblInfix.getPreferredSize().height); 
        pnlMain.add(lblInfix);
                
        txtInfix = new JTextField("", 20);
        txtInfix.setBounds(160, 100, txtInfix.getPreferredSize().width, txtInfix.getPreferredSize().height);
        pnlMain.add(txtInfix);
                
        frmProject.setSize(420,180);
        frmProject.setVisible(true); 
    }
    
    /**
     * Method that will evalute the postfix expression
     *based on user input
     */
    private void clickedBtnConstruct(){
        Expression expression = new Expression();
        txtInfix.setText(expression.analyze(txtPostfix.getText()));
    } 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Project2X project = new Project2X();
        project.InitializeUI();
    }//end of main
    
}//end of class
