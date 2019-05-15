package com.spendster.data.entity;

import java.util.Date;

public class Category {
    private final String categoryId;
    private final String nameOfCategory;
    private final boolean type;
    private final Date createdDate;
    private final String icon;

    public Category(String categoryId, String nameOfCategory, boolean type, Date createdDate, String icon) {
        this.categoryId = categoryId;
        this.nameOfCategory = nameOfCategory;
        this.type = type;
        this.createdDate = createdDate;
        this.icon = icon;
    }

    public Category(String nameOfCategory, String icon){
        this("", nameOfCategory, false, new Date(), icon);
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public String getIcon() {
        return icon;
    }

    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", nameOfCategory='" + nameOfCategory + '\'' +
                ", type=" + type +
                ", createdDate=" + createdDate +
                ", icon=" + icon +
                '}';
    }
}
