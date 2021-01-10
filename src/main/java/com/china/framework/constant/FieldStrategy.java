package com.china.framework.constant;

public enum FieldStrategy {
    IGNORED,
    NOT_NULL,
    NOT_EMPTY,
    DEFAULT,
    NEVER;

    private FieldStrategy() {
    }
}
