package com.InputVerifier;

import java.math.BigDecimal;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class MyInputVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
        	
            BigDecimal value = new BigDecimal(text);
            return (value.scale() <= Math.abs(4)  & text.length()<5); 
        } catch (NumberFormatException e) {
            return false;
        }
    }
}