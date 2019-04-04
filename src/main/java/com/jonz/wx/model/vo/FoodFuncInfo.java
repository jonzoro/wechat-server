package com.jonz.wx.model.vo;

public class FoodFuncInfo {

    private String type;

    private FoodFuncInfo(Builder builder) {
        type = builder.type;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String type;

        private Builder() {
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public FoodFuncInfo build() {
            return new FoodFuncInfo(this);
        }
    }

    public String getType() {
        return type;
    }
}
