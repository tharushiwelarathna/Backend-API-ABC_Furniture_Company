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
public class CategoryDTO {
    private String categoryID;
    private String category;
    private String categoryType;
    private String description;
    private String displayName;
    private String availableBrands;
    private String status;
}
