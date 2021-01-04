package com.shangma.cn.service.base.impl;

import com.github.pagehelper.PageInfo;
import com.shangma.cn.mapper.base.BaseMapper;
import com.shangma.cn.service.base.BaseService;
import com.shangma.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 开发者：辉哥
 * 特点： 辉哥很帅
 * 开发时间：2021/1/4 17:29
 * 文件说明：
 */
public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    @Autowired
    private BaseMapper<T, ID> baseMapper;


    public BaseMapper<T, ID> getBaseMapper() {
        return baseMapper;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public PageVo<T> findAll() {
        return setPage(baseMapper.selectByExample(null));
    }

    /**
     * 查询所有带条件
     *
     * @return
     */
    @Override
    public PageVo<T> findAll(Object example) {
        return setPage(baseMapper.selectByExample(example));
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    public T findById(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    /**
     * 添加内容
     *
     * @param entity
     * @return
     */
    @Override
    public int addEntity(T entity) {
        return baseMapper.insert(entity);
    }


    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @Override
    public int updateEntity(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Transactional
    @Override
    public int batchDeleteByIds(List<ID> ids) {
        ids.forEach(id -> baseMapper.deleteByPrimaryKey(id));
        return 1;
    }


    @Override
    public PageVo<T> setPage(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        PageVo<T> pageVo = new PageVo<>();
        pageVo.setList(list);
        pageVo.setTotal(total);
        return pageVo;
    }
}
