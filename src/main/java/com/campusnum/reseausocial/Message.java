package com.campusnum.reseausocial;
/**
 * 
 * @author Utilisateur
 *
 */
public class Message {
	
	private String text;
	/**
	 * Constructeur sans paramètres
	 */
	public Message() {
		
	}
/**
 * 
 * @return
 */
	public String getText() {
		return text;
	}
/**
 * 
 * @param text
 */
	public void setText(String text) {
		this.text = text;
	}
/**
 * 
 * @param pText
 */
	public Message(String pText) {
		text = pText;
	}
	
}
