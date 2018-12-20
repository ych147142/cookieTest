package com.neuedu.service;



import com.neuedu.pojo.Product;
import com.neuedu.pojo.ResultData;

import java.util.List;

public interface IProductService {
    public List<Product> getLists();
    public ResultData getLists(int pageNo,int pageSize);
    public int add(Product product);
    public int dele(int id);
    public Product getOne(int id);
    public int update(Product product);
    public List<Product> getResults(String text);
}
