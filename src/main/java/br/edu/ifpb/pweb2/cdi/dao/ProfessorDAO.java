package br.edu.ifpb.pweb2.cdi.dao;

import br.edu.ifpb.pweb2.cdi.model.Professor;

public class ProfessorDAO extends GenericDAO<Professor, Integer> {
	private static final long serialVersionUID = 1L;
	// TODO metodo para achar com base no email/password

	public Professor findByEmail(String email) {
		try {
			Professor professor = entityManager.createQuery("select p from Professor as p where p.email = :email", Professor.class).setParameter("email", email).getSingleResult();
			return professor;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
}
