package br.edu.ifpb.pweb2.cdi.bean;

import br.edu.ifpb.pweb2.cdi.controller.ProfessorController;
import br.edu.ifpb.pweb2.cdi.model.Professor;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "loginProfessorBean")
@ViewScoped
public class LoginProfessorBean extends GenericBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Professor professor;

    @Inject
    private ProfessorController professorController;

    public Professor getProfessor() {
        return this.professor;
    }

    public String login() {
        if (!professor.getEmail().equals("") && !professor.getPassword().equals("")) {
            Professor p = professorController.findByEmail(professor.getEmail());
            boolean verified = p.verifyPassword(professor.getPassword());
            if (verified) {
                System.out.println("Logado com sucesso!");

                return "home?faces-redirect=true";
            }
        }

        return "";
    }
}
