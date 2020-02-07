package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lib.ConsoleIO;
import models.Document;

public class LogicController {
	
//	private static String docPath;
	private static String username;
	private static String password;
	public static Document docObject;
	private static boolean running = true;
	private static boolean loggedIn = false;
	public static String docName = "None.brkn";
	
	public static void run() {
		while(running) {
			if(!loggedIn) {
				security();
			} else {
				displayMainMenu();
			}
		}
	}
	
	private static void createDoc() {
		docObject = new Document();
		editDoc();
	}
	
	private static void editDoc() {
		System.out.println("\nOriginal Document Name: " + docName.substring(0, docName.length() - 5));
		docName = ConsoleIO.promptForInput("New Document Name: ", false) + ".brkn";
		System.out.println("Original Content: " + docObject.toString());
		String content = ConsoleIO.promptForInput("New Content: ", false);
		docObject.setContent(content);
	}
	
	private static Document openDoc() {
//		TODO Implement Document Location Changeability
		FileInputStream file = null;
		ObjectInputStream in = null;
		docObject = null;
//		docPath = ConsoleIO.promptForInput("\nDocument Location: ", false);
		
		try {
			docName = ConsoleIO.promptForInput("\nDocument Name: ", false) + ".brkn";
			file = new FileInputStream(docName);
			in = new ObjectInputStream(file);
			docObject = (Document)in.readObject();
		} catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("IOException has been caught during creation of File/Object Input Stream.");
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("ClassNotFoundException has been caught during File/Object Input Stream.");
		} finally {
			try {
				in.close();
				file.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
				System.out.println("IOException has been caught during File/Object Input Stream closing.");
			}
		}
		
		return docObject;
	}
	
	private static void saveDoc() {
//		TODO Implement Document Location Changeability
		FileOutputStream file = null;
		ObjectOutputStream out = null;
//		docPath = ConsoleIO.promptForInput("\nDocument Location: ", false);
		
		try {
			file = new FileOutputStream(docName);
			out = new ObjectOutputStream(file);
			out.writeObject(docObject);
		} catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("IOException has been caught during creation of File/Object Output Stream.");
		} finally {
			try {
				out.close();
				file.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
				System.out.println("IOException has been caught during File/Object Output Stream closing.");
			}
			System.out.println("Document has been Serialized");
		}
	}
	
	private static void security() {
		username = ConsoleIO.promptForInput("Username: ", false);
		if(username.equalsIgnoreCase("brokenw1nter")) {
			password = ConsoleIO.promptForInput("Password: ", false);
			if(password.equals("pw")) {
				loggedIn = true;
				System.out.println("\nWelcome Back " + username);
				displayMainMenu();
			} else {
				System.out.println("Incorrect Password\n");
			}
		} else {
			System.out.println("Invalid User\n");
		}
	}
	
	private static void displayMainMenu() {
		System.out.println("\nOpened Document: " + docName.substring(0, docName.length() - 5));
		int selection = ConsoleIO.promptForInt("1. New Document\n2. View/Edit Document"
				+ "\n3. Open Document\n4. Save Document\n5. Shut Down\nSelection: ", 1, 5);
		
		switch(selection) {
		case 1:
			createDoc();
			break;
		case 2:
			viewEditMenu();
			break;
		case 3:
			openDoc();
			viewEditMenu();
			break;
		case 4:
			saveDoc();
			break;
		case 5:
			System.out.println("\nStay Dark " + username);
			running = false;
			break;
		default:
			System.out.println("\nSorry, option number '" + selection + "' is not valid. Please select a valid option.\n");
		}
	}
	
	private static void viewEditMenu() {
		System.out.println("\nOpened Document: " + docName.substring(0, docName.length() - 5));
		int selection = ConsoleIO.promptForInt("1. View Document\n2. Edit Document\n3. Main Menu\nSelection: ", 1, 3);
		switch(selection) {
		case 1:
			System.out.println("\nDocument Name: " + docName.substring(0, docName.length() - 5));
			System.out.println("Content: " + docObject.toString());
			ConsoleIO.promptForInput("\nEnter to Continue", true);
			viewEditMenu();
			break;
		case 2:
			editDoc();
			break;
		case 3:
			displayMainMenu();
			break;
		default:
			System.out.println("\nSorry, option number '" + selection + "' is not valid. Please select a valid option.\n");
		}
	}
	
}