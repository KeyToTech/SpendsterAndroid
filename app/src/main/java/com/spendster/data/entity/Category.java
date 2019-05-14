package com.spendster.data.entity;

import java.util.Date;

public class Category {
    private final int categoryId;
    private final String userId;
    private final String nameOfCategory;
    private final String type;
    private final Date createdDate;
    private final int icon;

    public Category(int categoryId, String userId, String nameOfCategory, String type, int icon, Date createdDate) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.nameOfCategory = nameOfCategory;
        this.type = type;
        this.createdDate = createdDate;
        this.icon = icon;
    }

    public Category(String nameOfCategory, int icon) {
        this(0, "", nameOfCategory, "", icon, new Date());
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
