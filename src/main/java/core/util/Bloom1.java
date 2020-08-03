package core.util;

import java.util.SortedMap;
import java.util.TreeMap;

interface BloomSite {
	public void visit(String site);
	public void printTop10();
}

class BloomSiteImpl implements BloomSite {
	SortedMap<Counter,Counter> map = new TreeMap();
	@Override
	public void visit(String siteAddr) {
		Counter c = new Counter(siteAddr, -1);
		Counter c1 = map.get(c);
		Counter c2 = c1==null ? c : c1;
		c2.addCount();
		map.put(c2, c2);
	}
	@Override
	public void printTop10() {
		map.entrySet().stream().
		limit(10).forEach(e-> System.out.println("site:"+e.getKey().siteAddr + " and hits:"+e.getKey().visits));
	}
}
class Counter implements Comparable{
	public Counter(String siteAddr, int visits) {
		this.siteAddr = siteAddr;
		this.visits = visits;
	}
	public void addCount() {
		visits++;
	}
	public String getSiteAddr() {
		return siteAddr;
	}
	public int getVisits() {
		return visits;
	}
	String siteAddr; int visits;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((siteAddr == null) ? 0 : siteAddr.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter other = (Counter) obj;
		if (siteAddr == null) {
			if (other.siteAddr != null)
				return false;
		} else if (!siteAddr.equals(other.siteAddr))
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		Counter c = (Counter) o;
		return visits - c.visits;
	}
	
}

public class Bloom1 {

	public static void main(String[] args) {
		BloomSite b = new BloomSiteImpl();
		b.visit("b1");
		b.visit("b2");
		b.visit("b1");
		b.visit("b1");

		b.printTop10();
	}

}
