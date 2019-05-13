package com.spendster.data.entity;

import java.util.Date;

public class Category {
    private final int categoryId;
    private final String nameOfCategory;
    private final boolean type;
    private final Date createdDate;
    private final int icon;

    public Category(int categoryId, String nameOfCategory, boolean type, Date createdDate, int icon) {
        this.categoryId = categoryId;
        this.nameOfCategory = nameOfCategory;
        this.type = type;
        this.createdDate = createdDate;
        this.icon = icon;
    }

    public Category(String nameOfCategory, int icon){
        this(0, nameOfCategory, false, new Date(), icon);
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public int getIcon() {
        return icon;
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
