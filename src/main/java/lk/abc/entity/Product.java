package lk.abc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
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
