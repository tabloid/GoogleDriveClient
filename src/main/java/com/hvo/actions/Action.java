package com.hvo.actions;

import com.hvo.responses.Response;

public interface Action<T extends Response> {
    T execute();
}
