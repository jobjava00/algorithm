package algorithm.hackerrank.practice.advanced;

interface Food {
	String getType();
}

class Pizza implements Food {
	public String getType() {
		return "Someone ordered a Fast Food!";
	}
}

class Cake implements Food {
	public String getType() {
		return "Someone ordered a Dessert!";
	}
}

class FoodFactory {
	public Food getFood(String order) {
		if ("pizza".equals(order))
			return new Pizza();
		else if ("cake".equals(order))
			return new Cake();
		else
			return null;
	}
}