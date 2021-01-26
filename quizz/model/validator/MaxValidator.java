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
public class MaxValidator implements Validator<Integer,Integer> {


   	 private static final String ERROR_MESSAGE = "The value length must be more than ";
	
	 @Override
	public void validate(Integer value, Integer conditionValue, List<String> errors) {
		 if (value > conditionValue) {
            errors.add(ERROR_MESSAGE + conditionValue);
        }	
	}
	
}
