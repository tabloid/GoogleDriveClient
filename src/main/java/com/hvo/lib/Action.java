package com.hvo.lib;

public interface Action<T extends Response> {
    T execute();
}
