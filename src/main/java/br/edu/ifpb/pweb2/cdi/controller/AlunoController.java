package br.edu.ifpb.pweb2.cdi.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.cdi.dao.AlunoDAO;
import br.edu.ifpb.pweb2.cdi.dao.Transactional;
import br.edu.ifpb.pweb2.cdi.model.Aluno;


public class AlunoController implements Serializable {
    private static final long serialVersionUID = 1L;


    @Inject
    private AlunoDAO alunoDAO;

    @Transactional
    public void excluir(Aluno aluno) {
        alunoDAO.delete(aluno);
    }

    @Transactional
    public Aluno update(Aluno aluno) {
        return alunoDAO.update(aluno);
    }

    public void refresh(Aluno aluno) {
        alunoDAO.refresh(aluno);
    }

    public List<Aluno> findAll() {
        return alunoDAO.findAll();
    }

    public Aluno find(Integer id) {
        return alunoDAO.find(id);
    }

    @Transactional
    public Aluno insert(Aluno aluno) {
        return alunoDAO.insert(aluno);
    }

    @Transactional
    public void updateNotas(Aluno aluno) {
        if (aluno.getSituacao() != Aluno.Situacao.AP) {
            if (aluno.getNota1() != null && aluno.getNota2() != null && aluno.getNota3() != null
                    && aluno.getFaltas() != null && aluno.getNotaFinal() == null) {
                double media = (aluno.getNota1().add(aluno.getNota2()).add(aluno.getNota3())).divide(new BigDecimal(3), new MathContext(2)).doubleValue();
                if (aluno.getFaltas() > 25) {
                    aluno.setSituacao(Aluno.Situacao.RF);
                } else if (media > 70) {
                    aluno.setSituacao(Aluno.Situacao.AP);
                } else if (media < 70 && media >= 40) {
                    aluno.setSituacao(Aluno.Situacao.FN);
                } else if (media < 40) {
                    aluno.setSituacao(Aluno.Situacao.RP);
                }
                this.update(aluno);
            } else if(aluno.getNota1() != null && aluno.getNota2() != null && aluno.getNota3() != null
                    && aluno.getFaltas() != null && aluno.getNotaFinal() != null && aluno.getSituacao() == Aluno.Situacao.FN) {
                BigDecimal media = (aluno.getNota1().add(aluno.getNota2()).add(aluno.getNota3())).divide(new BigDecimal(3), new MathContext(2)).multiply(new BigDecimal(60));
                BigDecimal finalAdd = (aluno.getNotaFinal().multiply(new BigDecimal(40)));
                double finalMedia = media.add(finalAdd).divide(new BigDecimal(100), new MathContext(2)).doubleValue();
                if (finalMedia >= 50) {
                    aluno.setSituacao(Aluno.Situacao.AP);
                } else {
                    aluno.setSituacao(Aluno.Situacao.RP);
                }
                this.update(aluno);
            }
        }

    }

    @Transactional
    public void saveOrUpdate(Aluno aluno) {
        if (aluno.getId() != null) {
            aluno = alunoDAO.update(aluno);
        } else {
            alunoDAO.insert(aluno);
        }

    }

}
