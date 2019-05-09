package db_trab2;
import db_trab2.Driver;
import java.util.Scanner;

public class JDBCExemplo {
	public static void main(String[] args) {
		Driver db = new Driver();
		System.out.println(" 1. INSERIR\n 2. BUSCAR\n 3. ATUALIZAR\n 4. DELETAR");
		
		Scanner ler = new Scanner(System.in);
		int opcao_menu = ler.nextInt();
		while(opcao_menu != -1) {
		if(opcao_menu == 1) {
			System.out.println("digite o id do hotel");
			int idHotel = ler.nextInt();
			System.out.println("digite o id do endereco do hotel");
			int idEnderecoEspecifico = ler.nextInt();
			System.out.println("digite o nome do hotel");
			String Nome = ler.next();
			System.out.println("digite o site do hotel");
			String Site = ler.next();
			System.out.println("digite o telefone do hotel com apenas números");
			String telefone = ler.next();
			db.inserirHotel(idHotel,idEnderecoEspecifico,Nome,Site,telefone);
		}
		if(opcao_menu == 2) {
			System.out.println("digite o id do hotel a ser buscado");
			int idHotel = ler.nextInt();
			db.buscarHotel(idHotel);
		}
		if(opcao_menu == 3) {
			System.out.println("digite o id do hotel a ser atualizado");
			int idHotel = ler.nextInt();
			System.out.println("digite o id do endereco do hotel");
			int idEnderecoEspecifico = ler.nextInt();
			System.out.println("digite o nome do hotel");
			String Nome = ler.next();
			System.out.println("digite o site do hotel");
			String Site = ler.next();
			System.out.println("digite o telefone do hotel com apenas números");
			int telefone = ler.nextInt();
			db.atualizarHotel(idHotel,idEnderecoEspecifico,Nome,Site,telefone);
		}
		if(opcao_menu == 4) {
			System.out.println("digite o id do hotel a ser deletado");
			int idHotel = ler.nextInt();
			db.deletarHotel(idHotel);
		}
		System.out.println(" 1. INSERIR\n 2. BUSCAR\n 3. ATUALIZAR\n 4. DELETAR");
		opcao_menu = ler.nextInt();
		}
		ler.close();
	}
	
}

