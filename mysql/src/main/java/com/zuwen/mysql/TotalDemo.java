package com.zuwen.mysql;

/**
 * Mybatis
 *  mybatis中的一级缓存和二级缓存
 *      1.一级缓存是SqlSession级别的缓存,操作数据库的时候需要创建SqlSession对象，该对象里面有一个map用于存储缓存数据，不同的SqlSession之间缓存数据是互不影响的
 *      2.二级缓存是Mapper级别的缓存，多个SqlSession之间共享二级缓存中的数据
 */
public class TotalDemo {
}
