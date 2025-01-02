package br.com.leandro.dao;

import br.com.leandro.dao.generic.GenericDao;
import br.com.leandro.domain.Produto;

public class ProdutoDao extends GenericDao<Produto> implements IProdutoDao {

    public Class<Produto> buscarClasse(){
        return Produto.class;
    }

}
