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

	@Override
	public List<Double> returnPriceListForHomePage(Double maximumValue) {
		rememberRemainder(0.0);
		rememberNewMaximum(maximumValue);
	    setCounter(0);
	    System.out.println("Start Remainder:"+getRemainder().toString());
	    System.out.println("Start Maximum:"+getMaximum().toString());
	    System.out.println("Start Counter:"+getCounter().toString());
	    setCounter(getCounter()+1);
	    System.out.println("Next Counter:"+getCounter().toString());
	   if(isFirst(getCounter())==true) {
		   setRemainder(divideInHalf(maximumValue));
		   setKey(getRemainder());
		   setValue(getMaximum());
		   System.out.println("First key:"+getKey().toString());
		   System.out.println("First value:"+getValue().toString());
		   setRemainder(subtractNumber(getRemainder(), Double.valueOf(1)));
		   System.out.println("New remainder:"+getRemainder());
		   setCounter(getCounter()+1);
		   System.out.println("Next Counter:"+getCounter().toString());
		   
	   }else {
	        rememberNewMaximum(getRemainder());
	        System.out.println("New Maximum:"+getMaximum().toString());
	        setRemainder(divideInHalf(getMaximum()));
	        System.out.println("New remainder:"+getRemainder());
	        setCounter(getCounter()+1);
	        setKey(getMaximum());
	        setValue(getRemainder());
	        System.out.println("Next key:"+getKey().toString());
			System.out.println("Next value:"+getValue().toString());
	   }
	 
		
		return null;
	}

}
