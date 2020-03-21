package com.perisic.beds.rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import com.perisic.beds.rmiinterface.Question;
import com.perisic.beds.rmiinterface.RemoteQuestions;

/**
  Implementation of the questionnaire. Note that chosen answers are collected in this
 * object as well. That means that if the object is destroyed, for instance server restart
 * the collected data is all gone. 
 * To do: make data persistent, for instance link collected data to a database or save data
 * in a text file.  
 *
 */
public class QuestionServerImplementation 
extends UnicastRemoteObject implements RemoteQuestions{
	private static final long serialVersionUID = -3763231206310491048L;
	
	Vector<Question> myQuestions = new Vector<Question>(); 
	/**
	 * All questions and answers are initialised in the constructor of this class. 
	 * To do: read questions and options from an external data file. 
	 * @throws RemoteException
	 */
	QuestionServerImplementation() throws RemoteException {
		super();
		System.out.println("QuestionServerImplementation Created");
		String[] answers1 = {"18-24", "25-34", "35-40" }; 
		String[] answers2 = {"FullTime", "PartTime", "Retired"};
		String[] answers3 = {"0-20K", "20-50K", "50K-100K" };
		String[] answers4 = {"Colombo", "Outside Colombo","sad"};
		String[] answers5 = {"0-100", "100-500", "More than 500" };
		String[] answers6 = {"High", "Neutral", "Most of the time Lazy" };
		String[] answers7 = {"Almost All", "Only a few", "None" };
		String[] answers8 = {"4hours", "8 hours", "12 hours" };
		String[] answers9 = {"Yes", "No", "Maybe"};
		String[] answers10 = {"2stars", "3stars", "4stars"};
		
		Question question1 = new Question("Which of the following describes your age?", answers1 ); 
		myQuestions.add(question1); 

		Question question2 = new Question("What is your current employment status?", answers2 );
		myQuestions.add(question2); 

		Question question3 = new Question("How much do you earn?", answers3 );
		myQuestions.add(question3); 
		
		Question question4 = new Question("Location where you work?", answers4 ); 
		myQuestions.add(question4); 
		
		Question question5 = new Question("Number of your employees in your company?", answers5 ); 
		myQuestions.add(question5); 

		Question question6 = new Question("How motivated are you?", answers6 );
		myQuestions.add(question6); 

		Question question7 = new Question("How well do you know others?", answers7 );
		myQuestions.add(question7); 
		
		Question question8 = new Question("Working time?", answers8 ); 
		myQuestions.add(question8); 
		
		Question question9 = new Question("Are you a happy worker?", answers9 ); 
		myQuestions.add(question9); 
	
		Question question10 = new Question("How would you rate your progress(work progress) upto now?", answers10 ); 
		myQuestions.add(question10); 
	}

	/**
	 * Implementation of remote interface method. 
	 */
	@Override
	public int getNumberOfQuestions() throws RemoteException {
		return myQuestions.size();
	}
	/**
	 * Implementation of remote interface method. 
	 */
	@Override
	public Question getQuestion(int i) throws RemoteException {
		return myQuestions.elementAt(i);
	}
	/**
	 * Implementation of remote interface method. 
	 */	
	@Override
	public void submitAnswer(int i, String answer) throws RemoteException {
		myQuestions.elementAt(i).addAnswer(answer);
	}
	/*
	 * Implementation of remote interface method. 
	 */	
	@Override
	public Vector<Question> getData() { 
		return myQuestions; 	
	}

}
