package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

/***
 * Root class
 * Represents Categoru, product categories for SquareTrade.
 */
public class Category {


    /**
     * Attribute for each category there are zero or more keywords associated with it.
     */
    private  List<String> keywords;


    public Category() {
        this.keywords = new ArrayList<>();
        this.keywords.add("general");
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * This method returns the category path from the root.
     * @return list
     */
    public List<String>  getLevel() {
        return this.getKeywords();
    }
}
