package br.com.leandro;

import br.com.leandro.dao.IMatriculaDao;
import br.com.leandro.dao.MatriculaDao;
import br.com.leandro.domain.Curso;
import br.com.leandro.domain.Matricula;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.List;

public class MatriculaTest {

    private IMatriculaDao matriculaDao;

    public MatriculaTest(){
        matriculaDao = new MatriculaDao();
    }

    @After
    public void end(){
        List<Matricula> list = matriculaDao.buscarTodos();
        list.forEach(
                curso -> {
                    matriculaDao.excluir(curso);
                }
        );
    }

    @Test
    public void cadastrar(){
        Matricula matricula = new Matricula();
        matricula.setCodigo("C1");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("Ativa");
        matricula.setValor(2000D);
        matricula = matriculaDao.cadastrar(matricula);

        Assert.assertNotNull(matricula);
        Assert.assertNotNull(matricula.getId());
        System.out.println(matricula.getId());

        matriculaDao.excluir(matricula);
    }

}
