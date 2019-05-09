package db_trab2;

import java.sql.*; 
public class Driver {	
	String dbURL = "jdbc:mysql://127.0.0.1:3306/?user=root";
	String usuario = "root";
	String senha = "franchin";
	
	public void inserirHotel(int idHotel, int idEnderecoEspecifico, String Nome, String Site, String telefone) {
		try (Connection myConn = DriverManager.getConnection(dbURL,usuario,senha)){
		String sql = "INSERT INTO PacotesDeViagem.Hotel (idHotel, idEnderecoEspecifico, Nome, Site, Telefone) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement = myConn.prepareStatement(sql);
		statement.setInt(1, idHotel);
		statement.setInt(2, idEnderecoEspecifico);
		statement.setString(3, Nome);
		statement.setString(4, Site);
		statement.setString(5, telefone);
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("Inserido com Sucesso!\n");
		}
		myConn.close();
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public void buscarHotel(int idHotel) {
		try (Connection myConn = DriverManager.getConnection(dbURL,usuario,senha)){
			String sql = "SELECT * FROM PacotesDeViagem.Hotel WHERE Hotel.idHotel = '"+idHotel+"';";
						
			Statement statement = myConn.createStatement();
			ResultSet result = statement.executeQuery(sql); 
			while (result.next()){
			    int idEndereco = result.getInt(2);
			    String nome = result.getString(3);
			    String site = result.getString(4);
			    String telefone = result.getString(5);
			 
			    String output = "Hotel:  [%d] - [%s] - [%s] - [%s]\n";
			    System.out.println(String.format(output,idEndereco, nome, site, telefone));
			}
			myConn.close();
		} 
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

	public void atualizarHotel(int idHotel, int idEndereco, String nome, String site, int telefone) {
		try (Connection myConn = DriverManager.getConnection(dbURL,usuario,senha)){
			String sql = "UPDATE PacotesDeViagem.Hotel SET idEnderecoEspecifico=?, Nome=?, Site=?, Telefone=? WHERE idHotel=?";
			 
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setInt(1, idEndereco);
			statement.setString(2, nome);
			statement.setString(3, site);
			statement.setInt(4, telefone);
			statement.setInt(5,idHotel);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("Hotel atualizado com sucesso!\n");
			}
			myConn.close();
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public void deletarHotel(int idHotel) {
		try (Connection myConn = DriverManager.getConnection(dbURL,usuario,senha)){
			String sql = "DELETE FROM PacotesDeViagem.Hotel WHERE idHotel=?";
			 
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setInt(1, idHotel);
			 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Hotel deletado com sucesso!\n");
			}
			myConn.close();
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

	
}
