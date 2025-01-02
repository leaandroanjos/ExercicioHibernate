package br.com.leandro.dao;

import br.com.leandro.dao.generic.GenericDao;
import br.com.leandro.domain.Curso;
import br.com.leandro.domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MatriculaDao extends GenericDao<Matricula> implements IMatriculaDao {

    public Class<Matricula> buscarClasse(){
        return Matricula.class;
    }

}
