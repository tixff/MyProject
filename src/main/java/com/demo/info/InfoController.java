package com.demo.info;

import com.alibaba.druid.support.json.JSONUtils;
import com.demo.blog.BlogService;
import com.demo.blog.BlogValidator;
import com.demo.common.model.Blog;
import com.demo.common.model.Info;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

import javax.servlet.http.HttpServletRequest;

public class InfoController extends Controller {
    @Inject
    InfoService service;

    public void index() {
        //setAttr("blogPage", service.paginate(getParaToInt(0, 1), 10));
        render("login.html");
    }

    /**
     * 测试ajax请求
     *
     * @return
     */
    public void jsonInfo() {

        String json = "{id:1,name:\"tom\",password:\"123456\"}";

        //String json = JsonKit.toJson(new Info("jerry", "123456"));
        renderJson(json);
    }

    public void add() {
    }

    public void login() {

        HttpServletRequest request = getRequest();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Info info = service.findByNameAndPassword(name, password);
        if (info != null) {
            render("success.html");
        } else {
            service.addInfo(name, password);
            setAttr("erro", "login erro");
            render("login.html");
        }


    }

    public void register() {
        render("regist.html");
    }

    public void regist() {
        HttpServletRequest request = getRequest();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Info info = service.findByName(name);
        if (info != null) {
            setAttr("erro", "此用户已被注册");
            render("regiet.html");
        } else {
            service.addInfo(name, password);
            setAttr("erro", "注册成功");
            render("login.html");
        }
    }
    /*public void hello(){

    }
    */

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */

   /* @Before(BlogValidator.class)
    public void save() {
        getBean(Info.class).save();
        redirect("/info");
    }

    public void edit() {
        setAttr("info", service.findById(getParaToInt()));
    }


    @Before(BlogValidator.class)
    public void update() {
        getBean(Blog.class).update();
        redirect("/info");
    }

    public void delete() {
        service.deleteById(getParaToInt());
        redirect("/info");
    }*/
}
