package com.demo.info;

import com.demo.common.model.Blog;
import com.demo.common.model.Info;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class InfoService {

    /**
     * 所有的 dao 对象也放在 Service 中，并且声明为 private，避免 sql 满天飞
     * sql 只放在业务层，或者放在外部 sql 模板，用模板引擎管理：
     * http://www.jfinal.com/doc/5-13
     */
    private static  final Info dao = new Info().dao();

    public Page<Info> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from info order by id asc");
    }

    public Info findById(int id) {
        return dao.findById(id);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void addInfo(String name,String password){
        String sql = "insert into info(name,password) values("+"'"+name+"','"+password+"')";
        System.out.println(sql);
        int update = Db.update(sql);
    }
    public Info findByName(String name) {
        String sql ="select `id`,`name`,`password` from info where name='"+name+"'";
        System.out.println(sql);
        List<Info> info = (List<Info>) dao.find(sql);
        if(info==null||info.size()<=0){
            return null;
        }
        return info.get(0);
    }


    public Info findByNameAndPassword(String name,String password){
        String sql ="select `id`,`name`,`password` from info where name='"+name+"' and password='"+password+"'";
        System.out.println(sql);
        List<Info> info = (List<Info>) dao.find(sql);
        if(info==null||info.size()<=0){
            return null;
        }
        return info.get(0);
    }
}
