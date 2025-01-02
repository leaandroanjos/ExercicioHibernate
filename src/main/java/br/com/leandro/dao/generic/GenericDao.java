package br.com.leandro.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDao<T> implements IGenericDao<T> {

    public abstract Class<T> buscarClasse();

    @Override
    public T cadastrar(T entity) {
        // Cria o EntityManagerFactory com base no persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        // Cria o EntityManager
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        // Fecha o EntityManager e o EntityManagerFactory
        em.close();
        emf.close();
        return entity;
    }

    @Override
    public void excluir(T entity) {
        // Cria o EntityManagerFactory com base no persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        // Cria o EntityManager
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        entity = em.merge(entity);
        em.remove(entity);
        em.getTransaction().commit();

        // Fecha o EntityManager e o EntityManagerFactory
        em.close();
        emf.close();
    }

    @Override
    public List<T> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(buscarClasse());
        Root<T> root = query.from(buscarClasse());
        query.select(root);

        TypedQuery<T> tpQuery =
                entityManager.createQuery(query);
        List<T> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}
