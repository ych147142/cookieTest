package com.neuedu.dao;


import com.neuedu.pojo.Product;
import com.neuedu.utilTest.JdbcUtil;
import com.neuedu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    /**
     * 显示产品列表
     * @return
     */
    @Override
    public List<Product> getLists() {
        return JdbcUtil.executeQuery("select * from product", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet resultSet) {
                Product p = new Product();
                try {
                    p.setProductId(resultSet.getInt("product_id"));
                    p.setProductName(resultSet.getString("product_name"));
                    p.setProductDes(resultSet.getString("product_des"));
                    p.setUrl(resultSet.getString("url"));
                    p.setPrice(resultSet.getDouble("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, null);
    }

    /**
     * 添加
     * @param product
     * @return
     */
    @Override
    public int add(Product product) {
        return JdbcUtil.executeUpdate("insert into product(product_name,price,product_des,url) values(?,?,?,?)",product.getProductName(),product.getPrice(),product.getProductDes(),product.getUrl());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int dele(int id) {
        return JdbcUtil.executeUpdate("delete from product where product_id=?",id);
    }

    /**
     * 登录
     * @param id
     * @return
     */
    @Override
    public Product getOne(int id) {
        return JdbcUtil.queryOne("select * from product where product_id =?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet resultSet) {
                Product p = new Product();
                try {
                    p.setProductName(resultSet.getString("product_name"));
                    p.setProductDes(resultSet.getString("product_des"));
                    p.setUrl(resultSet.getString("url"));
                    p.setPrice(resultSet.getDouble("price"));
                    p.setProductId(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return p;
            }
        }, id);
    }

    /**
     * 修改
     * @param product
     * @return
     */
    @Override
    public int update(Product product) {
        return JdbcUtil.executeUpdate("update product set product_name=?,product_des=?,url=?,price=? where product_id=?",product.getProductName(),product.getProductDes(),product.getUrl(),product.getPrice(),product.getProductId());
    }

    /**
     * 模糊查询
     * @param text
     * @return
     */
    @Override
    public List<Product> getResults(String text) {
        return JdbcUtil.executeQuery("select * from product where product_name like concat('%',?,'%')", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setUrl(rs.getString("url"));
                    p.setPrice(rs.getDouble("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, text);
    }

    @Override
    public int getCount() {
        return JdbcUtil.executeCount("select count(*) from product",null);
    }

    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<Product> getLists(int pageNo, int pageSize) {
        return JdbcUtil.executeQuery("select * from product limit ?,?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet resultSet) {
                Product p = new Product();
                try {
                    p.setProductId(resultSet.getInt("product_id"));
                    p.setProductName(resultSet.getString("product_name"));
                    p.setProductDes(resultSet.getString("product_des"));
                    p.setUrl(resultSet.getString("url"));
                    p.setPrice(resultSet.getDouble("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, (pageNo - 1) * pageSize, pageSize);
    }
}
