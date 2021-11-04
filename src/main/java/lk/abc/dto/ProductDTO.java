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
public class ProductDTO {
    private String productID;
    private String productName;
    private String categoryType;
    private String category;
    private String addedDate;
    private String displayName;
    private int size;
    private double productPrice;
    private String description;
    private String status;

}
