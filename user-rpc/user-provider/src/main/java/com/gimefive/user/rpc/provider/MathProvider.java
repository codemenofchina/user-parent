package com.gimefive.user.rpc.provider;

import com.gimefive.user.rpc.api.MathApi;

public class MathProvider implements MathApi {
    @Override
    public double square(double value) {
        return Math.sqrt(value);
    }
}
