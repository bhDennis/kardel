package mode.chapter15;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dennis on 2018/3/5.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private String id;

    private String departmentName;
}
