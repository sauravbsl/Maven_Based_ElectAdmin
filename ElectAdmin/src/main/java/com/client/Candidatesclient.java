package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.controller.Candidatescontroller;
import com.entity.Candidates;

public class Candidatesclient {
	static Candidatescontroller control = null;
	static List<Candidates> allCandidatesList = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("!!!Welcome to our System!!!");
		System.out.println("This is our menu");
		System.out.println("1. Show All Candidatess");
		System.out.println("2. Insert New Candidates");
		System.out.println("3. Update Candidatess From System");
		System.out.println("4. Remove Candidatess Into System ");
		System.out.println("5. Exit");

		Scanner sc = new Scanner(System.in);
		control = new Candidatescontroller();

		while (true) {
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				allCandidatesList = control.getAllCandidates();
				for (Candidates Candidates : allCandidatesList) {
					System.out.println(Candidates);
				}
				break;

			case 2:
				System.out.println("Enter Candidates Details:");
				System.out.print("ID: ");
				int id = sc.nextInt();
				System.out.print("Name: ");
				String names = sc.next();
				System.out.print("Assembly: ");
				String assembly = sc.next();
				System.out.print("ParyName: ");
				String partyname = sc.next();
				System.out.print("State Name: ");
				String statename = sc.next();
				System.out.print("Age: ");
				int age = sc.nextInt();
				System.out.print("Gender: ");
				String gender = sc.next();
				

				Candidates newCandidates = new Candidates(id, names, assembly, partyname, statename, age, gender);
				String result = control.addCandidate(newCandidates);
				System.out.println(result);
				break;
			case 3:
				System.out.println("Enter Candidates Details:");
				System.out.print("ID: ");
				int uid = sc.nextInt();
				System.out.print("Name: ");
				String unames = sc.next();
				System.out.print("Assembly: ");
				String uassembly = sc.next();
				System.out.print("ParyName: ");
				String upartyname = sc.next();
				System.out.print("State Name: ");
				String ustatename = sc.next();
				System.out.print("Age: ");
				int uage = sc.nextInt();
				System.out.print("Gender: ");
				String ugender = sc.next();

				Candidates newCandidatesUpdate = new Candidates(uid, unames, uassembly, upartyname, ustatename, uage, ugender);
				String resultupdate = control.updateCandidate(newCandidatesUpdate);
				System.out.println(resultupdate);
				break;
			case 4:
				System.out.print("Name: ");
				String rname = sc.next();
				String resultremove = control.removeCandidate(rname);
				System.out.println(resultremove);
				break;
			case 5:
				System.out.println("Exiting...Thank you visit again..!!!!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
