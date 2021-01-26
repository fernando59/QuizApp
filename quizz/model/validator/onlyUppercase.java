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
public class onlyUppercase implements Validator<String,String> {
	
    	private static final String ERROR_MESSAGE = "The value is not uppercase";

	@Override
	public void validate(String value, String conditionValue, List<String> errors) {
		if(value.toUpperCase() == conditionValue){
			errors.add(ERROR_MESSAGE + conditionValue);
		}
	}
	
}
