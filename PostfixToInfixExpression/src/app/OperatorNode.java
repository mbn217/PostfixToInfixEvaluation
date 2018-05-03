/*
* File: OperatorNode.java
* Author: mbn217
* Date: 04/06/2018
* Purpose: This concrete class will extend the TreeNode
* abstract class and implement its method
*/

package app;


public class OperatorNode extends TreeNode{    
    private String      operator;    
    private String      operatorTxt;
    
    private TreeNode    left;
    private TreeNode    right;
    
    /**
     * Constructor
     * @param operator
     * @param left
     * @param right
     */
    public OperatorNode(String operator, TreeNode left, TreeNode right){
        this.operator = operator;
        this.left = left;
        this.right = right;
        
        if(operator.endsWith("+"))
            operatorTxt = "Add";
        else if(operator.endsWith("-"))
            operatorTxt = "Sub";
        else if(operator.endsWith("*"))
            operatorTxt = "Mul";
        else if(operator.endsWith("/"))
            operatorTxt = "Div";        
    }     

    
    /**
     * @return return the expression
     */
    public String getExpression(){
        String leftVal = left.getExpression();
        String rightVal = right.getExpression();
        return "(" + leftVal + " " + operator + " " + rightVal + ")";
    }    
    
    /**
     * @return operatorTxt
     */
    public String getPureOperatorString() {
        return operatorTxt;
    }
}//end of class
