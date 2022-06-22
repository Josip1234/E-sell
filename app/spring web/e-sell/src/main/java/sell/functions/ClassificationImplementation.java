package sell.functions;

import java.util.List;
import java.util.Map;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class ClassificationImplementation extends Numeric implements Classification {

	@Override
	public Double divideInHalf(Double number) {
		
		return number/2.0;
	}

	@Override
	public Double subtractNumber(Double number, Double with) {
		
		return number-with;
	}

	@Override
	public Double rememberRemainder(Double number) {
		setRemainder(number);
		return getRemainder();
	}

	@Override
	public Map<Double, Double> addToMap(Double key, Double value) {
	    getClassification().putIfAbsent(key, value);
		return getClassification();
	}

	@Override
	public List<Map<Double, Double>> addMapToList(Map <Double,Double> map) {
		getList().add(map);
		return getList();
	}

	@Override
	public boolean checkDecimalValue(double number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double rememberNewMaximum(double number) {
		setMaximum(number);
		return getMaximum();
	}

	@Override
	public boolean isLast(int count, int listLength) {
		boolean itIs=false;
		if(count==listLength) {
			itIs=true;
		}else {
			itIs=false;
		}
		return itIs;
	}

	@Override
	public boolean isFirst(int count) {
		boolean itIs=false;
		if(count==1) {
			itIs=true;
		}else {
			itIs=false;
		}
		return itIs;
	}
    //need to change this to list of map key value
	//we need only 4 classes so this will need to modify it. We will use as parameter number of data we want to display.
	@Override
	public Map<Double,Double> returnPriceListForHomePage(Double maximumValue) {
		initMap();
		rememberRemainder(0.0);
		rememberNewMaximum(maximumValue);
	    setCounter(0);
	    getClassification().put(0.0, 0.0);
	    while(getMaximum()>1.99) {
	    if(getCounter()==0) {
	    	 System.out.println("Start Remainder:"+getRemainder().toString());
	 	    System.out.println("Start Maximum:"+getMaximum().toString());
	 	    System.out.println("Start Counter:"+getCounter().toString());
	 	    setCounter(getCounter()+1);
	 	   System.out.println("Next Counter:"+getCounter().toString());
	 	   
	 	   if(checkMaximum(getMaximum())==true) {
	 		  printMap(getClassification());
	 		   break;
	 	   }
	 	   
	    }else if(isFirst(getCounter())==true) {

			   setRemainder(divideInHalf(maximumValue));
			   setKey(getRemainder());
			   setValue(getMaximum());
			   getClassification().put(getValue(), getKey());
			   System.out.println("First key:"+getKey().toString());
			   System.out.println("First value:"+getValue().toString());
			   setRemainder(subtractNumber(getRemainder(), Double.valueOf(1)));
			   System.out.println("New remainder:"+getRemainder());
			   setCounter(getCounter()+1);
			   System.out.println("Next Counter:"+getCounter().toString());
			   
			   if(checkMaximum(getMaximum())==true) {
				   printMap(getClassification());
		 		   break;
		 	   }
	    }else {
	        rememberNewMaximum(getRemainder());
	        System.out.println("New Maximum:"+getMaximum().toString());
	        setRemainder(divideInHalf(getMaximum()));
	        System.out.println("New remainder:"+getRemainder());
	        setCounter(getCounter()+1);
	        setKey(getMaximum());
	        setValue(getRemainder());
	        getClassification().put(getValue(), getKey());
	        System.out.println("Next key:"+getKey().toString());
			System.out.println("Next value:"+getValue().toString());
			System.out.println("Next Counter:"+getCounter().toString());
			
			   if(checkMaximum(getMaximum())==true) {
				   printMap(getClassification());
		 		   break;
		 		
		 	   }
	   }
	    

	    }
	    
	  //we need to write function here for hash map which will be used to limit classes and 
	  //display random class range.
		   
	   setClassification(GeneralFunctions.displayValues(getClassification(), 4));
		return getClassification();
	}
	
	public boolean checkMaximum(Double maximum) {
	    if(getMaximum()<2.0) {
	    	rememberNewMaximum(2.0);
	    	rememberRemainder(0.0);
	    	   System.out.println("Last Maximum:"+getMaximum().toString());
	           System.out.println("Last remainder:"+getRemainder());
	           setKey(getMaximum());
		        setValue(getRemainder());
		        getClassification().put(getValue(), getKey());
		        System.out.println("Next key:"+getKey().toString());
				System.out.println("Next value:"+getValue().toString());
	    	return true;
    }else {
    	return false;
    }
	}

	
	public void printMap(Map<Double, Double> map) {
		for (Map.Entry<Double, Double> entry : map.entrySet()) {
			Double key = entry.getKey();
			Double val = entry.getValue();
		    
			System.out.println(key+"-"+val);
			
		}
	}
}
