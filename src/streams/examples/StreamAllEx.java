package streams.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class StreamAllEx {

	/**
	 * 1. Find all transactions in the year 2011 and sort them by value (small
	 * to high).
	 *  2. What are all the unique cities where the traders work? 
	 *  3. Find all traders from Cambridge and sort them by name. 
	 *  4. Return a string  of all traders names sorted alphabetically.
	 *  5. Are any traders based in Milan? 
	 *  6. Print all transactions values from the traders living in Cambridge.
	 *  7. Whats the highest value
	 * 
	 * @param args
	 */

	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario", "Milan");
	Trader alan = new Trader("Alan", "Cambridge");
	Trader brian = new Trader("Brian", "Cambridge");
	List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011,300), 
										new Transaction(raoul, 2012, 1000), 
										new Transaction(raoul, 2011, 400), 
										new Transaction(mario, 2012, 710), 
										new Transaction(mario, 2012, 700), 
										new Transaction(alan, 2012, 950));
	
	public List<Transaction> ex1() {
		return transactions.stream().filter(a->a.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
	}
	
	public List<String> ex2() {
		return transactions.stream().
				map(transaction->transaction.getTrader().getCity()).
				distinct().
				collect(toList());
	}
	
	//3. Find all traders from Cambridge and sort them by name.
	public List<Trader> ex3() {
		return transactions.stream().
				filter(transaction->transaction.getTrader().getCity().equals("Cambridge")).
				map(transaction->transaction.getTrader()).
				sorted(Comparator.comparing(Trader::getName)).
				collect(toList());
	}

	//Return a string of all traders names sorted alphabetically
	public List<String> ex4() {
		return transactions.stream().
				map(transaction->transaction.getTrader().getName()).
				sorted().
				distinct().
				collect(toList());
	}
	
	//Are any traders based in Milan
	public boolean ex5() {
		return transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
	}
	
	//Print all transactions values from the traders living in 	Cambridge
	public void ex6() {
		transactions.stream().filter(t->"Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
	}
	
	//Whats the highest value of all the transactions?
	public Optional<Integer> ex7() {
		return transactions.stream().map(Transaction::getValue).reduce((a,b)->Integer.max(a, b));
	}
	
	public static void main(String[] args) {
		StreamAllEx s1 = new StreamAllEx();
		
		System.out.println(s1.ex1());
		System.out.println(s1.ex2());
		System.out.println(s1.ex3());
		System.out.println(s1.ex4());
		System.out.println("Are any traders based in Milan:"+s1.ex5());
		s1.ex6();
		System.out.println("ex7:"+s1.ex7().get());
		
	}

}
