package sell.functions;

import java.util.List;
import java.util.Map;

public interface Classification{
  public Double divideInHalf(Double number);
  public Double subtractNumber(Double number,Double with);
  public Double rememberRemainder(Double number);
  public Map<Double,Double> addToMap(Double key,Double value);
  public List<Map<Double,Double>> addMapToList(Map<Double,Double> map);
  public boolean checkDecimalValue(double number);
  public double rememberNewMaximum(double number);
  public boolean isLast(int count, int listLength);
  public boolean isFirst(int count);
  public List<Double> returnPriceListForHomePage(Double maximumValue);
  
}
