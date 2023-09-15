package com.nishant.UserManagement.Entity;

public interface Mergeable <T> {
    T merge(T replace);
}
