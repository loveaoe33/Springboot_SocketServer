package ObjectClass;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlockClass {
	public String Transaction;
	public String From;
	public String To;
	public BigInteger Value;
	public BigInteger Gas;
	public BigInteger Limit;
}
