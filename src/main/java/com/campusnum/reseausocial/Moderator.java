package com.campusnum.reseausocial;

public class Moderator extends User implements Salaried {
	
	private int ModeratingLevel;
/**
 * 
 */
	public Moderator() {
		super();
		this.setModeratingLevel(1);
	}
/**
 * 
 * @param pPrenom
 * @param pNom
 * @param pVille
 * @param pAge
 * @param pPseudo
 * @throws NomException
 * @throws PrenomException
 * @throws VilleException
 * @throws AgeException
 */
	public Moderator(String pPrenom, String pNom, String pVille, String pAge, String pPseudo) throws NomException, PrenomException, VilleException, AgeException {
		super(pPrenom, pNom, pVille, pAge, pPseudo);
		this.setModeratingLevel(1);
	}
	
	/**
	 * 
	 */
	public int getModeratingLevel() {
		return ModeratingLevel;
	}

	/**
	 * @param moderatingLevel
	 */
	public void setModeratingLevel(int moderatingLevel) {
		ModeratingLevel = moderatingLevel;
	}
	
	/**
	 * @param userId
	 * @param msgId
	 */
	public void deleteMsg(int userId, int msgId) {
		//permet de supprimer le msg qui a pour id msgId d'un utilisateur qui a id userId
	}
	
	/**
	 * @param userId
	 */
	public void deleteUser (int userId) {
		//permet de supprimer l'utilisateur qui a pour id userId
	}
	
	/**
	 * @return
	 */
	public String getFunction() {
		return " (modérateur de niveau ";
	}
	/* (non-Javadoc)
	 * @see com.campusnum.reseausocial.Salaried#getPaid()
	 */
	public String getPaid() {
		// TODO Auto-generated method stub
		return "Bons de reduction";
	}

}
