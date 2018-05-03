/*
* File: OperandNode.java
* Author: Mohamed Nheri
* Date: 04/06/2018
* Purpose: This concrete class will extend the TreeNode
* abstract class and implement its method
*/
package app;


public class OperandNode extends TreeNode{  
	//Declaring private variable
    private int value;
        
    /**
     * constructor
     * @param value
     */
    public OperandNode(int value){
        this.value = value;
    }  

    public String getExpression(){
        return String.valueOf(value);
    }    
}//end of class
