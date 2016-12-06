package br.tad.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import br.tad.modelo.Produto;

public class CriteriaListagem {
	public List<Produto> listaProduto(){
		
		addProdutosB();
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		List<Produto> listaProdutos = null;
		
		Criteria criteria = session.createCriteria(Produto.class);
		listaProdutos = criteria.list();
		
		for(Produto p : listaProdutos){
			System.out.println(p.getNome());
		}
		criteria.addOrder(Order.asc("nome"));
		listaProdutos = criteria.list();
		
		for(Produto p : listaProdutos){
			System.out.println(p.getNome());
		}
		
		session.close();
		return listaProdutos;
	}
	
	public  void addProdutosB(){
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
	    Collection<Produto> produtos = new ArrayList<Produto>();

		produtos.add(addProduto("Copo", "Copo de cristal.", 12.99));
		produtos.add(addProduto("Mochila", "Mochila de couro", 78.99));
		produtos.add(addProduto("Tenis", "Tenis da nike", 12.43));
		produtos.add(addProduto("Meia", "Meia social", 222));
		produtos.add(addProduto("Chapeu", "Chapeu esportivo", 233));
		produtos.add(addProduto("Lousa", "Lousa de vidro.", 888));
		
		Transaction tx = session.beginTransaction();
		
		for(Produto p : produtos){
			session.save(p);
		}
		
		tx.commit();
	}

    private Produto addProduto(String nome, String descricao, float preco) {
		Produto produto = new Produto();		
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(preco);
        
        return produto;
    }
}
