package com.demo.blog;

import com.demo.common.model.BlogType;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.demo.common.model.Blog;

import java.util.ArrayList;
import java.util.Date;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * <p>
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {

    @Inject
    BlogService service;

    @Inject
    BlogTypeService typeService;

    public void index() {
        setAttr("blogPage", service.paginate(getParaToInt(0, 1), 10));
        render("blog.html");
    }

    public void add() {
        Blog blo = service.findById(1);
        ArrayList<BlogType> list = typeService.findAllType();
        setAttr("typeList", list);
    }

    public void hello() {

    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void save() {
        Blog bean = getBean(Blog.class);
        bean.setCreateTime(new Date());
        bean.save();
        redirect("/blog");
    }

    public void edit() {
        ArrayList<BlogType> list = typeService.findAllType();
        setAttr("typeList", list);
        setAttr("blog", service.findById(getParaToInt()));
    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void update() {
        Blog bean = getBean(Blog.class);
        bean.setUpdateTime(new Date());
        bean.update();
        redirect("/blog");
    }

    public void delete() {
        service.deleteById(getParaToInt());
        redirect("/blog");
    }
}


