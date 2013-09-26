package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.infra.FabricaDeConexao;
import br.com.modelo.Cidade;

public class CidadeDAO {

	private Connection con;
	private PreparedStatement stmt;
	
	public CidadeDAO(){
		this.con = new FabricaDeConexao().getConnection(); 
	}
	
	public void novoCadastro(Cidade cidade){
		
		
		String sql = "insert into cidade(cid_nome, cid_sigla) values (?,?)";
		
		try {
			/*insere uma nova agenda na tabela Agenda*/
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cidade.getCidade());
			stmt.setString(2, cidade.getSigla());
			
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizaCadastro(Cidade cidade){
		
		String sql = "update cidade set cid_nome = ?, cid_sigla = ? where cid_id = ?";
		
		try {
			/*insere uma nova agenda na tabela Agenda*/
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cidade.getCidade());
			stmt.setString(2, cidade.getSigla());
			stmt.setLong(3, cidade.getId());
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Cidade> pesquisaCidade(String nome){
		
		String sql = "select * from Cidade where cid_nome = ? ";
		
		List<Cidade> cidade = new ArrayList<Cidade>();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Cidade cid = new Cidade();
				
				cid.setId(rs.getInt("cid_id"));
				cid.setCidade(rs.getString("cid_nome"));
				cid.setSigla(rs.getString("cid_sigla"));

				cidade.add(cid);
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cidade;
		
	}
	
}
