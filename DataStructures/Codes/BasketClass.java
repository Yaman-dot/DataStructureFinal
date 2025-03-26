package finalDataStructures;

import java.util.ArrayList;
import java.util.List;

public class BasketClass 
{
	private List<String> items;
	private List<Double> prices;
	private double budget;
	private double totalCost;
	
	public BasketClass()
	{
		items = new ArrayList<>();
		prices = new ArrayList<>();
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public boolean addItem(String Item, double price)
	{
		if((totalCost + price) <= budget)
		{
			items.add(Item);
			prices.add(price);
			totalCost = totalCost + price;
			return true;
		}
		System.out.println("Can't add " + Item + " , it exceeds the budget");
		return false;
	}
	
	public boolean removeItem(String item)
	{
		if(items.contains(item))
		{
			int index = items.indexOf(item);
			totalCost = totalCost - prices.get(index);
			items.remove(index);
			prices.remove(index);
			return true;
		}
		System.out.println("Item is not in the basket");
		return false;
	}
	
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public double getRemainingBudget()
	{
		return budget-totalCost;
	}
	
	

	public List<String> listItems() {
		return items;
	}
	
	public boolean isWithinBudget()
	{
		return totalCost<=budget;
	}

	public static void main(String[] args) 
	{
		BasketClass bc1 = new BasketClass();
		
		bc1.setBudget(20);
		
		bc1.addItem("Cheetos", 1);
		bc1.addItem("Oreos", 13);
		System.out.println("Remaining budget is " + bc1.getRemainingBudget());
		System.out.println(bc1.listItems());
		
		bc1.addItem("Ice-cream", 1);
		bc1.addItem("Chocolate", 13);
		
		System.out.println("Remaining budget is " + bc1.getRemainingBudget());
		bc1.removeItem("Oreos");
		bc1.addItem("Chocolate", 13);
		bc1.addItem("Juice", 5);
		
		System.out.println("Total Cost is " + bc1.getTotalCost());
		System.out.println("Remaining budget is " + bc1.getRemainingBudget());
		System.out.println("Is it within budget? " + bc1.isWithinBudget());
		System.out.println(bc1.listItems());

	}

}
