package sber.test.p1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author UserAdmin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegUser {
    private String username;
    private String password;
    private String name;
    private String fname;
}
