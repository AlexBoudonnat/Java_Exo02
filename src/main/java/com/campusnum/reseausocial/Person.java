package com.campusnum.reseausocial;

public abstract class Person {
	protected String prenom, nom, ville, age, regexNum = "^\\d{2}$", regexAlpha = "^\\S[a-zA-Z]*$";
	protected int userId, id = 0;
/**
 * 
 * @return
 */
	public String getPrenom() {
		return prenom;
	}
/**
 * 
 * @param prenom
 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
/**
 * 
 * @return
 */
	public String getNom() {
		return nom;
	}
/**
 * 
 * @param nom
 */
	public void setNom(String nom) {
			this.nom = nom;

	}
/**
 * 
 * @return
 */
	public String getVille() {
		return ville;
	}
/**
 * 
 * @param ville
 */
	public void setVille(String ville) {
		this.ville = ville;
	}
/**
 * 
 * @return
 */
	public String getAge() {
		return age;
	}
/**
 * 
 * @param age
 */
	public void setAge(String age) {
		this.age = age;
	}
/**
 * 
 */
	protected void setUserId() {
		this.userId = id;
		id++;
	}
/**
 * 	
 * @return
 */
	public abstract int getModeratingLevel();

}
