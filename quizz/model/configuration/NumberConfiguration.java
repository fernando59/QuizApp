/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fundacionjala.app.quizz.model.configuration;

import org.fundacionjala.app.quizz.model.validator.ValidatorType;

/**
 *
 * @author Fernando
 */
public class NumberConfiguration  extends  QuestionConfiguration{

	public NumberConfiguration(){
		super(false,ValidatorType.MAX,ValidatorType.MIN,ValidatorType.REQUIRED);
		
	}
	
}
