package br.tad;
/**
 * Projeto das trilhas de treinamento de Java b�sico ou avan�ado 
 * com foco nas certifica��es java e em treinamentos corporativos. 
 * Fontes dispon�veis em https://github.com/rodrigofujioka
 * 
 * Professor: Rodrigo da Cruz Fujioka
 * Ano: 2016
 * http://www.rodrigofujioka.com
 * http://www.fujideia.com.br
 * http://lattes.cnpq.br/0843668802633139
 * 
 * Contato: rcf4@cin.ufpe.br 
 * 
 */


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.tad.dao.Listagem;
import br.tad.dao.ProdutoDAO;
import br.tad.modelo.Produto;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/produtoService")
public class ProdutoService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/listaXml")
    @Produces(MediaType.APPLICATION_ATOM_XML)
    public List<Produto> listar() {
    	
    	List<Produto> listaProduto = new Listagem().listaProduto();     	
    	
    	return listaProduto;
    }
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/listaJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listarJson() {
    	
    	List<Produto> listaProduto = new Listagem().listaProduto();     	
    	
    	return listaProduto;
    }
    
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/incluir")   
    @Produces(MediaType.APPLICATION_JSON)
    public String incluir(
    		@QueryParam(value = "nome") String nome,
    		@QueryParam(value = "descricao") String descricao,
    		@QueryParam(value = "preco") String preco
    		) {
    	
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto.setNome(nome);
    	produto.setDescricao(descricao);
    	produto.setPreco(new Double(preco));    	    	
    	dao.adicionaProduto(produto);
    	    	
    	return "sucesso";
    }
    
    @GET
    @Path("/buscarProduto")   
    @Produces(MediaType.APPLICATION_JSON)
    public Produto buscarProduto(
    		@QueryParam(value = "id") int id){
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = dao.consultarProduto((long)id); 	
    	
    	return produto;
    	
    }
    
    @GET
    @Path("/removerProduto")   
    @Produces(MediaType.APPLICATION_JSON)
    public String RemoverProduto(
    		@QueryParam(value = "id") Long id){
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = dao.consultarProduto(id);
    	
    	if (produto!=null){
    		dao.RemoveProduto(produto);
    		return "Sucesso";
    	}
    	
    	return "Produto n�o encontrado";
    }
    
    @GET
    @Path("/editarProduto")   
    @Produces(MediaType.APPLICATION_JSON)
    public String editarProduto(
    		@QueryParam(value = "id") Long id,
    		@QueryParam(value = "nome") String nome,
    		@QueryParam(value = "preco") Double preco,
    		@QueryParam(value = "descricao") String descricao){
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto = dao.consultarProduto(id);
    	
    	if (produto!=null){
    		dao.alteracaoDeProduto(produto, nome, preco, descricao);
    		return "Sucesso";
    	}
    	
    	return "Produto n�o encontrado";
    }
    
    
    
    
}
