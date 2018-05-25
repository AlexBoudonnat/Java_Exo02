package com.campusnum.reseausocial;

public class CIO extends Employe implements Relationship {

	public CIO() {
		// TODO Auto-generated constructor stub
	}

	public CIO(String pSalary, String pContract, String pPrenom, String pNom, String pVille, String pAge)
			throws NomException, PrenomException, VilleException, AgeException {
		super(pSalary, pContract, pPrenom, pNom, pVille, pAge);
		// TODO Auto-generated constructor stub
	}
	
	public boolean work() {
		return false;
	}

	public void addPerson() {
		// TODO Auto-generated method stub
		
	}

}
