package action;

import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.json.annotations.JSON;

@SuppressWarnings("serial")
public class TextResult extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
    private ByteArrayInputStream inputStream;

    @JSON(serialize = false)
    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }

    @JSON(serialize = false)
    public String text() throws Exception {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        String txt = "aaa测试中文";
        String temp = URLEncoder.encode(txt, "UTF-8");
        inputStream = new ByteArrayInputStream(temp.getBytes());
        return "text";
    }

    @JSON(serialize = false)
    public String html1() throws Exception {
        System.out.println("html");
        return "html1";
    }

    @JSON(serialize = false)
    public String jsp1() throws Exception {
        System.out.println("jsp");
        return "jsp1";
    }

    @JSON(serialize = false)
    public String jsp2() throws Exception {
        System.out.println("jsppart");
        return "jsp2";
    }

    @JSON(serialize = false)
    public String json() throws Exception {
        System.out.println("json");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "json";
    }

    @JSON(serialize = false)
    public List getData() throws Exception {
        List list = new ArrayList();
        Obj o = new Obj();
        o.setName("我们");
        o.setPass("aaa");
        list.add(o);
        Obj o1 = new Obj();
        o1.setName("综");
        o1.setPass("df");
        list.add(o1);
        return list;
    }

    public User getModel() {
        user.setGender(Gender.BOY);
        user.setUsername("mmmmm");
        user.setPassword("ppppp");
        return user;
    }
}
