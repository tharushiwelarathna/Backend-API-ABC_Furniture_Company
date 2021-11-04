package lk.abc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Category {
    @Id
    private String categoryID;
    private String category;
    private String categoryType;
    private String description;
    private String displayName;
    private String availableBrands;
    private String status;
}
