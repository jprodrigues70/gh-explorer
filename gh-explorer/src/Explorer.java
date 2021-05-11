import java.util.ArrayList;
import java.util.Scanner;

import File.Csv;
import GitHubEntity.GitHubEntity;
import GitHubOutput.GitHubOutput;
import Query.QueryInterface;

public class Explorer {

	private static Scanner in;

	public static void main(String[] args) throws Exception {
		System.out.println("Você quer buscar por usuários (1) ou repositórios (2)? Escolha um número.");
		in = new Scanner(System.in);
		int type = in.nextInt();

		QueryInterface query = Factory.createQuery(type);
		
		query.askAndMount();
		
		Searcher searcher = Factory.createSearcher(query.getExpectedOutput(), query);		
		System.out.println("Vamos procurar por: " + searcher.getUrl());
		
		GitHubOutput output = searcher.find();
		ArrayList items = output.getItems();
		
		new Csv();
		
//        String input = "[\"user1\",\"track1\",\"player1\", \"user1\",\"track2\",\"player2\", \"user1\",\"track3\",\"player3\"]";
//        input = input.substring(1, input.length() - 1); // get rid of brackets
//        String[] split = input.split(" ");
//
//        FileWriter writer = new FileWriter("/Users/artur/tmp/csv/sto1.csv");
//
//        for(String s : split) {
//            String[] split2 = s.split(",");
//            writer.write(Arrays.asList(split2).stream().collect(Collectors.joining(",")));
//            writer.write("\n"); // newline
//        }
//
//        writer.close();
	}

}
