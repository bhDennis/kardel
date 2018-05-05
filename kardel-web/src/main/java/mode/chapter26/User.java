package mode.chapter26;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dennis on 2018/4/3.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
}
