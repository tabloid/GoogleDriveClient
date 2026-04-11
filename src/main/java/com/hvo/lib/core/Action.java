package com.hvo.lib.core;

public interface Action<T extends Response> {
    T execute();
}
