package sell.sellers;

import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seller_information {
@Null
private Integer id;
//foreign key for nickname from sellers table. will provide profile of seller if that seller is loggerd in. Also can be used for searching by sellers nickname. Will be used for passing parameters to all of users articles.
@Null
private String nickname;
}
