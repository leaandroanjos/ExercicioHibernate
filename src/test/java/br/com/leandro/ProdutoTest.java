package br.com.leandro;

import br.com.leandro.dao.ProdutoDao;
import br.com.leandro.domain.Produto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {

    private ProdutoDao produtoDao;

    public ProdutoTest(){
        produtoDao = new ProdutoDao();
    }

    @After
    public void end(){
        List<Produto> lista = produtoDao.buscarTodos();
        lista.forEach(produto -> {
            produtoDao.excluir(produto);
        });
    }

    @Test
    public void cadastrar(){
        Produto produto = new Produto();
        produto.setNome("Detergente");
        produto.setCodigo("C3");
        produtoDao.cadastrar(produto);

        Assert.assertNotNull(produto);
        Assert.assertNotNull(produto.getId());
        System.out.println(produto.getId());
    }

}
