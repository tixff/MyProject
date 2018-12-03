package com.demo.blog;

import com.demo.common.model.BlogType;

import java.util.ArrayList;

public class BlogTypeService {
    private static BlogType dao = new BlogType().dao();

    public ArrayList<BlogType> findAllType() {
        String sql = "select *from blog_type";
        ArrayList<BlogType> blogTypes = (ArrayList<BlogType>) dao.find(sql);
        return blogTypes;
    }
}
