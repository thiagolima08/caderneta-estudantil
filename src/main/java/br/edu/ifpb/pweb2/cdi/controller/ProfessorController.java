package br.edu.ifpb.pweb2.cdi.controller;

import br.edu.ifpb.pweb2.cdi.dao.ProfessorDAO;
import br.edu.ifpb.pweb2.cdi.dao.Transactional;
import br.edu.ifpb.pweb2.cdi.model.Professor;

import javax.inject.Inject;
import java.io.Serializable;

public class ProfessorController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ProfessorDAO professorDAO;

    @Transactional
    public void cadastrarProfessor(Professor professor) {
        professorDAO.insert(professor);
    }

    public Professor findByEmail(String email) {
        return professorDAO.findByEmail(email);
    }
}
