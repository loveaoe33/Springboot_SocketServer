import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repairObject.fix_Data_log;

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
