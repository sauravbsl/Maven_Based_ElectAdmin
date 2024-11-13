package com.service;

import java.util.ArrayList;
import java.util.List;
import com.dao.Candidatesdao;
import com.entity.Candidates;

public class CandidatesService {
    
    private Candidatesdao candidatesDao;

    public CandidatesService() {
        this.candidatesDao = new Candidatesdao();
    }

    public List<Candidates> getAllCandidates() {
        List<Candidates> allCandidatesList = candidatesDao.getallCandidates();
        return allCandidatesList;
    }

    public String addCandidate(Candidates candidate) {
        String result = candidatesDao.addCandidates(candidate);
        return result;
    }

    public String updateCandidate(Candidates candidate) {
        String result = candidatesDao.updateCandidates(candidate);
        return result;
    }

    public String removeCandidate(String name) {
        String result = candidatesDao.removeCandidates(name);
        return result;
    }
}
