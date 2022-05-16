package com.InputVerifier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class MyInputStringVerifier extends InputVerifier{
    @Override
    public boolean verify(JComponent input) {
     
        String text = ((JTextField) input).getText();
        String regex = "^[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        try {
        	  Matcher matcher = pattern.matcher(text);
         
            if(matcher.matches()) {
              return true;
             } else {
                 return false;
             }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}