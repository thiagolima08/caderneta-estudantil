package br.edu.ifpb.pweb2.cdi.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.ifpb.pweb2.bean.GenericBean;
import br.edu.ifpb.pweb2.cdi.model.Mensagem;

@Named(value = "mensagemBean")
@ViewScoped
public class MensagemBean extends GenericBean implements Serializable {
private static final long serialVersionUID = 1L;
	
	//@Inject
	private Mensagem mensagem;
	
	@PostConstruct
	public void init() {
		this.mensagem = new Mensagem("Olá, mundo JSF 2.3!");
	}
	
	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}

