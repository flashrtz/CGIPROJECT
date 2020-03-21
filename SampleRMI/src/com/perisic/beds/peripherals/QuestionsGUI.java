package com.perisic.beds.peripherals;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.perisic.beds.questionnaire.QuestionSet;

 
public class QuestionsGUI extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1077856539035586635L;
	
	// The GUI only interacts with the QuestionnairePanel class. 
	private QuestionSet questionnaire = new QuestionSet(); 
/**
 * Two possible actions are implemented here: 
 * start the questionnaire and analyses the answers. 
 * To do: refractor code to separate into different concerns; also:  
 * password protect the actions (questionnaire, analysis of data). 
 */
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(nextButton)) { 
			
			for(int i = 0; i < questionnaire.numberOfQuestions(); i++) {

				String message = questionnaire.getQuestion(i); 
				String [] options = questionnaire.getOptions(i); 

				int selectedValue = JOptionPane.showOptionDialog(null, 
						message, "Question "+i, JOptionPane.DEFAULT_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);  
				
				questionnaire.submitAnswer(i, options[selectedValue]);
			}
		} else if(e.getSource().equals(analyzeButton)) {  	
			questionnaire.reportAnswers(); 
		}
		
	}

	JButton nextButton = new JButton("Start Questionnaire");	
	JButton analyzeButton = new JButton("Analyze Answers"); 

/**
 * Constructor	
 */
	
	private QuestionsGUI() {
		super();
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	
		
		JPanel panel = new JPanel(); 
				
		panel.add(nextButton); 
		nextButton.addActionListener(this); 
		
		panel.add(analyzeButton); 
		analyzeButton.addActionListener(this); 
				
		getContentPane().add(panel);
		panel.repaint();
		

	}
	
	public static void main(String [] args ) { 
		QuestionsGUI myGUI = new QuestionsGUI(); 
		myGUI.setVisible(true); 
		
	}

}