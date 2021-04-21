package br.edu.ifpb.pweb2.cdi.bean;

import br.edu.ifpb.pweb2.cdi.controller.ProfessorController;
import br.edu.ifpb.pweb2.cdi.model.Professor;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "professorBean")
@ViewScoped
public class ProfessorBean implements Serializable {
    @Inject
    private ProfessorController professorController;

    @Inject
    private Professor professor;

    public String cadastrar() {
        if (!professor.getEmail().equals("") && !professor.getPassword().equals("")) {
            professor.hashPassword();
            this.professorController.cadastrarProfessor(professor);
            //        return "logar";
        }

        return "";
    }

    public String login() {
        if (!professor.getEmail().equals("") && !professor.getPassword().equals("")) {
            Professor p = professorController.findByEmail(professor.getEmail());
            boolean verified = p.verifyPassword(professor.getPassword());
			// TODO: return home page
        }

        return "";
    }

}
