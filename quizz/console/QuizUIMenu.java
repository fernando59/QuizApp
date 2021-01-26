package org.fundacionjala.app.quizz.console;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import org.fundacionjala.app.JsonPersistence;
import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.Quiz;

public class QuizUIMenu {

	Scanner scanner = new Scanner(System.in);

	public Quiz handleCreateQuiz() {
		String title = askQuizTitle();
		Quiz quiz = new Quiz(title);
		boolean shouldExit = false;

		do {
			showMenu();
			char option = readOption();
			switch (option) {
				case '1':
					Question question = QuestionUIMenu.handleCreateQuestion();
					quiz.addQuestion(question);
					writeJsonFile(quiz);
					break;
				case '0':
					shouldExit = true;
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		} while (!shouldExit);

		return quiz;
	}

	public static void writeJsonFile(Quiz quiz) {
		Gson gson = new Gson();
		try (Writer writer = new FileWriter("./myQuiz.json")) {
			gson.toJson(quiz, writer);
		} catch (JsonIOException | IOException exception) {
			exception.printStackTrace();
		}
	}

	private char readOption() {
		System.out.print("> ");
		return scanner.nextLine().trim().charAt(0);
	}

	private void showMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Add a new question");
		System.out.println("0. Finish");
	}

	private String askQuizTitle() {
		System.out.println("Type the quiz title");
		System.out.print("> ");
		return scanner.nextLine();
	}
}
