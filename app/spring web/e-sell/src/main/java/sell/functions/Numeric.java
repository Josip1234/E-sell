package sell.functions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Numeric {
 public Double key;
 public Double value;
 public Double remainder;
 public Map<Double, Double> classification;
}
