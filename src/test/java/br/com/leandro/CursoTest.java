package br.com.leandro;

import br.com.leandro.dao.CursoDao;
import br.com.leandro.dao.ICursoDao;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import br.com.leandro.domain.Curso;

import java.util.List;

public class CursoTest {
    private ICursoDao cursoDao;

    public CursoTest(){
        cursoDao = new CursoDao();
    }

    @After
    public void end(){
        List<Curso> list = cursoDao.buscarTodos();
        list.forEach(
                curso -> {
                    cursoDao.excluir(curso);
                }
        );
    }

    @Test
    public void cadastrar(){
        Curso curso = new Curso();
        curso.setCodigo("C1");
        curso.setDescricao("Descrição do Curso");
        curso.setNome("Curso Java");
        curso = cursoDao.cadastrar(curso);

        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());
        System.out.println(curso.getId());
    }

}
