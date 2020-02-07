package controllers;

import lib.ConsoleIO;
import models.Document;

public class LogicController {
	
	private static String docPath;
	private static String username;
	private static String password;
	public static Document docObject;
	private static boolean running = true;
	private static boolean loggedIn = false;
	public static String loadedDoc = "New Document"; 
	
	public static void run() {
		while(running) {
			if(!loggedIn) {
				security();
			} else {
				displayMainMenu();
			}
		}
	}
	
	private static void createTextDoc() {
		// TODO
	}
	
	private static void openTextDoc() {
		// TODO
		docPath = ConsoleIO.promptForInput("\nDocument Location: ", false);
	}
	
	private static Document saveTextDoc() {
		// TODO
		docPath = ConsoleIO.promptForInput("\nDocument Location: ", false);
		return null;
	}
	
	private static void security() {
		username = ConsoleIO.promptForInput("Username: ", false);
		if(username.equalsIgnoreCase("brokenw1nter")) {
			password = ConsoleIO.promptForInput("Password: ", false);
			if(password.equals("pw")) {
				loggedIn = true;
				displayMainMenu();
			} else {
				System.out.println("Incorrect Password");
			}
		} else {
			System.out.println("Invalid User");
		}
	}
	
	private static int displayMainMenu() {
		System.out.println("\nWelcome Back " + username);
		int selection = ConsoleIO.promptForInt("\n1. New Document\n2. Open Document\n3. Save Document\n4. Shut Down\nSelection: ", 1, 4);
		
		switch(selection) {
		case 1:
			createTextDoc();
			break;
		case 2:
			openTextDoc();
			break;
		case 3:
			saveTextDoc();
			break;
		case 4:
			System.out.println("\nStay Dark " + username);
			running = false;
			break;
		default:
			System.out.println("\nSorry, option number '" + selection + "' is not valid. Please select a valid option.\n");
		}
		
		return selection;
	}
	
}