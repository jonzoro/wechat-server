package com.jonz.wx.model.vo;

public class NoteFuncInfo {

    private String operation;

    private String title;

    private String content;

    private NoteFuncInfo(Builder builder) {
        operation = builder.operation;
        title = builder.title;
        content = builder.content;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String operation;
        private String title;
        private String content;

        private Builder() {
        }

        public Builder operation(String val) {
            operation = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public NoteFuncInfo build() {
            return new NoteFuncInfo(this);
        }
    }

    public String getOperation() {
        return operation;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
