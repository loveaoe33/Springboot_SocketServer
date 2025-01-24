package ObjectClass;

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
public class UserObject {
   public String account;
   public String accountData;
   public String accountLevel;
   public boolean isAccountActive;
}
