package dao;

import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

//"type": {
//    "name": "Americano",
//    "family": "Coffee"
//  },
//  "size": "Small",
//  "orderedBy": "H",
//  "coffeeShopId": 1

public class Order {
	
	private String size;
	private String orderedBy;
	private long coffeeShopId;
	private String[] selectedOptions;

	@JsonProperty("type")
	private DrinkType type;
	
	@Id
	private String id;
	
	public DrinkType getDrinkType() {
		return type;
	}
//	public void setDrinkType(DrinkType type) {
//		this.type = 
//	}
	public String getSize() {
		return size;
	}
//	public void setSize(String size) {
//		this.size = size;
//	}
	public String getOrderedBy() {
		return orderedBy;
	}
//	public void setOrderedBy(String orderedBy) {
//		this.orderedBy = orderedBy;
//	}
	public long getCoffeeShopId() {
		return coffeeShopId;
	}
//	public void setCoffeeShopId(long coffeeShopId) {
//		this.coffeeShopId = coffeeShopId;
//	}
	public String getId() {
		return id;
	}
//	public void setId(String id) {
//		this.id = id;
//	}
	
	@Override
	public String toString() {
		String ord = (type == null ? " " : this.type.getName() + " " + this.type.getFamily()) + " " + this.getSize() + " " + this.getOrderedBy() + " " + this.getCoffeeShopId() + " " + this.getId();
		return ord;
	}
	public String[] getSelectedOptions() {
		return selectedOptions;
	}
//	public void setSelectedOptions(String[] selectedOptions) {
//		this.selectedOptions = selectedOptions;
//	}
}


