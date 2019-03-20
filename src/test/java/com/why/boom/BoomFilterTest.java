package com.why.boom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * 在亿级数据中判断某个元素不存在
 */
public class BoomFilterTest {


    /**
     * 方案1：使用HashMap,设计固定内存大小，进行验证，同时打开GC日志
     * -Xms64m -Xmx64m -XX:+PrintHeapAtGC -XX:+HeapDumpOnOutOfMemoryError
     */
    @Test
    public void hashMapTest() {
        long star = System.currentTimeMillis();
        Set<Integer> hashset = new HashSet<>(10000000) ;
        for (int i = 0; i < 10000000; i++) {
            hashset.add(i) ;
        }
        Assert.assertTrue(hashset.contains(1));
        Assert.assertTrue(hashset.contains(2));
        Assert.assertTrue(hashset.contains(3));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }


    /**
     * 方案2：使用布隆过滤器
     * -Xms64m -Xmx64m -XX:+PrintHeapAtGC -XX:+HeapDumpOnOutOfMemoryError
     */
    @Test
    public void guavaTest() {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);
        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }
        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }



}