package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.infra.FabricaDeConexao;
import br.com.modelo.Modulo;

public class ModuloDAO {

	private Connection con;
	private PreparedStatement stmt;
	
	public ModuloDAO(){
		this.con = new FabricaDeConexao().getConnection(); 
	}
	
	public void novoModulo(Modulo modulo){
		
		
		String sql = "insert into modulos(mod_nome, mod_valor, mod_cur, mod_descricao) values (?,?,?,?)";
		
		
		try {
			/*insere uma nova agenda na tabela Agenda*/
			stmt = con.prepareStatement(sql);
			stmt.setString(1, modulo.getNome());
			stmt.setDouble(2, modulo.getValor());
			stmt.setLong(3, modulo.getCurso());
			stmt.setString(4, modulo.getDescricao());
			
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizaModulo(Modulo modulo){
		
		String sql = "update modulos "
				+ "set mod_nome = ?, mod_valor = ?, mod_cur = ?, mod_desc = ?"
				+ " where mod_id = ?";
		

		try {
			/*insere uma nova agenda na tabela Agenda*/
			stmt = con.prepareStatement(sql);
			stmt.setString(1, modulo.getNome());
			stmt.setDouble(2, modulo.getValor());
			stmt.setLong(3, modulo.getCurso());
			stmt.setString(4, modulo.getDescricao());
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Modulo> pesquisaModulo(String nome){
		
		String sql = "select * from modulos where mod_nome = ? ";
		
		List<Modulo> modulo = new ArrayList<Modulo>();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Modulo mod = new Modulo();
				
				
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modulo;
		
	}
	
}
