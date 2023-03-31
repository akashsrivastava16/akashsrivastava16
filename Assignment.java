package com.palle;


import java.util.Scanner;

public class Rev{
	static Scanner sc = new Scanner(System.in);
	/*static LinkedHashMap<String, Integer> lh = new LinkedHashMap<String, Integer>();
	static ArrayList al = new ArrayList();*/
	static int vegcost =  0;
	static int vegsum = 0;
	static int nonvegsum = 0;
	static int nonVegcost = 0;
	static int sidesCost=0;
	static int cost=0;
	public static void main(String[] args) {
		
		System.out.println("welcome to vikasietum Pizza Hut");
		int flag = 1;
		String type=null;
		while(flag==1)
		{
		System.out.println("press 1:vegetarian pizza ,2:non-vegetarian pizza,3:side dishes,any number:exit");
		int press = sc.nextInt();
		switch(press)
		{
		case 1: type="vegetarian pizza";
				/*al.add(type);*/
				vegcost = vegetarian();
				vegsum = vegsum + vegcost;
		       break;
			
		case 2:type="non-vegetarian pizza";
				/*al.add(type);*/
				 nonVegcost =nonVegetarian() ;
				nonvegsum = nonvegsum +nonVegcost;
				break;
		case 3 :sidesCost = sides();
		break;
		default:flag = 0;
		}
		cost=vegsum+nonvegsum+sidesCost;
		
		}
		if(vegsum !=0)
		{
		System.out.println("veg cost: "+vegsum);
		}
		if(nonvegsum!=0)
		{
		System.out.println("non-veg cost: "+nonvegsum);
		}
		if(sidesCost!=0)
		{
			System.out.println("sides cost:"+sidesCost);
		}
		System.out.println("total cost: "+cost);
	}
		
	private static int sides() {
		System.out.println("sides: press 1-cold drink 2-mousse cake 3-both");
		int press = sc.nextInt();
		int cd = 0;
		int mc=0;
		int sum =0;
		if(press == 1)
		{
			System.out.println("enter number of cold drinks");
			int cc = sc.nextInt();
			cd = cc * 55;
			sum = cd;
		}
		else if(press ==2)
		{
			System.out.println("enter number of mousse cake");
			int cc = sc.nextInt();
			mc = cc * 90;
			sum=mc;
		}
		else
		{
			System.out.println("enter number of cold drinks");
			int cc = sc.nextInt();
			cd = cc * 55;
			System.out.println("enter number of mousse cake");
			int mm = sc.nextInt();
			mc = mm * 90;
			sum = cd+mc;
		}
		return sum;
	}

	private static int nonVegetarian() {
			System.out.println("press 1:non-veg supreme, press 2: chicken tikka,"
					+ " press 3:pepper barbeque chicken");
			int press = sc.nextInt();
			String type=null;
			switch(press)
			{
			case 1:type="non-veg supreme";
					/*al.add(type);*/
					int cost = nonVegBase(press);
			       int sum = selectTopings();
			       return cost+sum;
			case 2:type="chicken tikka";
					/*al.add(type);*/
				cost = nonVegBase(press);
		       		sum = selectTopings();
		       		return cost+sum;
			case 3:type="pepper barbeque chicken";
					/*al.add(type);*/
				cost = nonVegBase(press);
		       		sum = selectTopings();
		       		return cost+sum;
		      default: return 0;
			}
			
			}
		
		
	private static int selectTopings() {
		System.out.println("press 1:only veg toppings, press 2:only non veg toppings , press 3:both, press 4:extra cheese");
	       int press = sc.nextInt();
	       int cost=0;
	       String type="non veg";
	       switch (press) 
	       {
	       case 1: cost = vegtoppings(type);
		     	return cost;
			
			
	       case 2:cost = nonVegToppings();
				 return cost;
				 
	       case 3 : int ncost = nonVegToppings();
	       			int vcost = vegtoppings(type);
	       			return ncost+vcost;
	       case 4: cost = extraCheese();
	       			return cost;
		}
		return 0;
	}
		private static int extraCheese() {
		return 35;
	}

