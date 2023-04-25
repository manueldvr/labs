package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class KitchenAppliances extends MajorAppliance{

    private List<String> keywords;


    public KitchenAppliances() {
        super();
        this.keywords = new ArrayList<>();
        this.keywords.add("kitchenappliances");}


    @Override
    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * This method returns the category path from the root (Category).
     * @return list
     */
    @Override
    public List<String> getLevel() {
        if (keywords.isEmpty())
            return super.getLevel();
        List<String> superKeys = super.getKeywords();
        keywords.addAll(superKeys);
        return keywords;
    }
}
