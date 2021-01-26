/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

/**
 *
 * @author Fernando
 */
public class MaxLengthValidator implements Validator<String,Integer>{

    	private static final String ERROR_MESSAGE = "The value length must be more than ";
	
	@Override
	public void validate(String value, Integer conditionValue, List<String> errors) {
	 if (value.length() < conditionValue) {
            errors.add(ERROR_MESSAGE + conditionValue);
        }	
	}
	
}