		public static int vegetarian()
		{
			System.out.println("press 1: deluxe veggie, press 2:cheese and corn, "
					+ "press 3:paneer tikka");
			int press = sc.nextInt();
			int bcost = 0;
			int tcost = 0;
			int total = 0 ;
			String type="veg";
			String style=null;
			switch(press)
			{
			case 1 :style="deluxe veggie";
					/*al.add(style);*/
					bcost = vegbase(press);
				     tcost= vegtoppings(type);
				     total = bcost+tcost;;
				     return total;
					 
			case 2 :style="cheese and corn";
					/*al.add(style);*/
					bcost = vegbase(press);
			        tcost = vegtoppings(type);
			        total = bcost+tcost;;
				     return total;
		            
			case 3 :style="paneer tikka";
					/*al.add(style);*/
					bcost= vegbase(press);
	                tcost= vegtoppings(type);
	                total = bcost+tcost;;
				     return total;
           
		}
			
			return total;
			
}
		public static String typeOfCrust()
		{
			System.out.println("press 1:new hand tossed, press 2: wheat thin crust"
					+ "press 3: cheese burst, press 4: fresh pan pizza");
			int press = sc.nextInt();
			switch(press)
			{
			case 1: return "new hand tossed";
			case 2: return "wheat and crust";
			case 3: return "cheese burst";
			case 4: return "fresh pan pizza";
			default: return null;
			}
		
			
		}
		public static int vegtoppings(String type)
		{
			int sum = 0;
			int val = 0;
			System.out.println("Do you want extra toppings? "
	         		+ "yes:press 1,no:press any number");
	        int press = sc.nextInt();
	        if(press == 1)
	        {
			
			int flag = 1;
			
			while(flag == 1)
			{
				sum = sum + val;
			System.out.println("enter 1:black olive, 2:capsicum, 3:paneer, 4:mushroom, 5:fresh tomato,6:extra cheese,Any other key:exit");
			press = sc.nextInt();
			String toppings = null;
			if(type.equals("non veg") && press==3)
			{
				System.out.println("paneer toppings not allowed for non veg pizza");
				continue;
			}
			else
			{
			
			switch(press)
			{
			case 1 :toppings="black olive";
				    val = 20; 
				    break;
				
			case 2: toppings="capsicum";
					val = 25;
					break;
					
			case 3 :toppings="paneer";
					val = 35;	
					break;
					
				
			case 4: toppings="mushroom";
				val = 30;
				break;
				
				
			case 5: toppings="fresh tomato";
					val= 10;
					break;
				
			case 6: toppings ="extra cheese";
					val = 35;
					break;
			default: flag = 0;
			}
			}
			}
	        }
	        
			return sum;
	        
		}
		
		
		public static int nonVegToppings()
		{
			
	        System.out.println("you can have only one type of non veg toppings");
	        
			System.out.println("press 1:chicken tikka, press 2:barbeque chicken, press 3:grilled chicken");
			int press = sc.nextInt();
			String toppings= null;
			int cost=0;
			switch(press)
			{
			case 1 :toppings="chicken tikka";
				cost= 35;
				break;
			case 2: toppings = "barbeque chicken" ;
			    cost = 45;
			    break;
			case 3: toppings = "grilled chicken";
				cost= 40;
				break;
			
			}
	
			return cost;
	        
		}
		
		public static int vegbase(int x)
		{
			System.out.println("enter type of crust");
			String crust = typeOfCrust();
			System.out.println("press 1: regular, press 2:medium, press 3:large");
			int press = sc.nextInt();
			String size = null;
			int cost=0;
			if(x==1)
			{
				size = "regular";
				if(press == 1)
				{
					cost = 150;
					
				}
				else if(press == 2)
				{
					cost=200;
					
				}
				else if(press == 3)
				{
					cost=325;
					
				}
				
			}
			else if(x == 2)
			{
				size = "medium";
				if(press == 1)
				{
					cost= 175;
					
				}
				else if(press == 2)
				{
					cost= 375;
				}
				else if(press == 3)
				{
					cost= 475;
				}
			}
			else if(x == 3)
			{
				size="large";
				if(press == 1)
				{
				cost= 150;
				}
				else if(press == 2)
				{
				cost= 200;
				}
			   else if(press == 3)
			    {
				cost= 325;
			     }
		}
		
		return cost;
		
	
		}
		
		public static int nonVegBase(int x)
		{
			System.out.println("enter type of crust");
			String crust = typeOfCrust();
			System.out.println("press 1: regular, press 2:medium, press 3:large");
			int press = sc.nextInt();
			int cost = 0;
			String size = null;
			if(x==1)
			{
				size="regular";
				if(press == 1)
				{
					cost= 190;
				}
				else if(press == 2)
				{
					cost= 325;
				}
				else if(press == 3)
				{
					cost= 425;
				}
				
			}
			else if(x == 2)
			{
				size="medium";
				if(press == 1)
				{
					cost= 210;
				}
				else if(press == 2)
				{
					cost= 370;
				}
				else if(press == 3)
				{
					cost= 500;
				}
			}
			else if(x == 3)
			{
				size="large";
				if(press == 1)
				{
				cost= 220;
				}
				else if(press == 2)
				{
				cost= 380;
				}
			   else if(press == 3)
			    {
				cost= 525;
			     }
		}
		
			return cost;
		
		}
		

}



