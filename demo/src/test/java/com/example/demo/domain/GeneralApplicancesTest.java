package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * General Applicances Test
 */
class GeneralApplicancesTest {

    @BeforeEach
    void setUp() {
    }


    /**
     * Basic test for root
     */
    @Test
    void getCategory() {
        Category category = new Category();
        List<String> categories = new ArrayList<>();
        categories.add("general");
        category.setKeywords(categories);
        Assert.notEmpty(category.getKeywords());
    }

    /**
     * Basic test from Electronics
     */
    @Test
    void getLevelFromElectronics(){
        // expected
        List<String> expected = new ArrayList<>();
        expected.add("electronics");
        expected.add("electric");
        expected.add("general");

        Electronics electronics = new Electronics();
        List<String> eleccategory = new ArrayList<>();
        eleccategory.add("electronics");
        eleccategory.add("electric");
        electronics.setKeywords(eleccategory);

        Assert.notEmpty(electronics.getKeywords());
        Assert.isTrue(areEqual(electronics, expected));
    }

    /**
     * Basic test from kitchen appliances.
     * means a path of 3 levels
     */
    @Test
    void Levels3CategoriesTest() {
        // extected
        List<String> expected = new ArrayList<>();
        expected.add("kitchenappliances");
        expected.add("homeAppliances");
        expected.add("general");
        //
        KitchenAppliances kitchenAppliances = new KitchenAppliances();
        Assert.notEmpty(kitchenAppliances.getKeywords());
        Assert.isTrue(areEqual(kitchenAppliances, expected));
    }


    /**
     * if the level/path of the category is equal to the expected path returns true.
     * @param category
     * @param expected
     * @return boolean
     */

    boolean areEqual(Category category, List<String> expected) {
        List<String>  level = category.getLevel();
        boolean areEqual = Objects.equals(level, expected);
        return areEqual;
    }
}