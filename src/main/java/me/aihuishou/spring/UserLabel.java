package me.aihuishou.spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * p.80 自定义标签bean
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLabel {

    private String id;
    private String userName;
    private String email;
}
