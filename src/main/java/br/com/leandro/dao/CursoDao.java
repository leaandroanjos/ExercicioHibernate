package br.com.leandro.dao;

import br.com.leandro.dao.generic.GenericDao;
import br.com.leandro.domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursoDao extends GenericDao<Curso> implements ICursoDao {

    public Class<Curso> buscarClasse(){
        return Curso.class;
    }

}
