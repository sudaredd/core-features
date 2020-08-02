package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Server {
	   private String name;
	   private String attribute1;
	   private String attribute2;

	   public Server(String name) { this.name = name; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	@Override
	public String toString() {
		return "Server [name=" + name + ", attribute1=" + attribute1
				+ ", attribute2=" + attribute2 + "]";
	}

	   //Getters & Setters

	}

public class MergeLists {

	public static void main(String[] args) {

		List<Server> servers1 = new ArrayList<>();
		Server s1 = new Server("MyServer");
		s1.setAttribute1("Attribute1");
		servers1.add(s1);

		List<Server> servers2 = new ArrayList<>();
		Server s2 = new Server("MyServer");
		s2.setAttribute2("Attribute2");
		servers2.add(s2);
		

        Map<String, Server> serverMap1 = servers1.stream().collect(Collectors.toMap(Server::getName, Function.identity()));
        
        servers2
        .forEach(key->serverMap1.get(key.getName()).setAttribute2(key.getAttribute2()));
        
        System.out.println(serverMap1);
	}

}
