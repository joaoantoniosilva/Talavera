package Entidades;

import java.util.Map;

public class RelatoriosEEstatistica {
	  private String restaurantName;
	    private String period;
	    private Map<String, Double> revenueByMonth;
	    private Map<String, Integer> customersPerDay;
	    private Map<String, Double> ingredientCostByMonth;

	    public void RestaurantStatistics(String restaurantName, String period, Map<String, Double> revenueByMonth, 
	                               Map<String, Integer> customersPerDay, Map<String, Double> ingredientCostByMonth) {
	        this.setRestaurantName(restaurantName);
	        this.setPeriod(period);
	        this.setRevenueByMonth(revenueByMonth);
	        this.setCustomersPerDay(customersPerDay);
	        this.setIngredientCostByMonth(ingredientCostByMonth);
	    }
	    
	    // Outros atributos, construtores, getters e setters

	    // Métodos construtores

		public String getRestaurantName() {
			return restaurantName;
		}

		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}

		public String getPeriod() {
			return period;
		}

		public void setPeriod(String period) {
			this.period = period;
		}

		public Map<String, Double> getRevenueByMonth() {
			return revenueByMonth;
		}

		public void setRevenueByMonth(Map<String, Double> revenueByMonth) {
			this.revenueByMonth = revenueByMonth;
		}

		public Map<String, Integer> getCustomersPerDay() {
			return customersPerDay;
		}

		public void setCustomersPerDay(Map<String, Integer> customersPerDay) {
			this.customersPerDay = customersPerDay;
		}

		public Map<String, Double> getIngredientCostByMonth() {
			return ingredientCostByMonth;
		}

		public void setIngredientCostByMonth(Map<String, Double> ingredientCostByMonth) {
			this.ingredientCostByMonth = ingredientCostByMonth;
		}

}
