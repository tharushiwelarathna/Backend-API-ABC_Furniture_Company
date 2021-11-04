package lk.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    private String adminemail;
    private String password;
    private String address;
    private String contact;


}
