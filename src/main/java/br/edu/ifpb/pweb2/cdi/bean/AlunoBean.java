package br.edu.ifpb.pweb2.cdi.bean;

import br.edu.ifpb.pweb2.cdi.controller.AlunoController;
import br.edu.ifpb.pweb2.cdi.model.Aluno;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PostLoad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "alunoBean")
@ViewScoped
public class AlunoBean extends GenericBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private AlunoController alunoController;

    private List<Aluno> alunos = new ArrayList<>();

    public void init() {
        this.alunos = alunoController.findAll();
        System.out.println(this.alunos);
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }
}
