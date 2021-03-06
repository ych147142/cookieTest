package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> getLists();
    public List<Product> getLists(int pageNo,int pageSize);
    public int add(Product product);
    public int dele(int id);
    public Product getOne(int id);
    public int update(Product product);
    public List<Product> getResults(String text);
    public int getCount();
}
