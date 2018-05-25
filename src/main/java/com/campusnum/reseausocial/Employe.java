package com.campusnum.reseausocial;

public class Employe extends Person implements Salaried {
	
	String salary, contract;
/**
 * 
 */
	public Employe() {
		this.setNom("unknown");
		this.setPrenom("unknown");
		this.setVille("unknown");
		this.setAge("unknown");
		this.setSalary("1500");
		this.setContract("CDI");
	}
/**
 * 
 * @param pSalary
 * @param pContract
 * @param pPrenom
 * @param pNom
 * @param pVille
 * @param pAge
 * @throws NomException
 * @throws PrenomException
 * @throws VilleException
 * @throws AgeException
 */
	public Employe(String pSalary, String pContract, String pPrenom, String pNom, String pVille, String pAge) throws NomException, PrenomException, VilleException, AgeException {if (!pNom.matches(regexAlpha)) {
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
		this.setSalary(pSalary);
		this.setContract(pContract);
	}
	}

	/**
	 * 
	 */
	public int getModeratingLevel() {
		return 0;
	}
/**
 * 
 * @return
 */
	public String getSalary() {
		return salary;
	}
/**
 * 
 * @param salary
 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
/**
 * 
 * @return
 */
	public String getContract() {
		return contract;
	}
/**
 * 
 * @param contract
 */
	public void setContract(String contract) {
		this.contract = contract;
	}
/**
 * 	
 * @return
 */
	public boolean work() {
		return true;
	}
/**
 * 
 */
public String getPaid() {
	return this.getSalary();
}

}
