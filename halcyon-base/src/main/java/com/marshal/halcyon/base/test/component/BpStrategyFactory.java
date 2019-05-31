package com.marshal.halcyon.base.test.component;

/**
 * @auth: Marshal
 * @date: 2019/6/1
 * @desc:
 */
public class BpStrategyFactory implements StrategyFactory {
    @Override
    public GenerateStrategy getStrategy() {
        return new BpGenerateStrategy();
    }
}
