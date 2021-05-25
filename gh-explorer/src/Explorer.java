import java.util.Scanner;

import Query.QueryInterface;
import Search.Searcher;

public class Explorer {

	private static Scanner in;

	public static void main(String[] args) throws Exception {
		System.out.println("Você quer buscar por usuários (1) ou repositórios (2)? Escolha um número.");
		in = new Scanner(System.in);
		int type = in.nextInt();

		QueryInterface query = Factory.createQuery(type);
		
		query.askAndMount();
		
		Searcher searcher = Factory.createSearcher(query.getExpectedOutput(), query);
		
		System.out.println("Vamos procurar por: " + searcher.getType());
		
		searcher.find();
	}

}
