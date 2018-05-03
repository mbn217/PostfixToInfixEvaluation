/*
* File: Expression.java
* Author: mbn217
* Date: 04/06/2018
* Purpose: This class will evaluate the postfix expression
* and export the address instrctions to Output.txt file
*/
package app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import javax.swing.JOptionPane;


public class Expression{
    private TreeNode            root;
    private Stack<TreeNode>     nodes;
    private String              instructions;

    /**
     * constrcutor
     */
    public Expression(){
        nodes = new Stack<TreeNode>();
        instructions = "";
    }
   
    /**
     * @param expression (input by the user)
     * @return the infix expression
     */
    public String analyze(String expression)
    {
        if(expression.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Postfix Expression.", "No Input", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException("Expression is empty.");
        }
        
        int operatorCount = 0;

        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            //if the character is an operator then pop two val
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                TreeNode right = nodes.pop();
                TreeNode left = nodes.pop();
                //Assign the correspondasnt instrcution to the constructor
                OperatorNode node = new OperatorNode(String.valueOf(c), left, right);
                //insert back to the stack
                nodes.push(node);
                //call AddInstruction method
                AddInstruction(node.getPureOperatorString(), left, right, operatorCount);
                operatorCount++;
            }
            else if(!Character.isWhitespace(c)) {
                if(Character.isDigit(c)) {
                    nodes.push(new OperandNode(Integer.parseInt(Character.toString(c))));
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid token " + c, "Message", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException("Invalid token");
                }
            } 
        }

        root = nodes.lastElement();
        //write result to a file
        try (FileWriter writer = new FileWriter("Output.txt", false)){
            writer.write(instructions);
        }
        catch(IOException e){
        }
                
        return root.getExpression();
    }   
   
    /**
     * @param operator
     * @param left
     * @param right
     * @param cnt
     */
    private void AddInstruction(String operator, TreeNode left, TreeNode right, int cnt){
        instructions += operator + " R" + cnt + " ";
        
        if(left instanceof OperandNode){
            instructions += left.getExpression() + " ";
            if(right instanceof OperandNode) {
                instructions += right.getExpression() + " \n";
            }else {
                instructions += "R" + (cnt-1) + " \n";
                }
        }
        else if(left instanceof OperatorNode){
            cnt += (cnt <= 2) ? 1 : 0;
            instructions += "R" + (cnt-2) + " ";
            
            if(right instanceof OperatorNode) {
                instructions += "R" + (cnt-1) + " \n";
            }else {
                instructions += right.getExpression() + " \n";
                }
        }
    }//end of AddInstruction method    
}//end of class