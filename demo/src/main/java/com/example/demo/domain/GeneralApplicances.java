package com.example.demo.domain;

import java.util.List;
import java.util.Objects;

public class GeneralApplicances extends MajorAppliance{

    private List<String> keywords;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralApplicances that = (GeneralApplicances) o;
        return Objects.equals(getKeywords(), that.getKeywords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKeywords());
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }


}
