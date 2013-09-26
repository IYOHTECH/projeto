package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.infra.FabricaDeConexao;
import br.com.modelo.Agenda;

public class AgendaDAO {

	private Connection con;
	private PreparedStatement stmt;
	
	public AgendaDAO(){
		this.con = new FabricaDeConexao().getConnection(); 
	}
	
	/*
	 * realiza o novo Cadastro de uma agenda
	 */
	public void novoCadastro(Agenda agenda){
		String sql = "insert into agenda(age_local,age_bairro,age_data,age_endereco,age_mod) values (?,?,?,?,?)";
		
		try {
			/*insere uma nova agenda na tabela Agenda*/
			stmt = con.prepareStatement(sql);
			stmt.setString(1, agenda.getLocal());
			stmt.setString(2, agenda.getBairro());
			stmt.setDate(3, new java.sql.Date(agenda.getData().getTime()));
			stmt.setString(4, agenda.getEndereco());
			stmt.setLong(5, agenda.getModulo());
			
			stmt.close();
			
			//if(!commit) throw new SQLException() ; 
			
			
			sql = "select last_insert_id()";
			
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			int age_id = 0;
			
			while(rs.next()){
				age_id = rs.getInt(1);
			}
			
			stmt.close();
			
			
			/*insere um novo registro na tabela de relacionamento sera 
			 * onde contem o id da agenda e o id da cidade
			 * */
			sql = "insert into sera(ser_cid_id, ser_age_id) values(?,?)";
			
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, agenda.getCidade());
			stmt.setLong(2, age_id);
			stmt.execute();
			
			stmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizaCadastro(Agenda agenda){
		String sql = "update agenda set "
				+ "age_local = ?, age_bairro = ?, age_data = ?,"
				+ "age_endereco = ?, age_mod = ?, age_realizada = ?,"
				+ "where age_id = ?";
		
		
		try {
			/*insere uma nova agenda na tabela Agenda*/
			stmt = con.prepareStatement(sql);
			stmt.setString(1, agenda.getLocal());
			stmt.setString(2, agenda.getBairro());
			stmt.setDate(3, new java.sql.Date(agenda.getData().getTime()));
			stmt.setString(4, agenda.getEndereco());
			stmt.setLong(5, agenda.getModulo());
			stmt.setInt(6, agenda.getRealizado());
			stmt.setLong(7, agenda.getId());
			
			stmt.close();
			
			
			/*atualiza o registro na tabela de relacionamento sera 
			 * onde contem o id da agenda e o id da cidade
			 * */
			sql = "update sera set ser_cid_id = ? where ser_age_id = ?";
			
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, agenda.getCidade());
			stmt.setLong(2, agenda.getId());
			stmt.execute();
			
			stmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Agenda> pesquisaModulo(int id){
		
		String sql = "select * from Agenda where age_mod = ? ";
		
		List<Agenda> agenda = new ArrayList<Agenda>();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Agenda ag = new Agenda();
				
				ag.setId(rs.getLong("age_id"));
				ag.setLocal(rs.getString("age_local"));
				ag.setBairro(rs.getString("age_bairro"));
				ag.setData(rs.getDate("age_bairro"));
				ag.setEndereco(rs.getString("age_endereco"));
				ag.setRealizado(rs.getInt("age_realizada"));
				ag.setModulo(rs.getInt("ag_mod"));
				
				agenda.add(ag);
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agenda;
		
	}
	
	public List<Agenda> pesquisaData(Date data){
		
		String sql = "select * from Agenda where age_data = ? ";
		
		List<Agenda> agenda = new ArrayList<Agenda>();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(data.getTime()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Agenda ag = new Agenda();
				
				ag.setId(rs.getLong("age_id"));
				ag.setLocal(rs.getString("age_local"));
				ag.setBairro(rs.getString("age_bairro"));
				ag.setData(rs.getDate("age_bairro"));
				ag.setEndereco(rs.getString("age_endereco"));
				ag.setRealizado(rs.getInt("age_realizada"));
				ag.setModulo(rs.getInt("ag_mod"));
				
				agenda.add(ag);
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agenda;
		
	}

}
