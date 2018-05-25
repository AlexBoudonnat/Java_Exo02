package com.campusnum.reseausocial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReseauSocialObjet {

	Person[] userList = new Person[5];
	String[][] messages = new String[3][10];
	int[][] friends = new int[3][3];

	private String prenom, nom, ville, age, pseudo, regex = "^\\d{1}$", choices;
;
	int userId = 0, msgId, friendId, friendChoice;
	char next = '1', choice, change;
	boolean back;
	
	User newUser = null;
	Moderator moderator = null;

	Scanner sc = new Scanner(System.in);

	public ReseauSocialObjet() {

		System.out.println("MON SUPER RESEAU SOCIAL\n\n");
		
		this.SignUp();

		do {
			//System.out.println(userList[userId].getClass().getName());
			
			System.out.println("\nMerci " + userList[userId].getPrenom() + " " + userList[userId].getNom()
					+ ", que voulez vous faire maintenant ?");

			ShowMenu();

			choices = sc.nextLine().toUpperCase();
			choice = choices.charAt(0);

			while (!choices.matches(regex) && choice != 'A' && choice != 'B') {
				System.out.println("\nVeuillez taper une entrée valide.");
				choices = sc.nextLine();
			}

			switch (choice) {
			case '1':
				System.out.println("\nMon profile : ");

				ShowProfile();

				this.Return();

				break;
			case '2':

				this.Change();

				back = true;

				break;
			case '3':
				System.out.println("\nEcrivez votre message :");

				this.NewMsg();

				back = true;

				break;
			case '4':
				System.out.println("Mes messages :");

				ShowMsg();

				this.Return();

				break;
			case '5':
				System.out.println("Voulez vous supprimer un de vos message ?");

				break;
			case '6':
				System.out.println("Ajouter un ami :");

				if (userId > 0) {
					AddFriend();
				}

				this.Return();

				break;
			case '7':
				System.out.println("Mes amis :");

				ShowFriends();

				this.Return();

				break;
			case '8':
				userId++;

				SignUp();

				back = true;

				break;
			case '9':
				back = false;

				break;
			}

			if (userList[userId].getModeratingLevel() > 0) {
				switch (choice) {
				case 'A':
					System.out.println("Quel message voulez vous supprimer ?");
					back = true;

					break;
				}
				if (userList[userId].getModeratingLevel() > 1) {
					switch (choice) {
					case 'B':
						System.out.println("Quel utilisateur voulez vous supprimer ?");
						back = true;

						break;
					}
				}
			}

		} while (back == true);

		System.out.println("A bientot :)");

	}

	public static void main(String[] args) {

		ReseauSocialObjet reseauSocial = new ReseauSocialObjet();

	}

	public void SignUp() {

		if (userId < userList.length) {
			System.out.println("Bonjour, veuillez entrer vous informations personnelles :");

			System.out.println("Quel est votre nom :");
			nom = sc.nextLine();

			System.out.println("Quel est votre prénom :");
			prenom = sc.nextLine();

			System.out.println("Choisissez un pseudo :");
			pseudo = sc.nextLine();

			System.out.println("Quel est votre ville :");
			ville = sc.nextLine();

			System.out.println("Quel est votre age :");
			age = sc.nextLine();

			System.out.println("Cet utilisateur sera-t-il moderateur ? (O/N)");

			choice = sc.nextLine().toUpperCase().charAt(0);

			while (choice != 'O' && choice != 'N') {
				System.out.println("Cet utilisateur sera-t-il moderateur ? (O/N)");

				choice = sc.nextLine().toUpperCase().charAt(0);
			}

			if (choice == 'N') {

				try {
					newUser = new User(prenom, nom, ville, age, pseudo);
				} catch (NomException e) {
					SignUp();
				} catch (PrenomException e2) {
					SignUp();
				} catch (VilleException e3) {
					SignUp();
				} catch (AgeException e4) {
					SignUp();
				}
				userList[userId] = newUser;

			} else {
				
				try {
					moderator = new Moderator(prenom, nom, ville, age, pseudo);
				} catch (NomException e) {
					SignUp();
				} catch (PrenomException e2) {
					SignUp();
				} catch (VilleException e3) {
					SignUp();
				} catch (AgeException e4) {
					SignUp();
				}

				while (choice != '1' && choice != '2') {

					System.out.println("Avec quel niveau de modération ? (1/2)");

					choice = sc.nextLine().charAt(0);

				}

				if (choice == '2') {

					moderator.setModeratingLevel(2);

				}

				userList[userId] = moderator;
				System.out.println(
						"\nBonjour Monsieur le modérateur de niveau " + userList[userId].getModeratingLevel() + " !!!");

			}

			msgId = 0;
			friendId = 0;
		} else {
			userId--;
			System.out.println("Il n'y a plus de place !!!");
			back = true;
		}

	}

	public void Return() {

		do {
			System.out.println("\n1- Revenir au choix");
			System.out.println("2- Quitter l'appli");
			next = sc.nextLine().charAt(0);
		} while (next != '1' && next != '2');

		if (next == '2')
			back = false;
		else
			back = true;

	}

	public void Change() {

		System.out.println("\nModifier mes informations personnelles :");
		System.out.println("\nQue souhaitez-vous modifier ?");
		System.out.println("1- Nom");
		System.out.println("2- Prénom");
		System.out.println("3- Ville");
		System.out.println("4- Age");

		change = sc.nextLine().charAt(0);

		switch (change) {
		case '1':
			System.out.println("Nouveau nom :");
			userList[userId].setNom(sc.nextLine());
			break;
		case '2':
			System.out.println("Nouveau prénom :");
			userList[userId].setPrenom(sc.nextLine());
			break;
		case '3':
			System.out.println("Nouvelle ville :");
			userList[userId].setVille(sc.nextLine());
			break;
		case '4':
			System.out.println("Nouvel age :");
			userList[userId].setAge(sc.nextLine());
			break;
		}

	}

	public void NewMsg() {

		if (msgId < messages.length) {
			messages[userId][msgId] = sc.nextLine();
			msgId++;
		} else {
			System.out.println("Votre messagerie est pleine");
		}

	}

	public void ShowMsg() {

		for (int i = 0; i <= msgId - 1; i++) {
			System.out.println("\n" + (i + 1) + "- " + messages[userId][i]);
		}

	}

	public void AddFriend() {

		if (friendId < friends.length) {
			for (int i = 0; i < userId; i++) {
				if (userList[i] instanceof Moderator) {
					System.out.println(i + "- " + userList[i].getPrenom() + " " + userList[i].getNom() + ((Moderator) userList[i]).getFunction() + ((Moderator) userList[i]).getModeratingLevel() + ")");
				} else {
					System.out.println(i + "- " + userList[i].getPrenom() + " " + userList[i].getNom());
				}
				
			}
			
			test();
			sc.nextLine();
			
			while (friendChoice >= userId) {
				System.out.println("Veuillez entrer un des chiffres proposés :");
				test();
				sc.nextLine();
			}

				friends[userId][friendId] = friendChoice;
				System.out.println(userList[friendChoice].getPrenom() + " " + userList[friendChoice].getNom()
						+ " est maintenant votre ami.");
				friendId++;
			
		} else {
			System.out.println("Vous ètes déjà bien assez d'amis !!!");
		}

	}

	public void ShowFriends() {

		for (int i = 0; i < friendId; i++) {
			System.out.println(userList[friends[userId][i]].getPrenom() + " " + userList[friends[userId][i]].getNom());
		}

	}

	public void ShowProfile() {

		System.out.println("\nNom : " + userList[userId].getNom());
		System.out.println("Prénom : " + userList[userId].getPrenom());
		System.out.println("Ville : " + userList[userId].getVille());
		System.out.println("Age : " + userList[userId].getAge() + "ans");
	}

	public void ShowMenu() {

		System.out.println("\n1- Voir votre profile.");
		System.out.println("2- Modifier vos informations personnelles.");
		System.out.println("3- Ecrire un message.");
		System.out.println("4- Afficher les messages.");
		System.out.println("5- Supprimer un message.");
		System.out.println("6- Ajouter un ami.");
		System.out.println("7- Afficher le nom des amis.");
		System.out.println("8- Ajouter un nouvel utilisateur.");
		System.out.println("9- Déconnexion.");
		if (userList[userId].getModeratingLevel() > 0) {
			System.out.println("\nA- Supprimer un message.");
			if (userList[userId].getModeratingLevel() > 1) {
				System.out.println("B- Supprimer un utilisateur.");
			}
		}
	}
	
	private void test() {
		try {
			friendChoice = sc.nextInt();			
		} catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("Veuillez entrer un nombre valide :");
			test();
		}
	}

}
