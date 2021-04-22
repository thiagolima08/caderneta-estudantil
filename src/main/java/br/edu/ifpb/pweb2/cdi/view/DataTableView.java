package br.edu.ifpb.pweb2.cdi.view;

import br.edu.ifpb.pweb2.cdi.bean.AlunoBean;
import br.edu.ifpb.pweb2.cdi.model.Aluno;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("dtBasicView")
@ViewScoped
public class DataTableView implements Serializable {

    private List<Aluno> alunos;

    @Inject
    private AlunoBean alunoService;


    public List<Aluno> getAlunos() {
        this.alunos = alunoService.getAlunos();
        return alunos;
    }

    public void setService(AlunoBean service) {
        this.alunoService = service;
    }

//    public Aluno getSelectedAluno() {
//        return selectedAluno;
//    }
//
//    public void setSelectedAluno(Aluno selectedAluno) {
//        this.selectedAluno = selectedAluno;
//    }
//
//    public List<Aluno> getSelectedAlunos() {
//        return selectedAlunos;
//    }
//
//    public void setSelectedAlunos(List<Aluno> selectedAlunos) {
//        this.selectedAlunos = selectedAlunos;
//    }
//
//    public void openNew() {
//        this.selectedAluno = new Aluno();
//    }
//
//    public void saveAluno() {
//        if (this.selectedAluno.getId() == null) {
//            this.alunos.add(this.selectedAluno);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Added"));
//        }
//        else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Updated"));
//        }
//
//        PrimeFaces.current().executeScript("PF('manageAlunoDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-alunos");
//    }
//
//    public void deleteAluno() {
//        this.alunos.remove(this.selectedAluno);
//        this.selectedAluno = null;
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Removed"));
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-alunos");
//    }
//
//    public String getDeleteButtonMessage() {
//        if (hasSelectedAlunos()) {
//            int size = this.selectedAlunos.size();
//            return size > 1 ? size + " alunos selected" : "1 aluno selected";
//        }
//
//        return "Delete";
//    }
//
//    public boolean hasSelectedAlunos() {
//        return this.selectedAlunos != null && !this.selectedAlunos.isEmpty();
//    }
//
//    public void deleteSelectedAlunos() {
//        this.alunos.removeAll(this.selectedAlunos);
//        this.selectedAlunos = null;
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alunos Removed"));
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-alunos");
//        PrimeFaces.current().executeScript("PF('dtAlunos').clearFilters()");
//    }

}
