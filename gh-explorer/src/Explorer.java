import java.util.Scanner;

import Query.QueryInterface;
import Search.Searcher;

public class Explorer {

	private static Scanner in;

	public static void main(String[] args) throws Exception {
		System.out.println("Voc� quer buscar por usu�rios (1) ou reposit�rios (2)? Escolha um n�mero.");
		in = new Scanner(System.in);
		int type = in.nextInt();

		QueryInterface query = Factory.createQuery(type);
		
		query.askAndMount();
		
		Searcher searcher = Factory.createSearcher(query.getExpectedOutput(), query);
		
		System.out.println("Vamos procurar por: " + searcher.getType());
		
		searcher.find();
	}

}
