package com.zywz.common.util.gemerator;

import java.util.List;

/**
 * @author Administrator
 */
public interface MybatisBaseDao<T, I> {
    /**
     * 完整插入
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 插入非空字段
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    /**
     * 根据主键id删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(I id);

    /**
     * 根据id列表 批量删除数据
     * @param idList
     * @return
     */
    int deleteBatchByPrimaryKeys(List<I> idList);

    /**
     * 根据实体做完整更新
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);

    /**
     * 根据实体更新非空字段
     * @param entity
     * @return
     */
    int updateSelectiveByPrimaryKey(T entity);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    T selectByPrimaryKey(I id);

    /**
     * 根据id列表查询数据
     * @param idList
     * @return
     */
    List<T> selectBatchByPrimaryKeys(List<I> idList);

    /**
     * 模糊匹配
     * @param entity
     * @return
     */
    List<T> selectPage(T entity);
}
