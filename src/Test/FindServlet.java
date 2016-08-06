package Test;

/**
 * Created by Cass on 2016/6/15.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("page="+request.getParameter("page"));
        int currPage=1;
        if(request.getParameter("page")!=null){
            currPage=Integer.parseInt(request.getParameter("page"));
            System.out.println("page=aaaaa");
        }
        ProductDao dao = new ProductDao();
        List<Product> list = dao.find(currPage);
        request.setAttribute("list", list);
        int pages;  //总页数
        int count=dao.findCount(); //查询总记录数
        if(count%Product.PAGE_SIZE==0){
            pages=count/Product.PAGE_SIZE;
        }else{
            pages=count/Product.PAGE_SIZE+1;
        }
        StringBuffer sb = new StringBuffer();
        //通过循环构建分页条
        for(int i=1;i<=pages;i++){
            if(i==currPage){   //判断是否为当前页
                sb.append("『"+i+"』");  //构建分页条
            }
            else{
                sb.append("<a href='FindServert?page=" + i + "'>" +i+ "</a>"); //构建分页条
            }
            sb.append(" ");
        }
        request.setAttribute("bar", sb.toString());
        request.getRequestDispatcher("product_list.jsp").forward(request, response);
    }
}