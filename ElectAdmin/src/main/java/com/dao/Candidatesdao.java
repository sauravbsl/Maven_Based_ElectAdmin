package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Candidates;

import utility.DBConnectionUtil;

public class Candidatesdao {
    String path = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/election";
    String Username = "root";
    String Password = "root";
    String show_all = "SELECT * FROM election.candidates";
    static String insert = "INSERT INTO election.candidates (id, names, assembly, partyname, statename, age, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
    static String update = "UPDATE election.candidates SET id = ?, assembly = ?, partyname = ?, statename = ?, age = ?, gender = ? WHERE names = ?";
    static String remove = "DELETE FROM election.candidates WHERE names = ?";
    List<Candidates> allCandidatesList = new ArrayList<>();

    public List<Candidates> getallCandidates() {
        try {
            Class.forName(path);
            Connection con = DriverManager.getConnection(url, Username, Password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(show_all);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("names");
                String assembly = rs.getString("assembly");
                String partyname = rs.getString("partyname");
                String statename = rs.getString("statename");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");

                Candidates candidate = new Candidates(id, name, assembly, partyname, statename, age, gender);
                allCandidatesList.add(candidate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCandidatesList;
    }

    public static String addCandidates(Candidates candidate) {
        String declaration = null;
        try {
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement st1 = con.prepareStatement(insert);

            st1.setInt(1, candidate.getId());
            st1.setString(2, candidate.getNames());
            st1.setString(3, candidate.getAssembly());
            st1.setString(4, candidate.getPartyname());
            st1.setString(5, candidate.getStatename());
            st1.setInt(6, candidate.getAge());
            st1.setString(7, candidate.getGender());

            int rowAffected = st1.executeUpdate();
            if (rowAffected > 0) {
                declaration = "Insertion Successful.";
            } else {
                declaration = "Insertion Failed.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return declaration;
    }

    public static String updateCandidates(Candidates candidate) {
        String updateDeclaration = null;
        try {
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement st1 = con.prepareStatement(update);

            st1.setInt(1, candidate.getId());
            st1.setString(2, candidate.getAssembly());
            st1.setString(3, candidate.getPartyname());
            st1.setString(4, candidate.getStatename());
            st1.setInt(5, candidate.getAge());
            st1.setString(6, candidate.getGender());
            st1.setString(7, candidate.getNames());

            int rowAffected = st1.executeUpdate();
            if (rowAffected > 0) {
                updateDeclaration = "Candidate updated successfully.";
            } else {
                updateDeclaration = "Candidate update failed. Check if the candidate exists.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateDeclaration;
    }

    public static String removeCandidates(String name) {
        String removedeclaration = null;
        try {
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement st1 = con.prepareStatement(remove);
            st1.setString(1, name);

            int rowAffected = st1.executeUpdate();
            if (rowAffected > 0) {
                removedeclaration = "Candidate removed successfully.";
            } else {
                removedeclaration = "Candidate removal failed. The candidate does not exist in the database.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return removedeclaration;
    }
}
