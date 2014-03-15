package springCollections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest {
	private List<String> names;
	private Map<String,String> hoods;
	private Set<String> stores;

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Map<String, String> getHoods() {
		return hoods;
	}

	public void setHoods(Map<String, String> hoods) {
		this.hoods = hoods;
	}

	public Set<String> getStores() {
		return stores;
	}

	public void setStores(Set<String> stores) {
		this.stores = stores;
	}
}
