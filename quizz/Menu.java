package org.fundacionjala.app.quizz;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.fundacionjala.app.quizz.console.QuizUIHandler;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;

public class Menu {
    private Quiz quiz;
    private QuizAnswers quizAnswers;

    public Menu() {
        this.quiz = readJsonFile();
        this.quizAnswers = null;
    }

    public boolean process() throws IOException {

        showMainMenu();
        char option = readOption();
        boolean shouldExit = false;
        switch (option) {
            case '1':
                quiz = QuizUIHandler.createQuiz();
                break;
            case '2':
                fillQuiz();
                break;
            case '3':
                showQuiz();
                break;
            case '4':
                shouldExit = true;
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        System.out.println(System.lineSeparator());
        return shouldExit;
    }

    private void showQuiz() throws IOException {
	if(isExistQuiz())
        QuizUIHandler.showQuiz(quizAnswers,quiz);
	
    }
  private Quiz readJsonFile() {
        Gson gson = new Gson();
        Quiz quiz = null;
        try (JsonReader reader = new JsonReader(new FileReader("./myQuiz.json"))) {
            quiz= gson.fromJson(reader, Quiz.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return quiz;
  }
    private void fillQuiz() {
	if(isExistQuiz()){
	quizAnswers = QuizUIHandler.fillQuiz(quiz);
    }
	
    }
	private Boolean isExistQuiz(){
		Boolean exist = true;
		if(quiz == null){
            	System.out.println("No quiz available, you must create first a quiz");
		exist =false;	
		}else if(quizAnswers == null){
            	System.out.println("No filled quiz available, you must create and fill a quiz");
		exist = false;
		}
		return exist;
		
	}
    private void showMainMenu() {
        System.out.println("Quizc - A command quiz utility");
        System.out.println("======================================");
        System.out.println("1. Create quiz");
        System.out.println("2. Fill quiz");
        System.out.println("3. Show quiz");
        System.out.println("4. Exit");
        System.out.println("======================================");
    }

    private char readOption() {
        System.out.print("> ");
	Scanner option= new Scanner(System.in);
        return option.nextLine().charAt(0);
    }
}
