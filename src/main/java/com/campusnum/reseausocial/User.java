package com.campusnum.reseausocial;
/**
 * 
 * @author Utilisateur
 *
 */
public class User extends Person implements Relationship {
	
	protected String pseudo;

	public User() {
		this.setNom("unknown");
		this.setPrenom("unknown");
		this.setVille("unknown");
		this.setAge("unknown");
		this.setPseudo("unknown");
	}
	
	public User(String pPrenom, String pNom, String pVille, String pAge, String pPseudo) throws NomException, PrenomException, VilleException, AgeException {
		if (!pNom.matches(regexAlpha)) {
			throw new NomException();
		} else if (!pPrenom.matches(regexAlpha)) {
			throw new PrenomException();
		} else if (!pVille.matches(regexAlpha)) {
			throw new VilleException();
		} else if (!pAge.matches(regexNum)) {
			throw new AgeException();
		}
		else {
			this.setNom(pNom);
			this.setPrenom(pPrenom);
			this.setVille(pVille);
			this.setAge(pAge);
			this.setPseudo(pPseudo);
		}
	}
	
	/**
	 * @param msgId
	 */
	public void deleteMsg(int msgId) {
		//permet de supprimer un msg qui a pour id msgId
	}
	
	/**
	 * @return
	 */
	public int getModeratingLevel() {
		return 0;
	}
/**
 * 
 * @return
 */
	public String getPseudo() {
		return pseudo;
	}
/**
 * 
 * @param pseudo
 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

public void addPerson() {
	// TODO Auto-generated method stub
	
}
	
}
