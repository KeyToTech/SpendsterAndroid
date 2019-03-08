package com.example.firstproject;

import java.util.Date;

public class Category {
    private final int categoryId;
    private final String nameOfCategory;
    private final boolean type;
    private final Date createdDate;

    public Category(int categoryId, String nameOfCategory, boolean type, Date createdDate) {
        this.categoryId = categoryId;
        this.nameOfCategory = nameOfCategory;
        this.type = type;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", nameOfCategory='" + nameOfCategory + '\'' +
                ", type=" + type +
                ", createdDate=" + createdDate +
                '}';
    }
}
