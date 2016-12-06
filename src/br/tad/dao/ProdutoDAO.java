package br.tad.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import br.tad.modelo.Produto;

public class ProdutoDAO {
	public void adicionaProduto(Produto produto){			
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();		
		session.save(produto);		
		tx.commit();		
		session.close();
	}
	
	public List<Produto> listarProdutos(){
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Query query = 
				session.createQuery("select p from Produto p ");
		
		List<Produto> listaRetorno = query.list();
		
		return listaRetorno;
	}
	
	public void RemoveProduto(Produto produto) {
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.delete(produto);
		tx.commit();
	}
	
	public Produto consultarProduto(Long id){
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Produto produto = (Produto) session.get(Produto.class, id);
		
		return produto;
	}
	
	public void alteracaoDeProduto(Produto produto, String nome,Double preco, String descricao) {
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
        if (nome!=null) {
            produto.setNome(nome);   
        }
        if(preco!=null){
            produto.setPreco(preco);
        }
        if(descricao!=null){
            produto.setDescricao(descricao);
        }
		
		session.update(produto);
		tx.commit();
}
}
