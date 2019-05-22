package com.spendster.data.entity;

import java.util.Date;

public class Category {
    private final String id;
    private final String userId;
    private final String name;
    private final String type;
    private final Date createdDate;
    private final String icon;

    public Category(String id, String userId, String name, String type, String icon, Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.createdDate = createdDate;
        this.icon = icon;
    }

    public Category(String name, String icon) {
        this("", "", name, "", icon, new Date());
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }
}
