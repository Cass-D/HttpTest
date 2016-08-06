package Query;

/**
 * Created by Cass on 2016/6/14.
 */
//该对象封装了分页查询的配置信息，用于dao层
public class QueryInfo {
    private int startindex;//查询的每页在数据库的起始位置，该值可以根据其他参数计算出，不需要set属性
    private int pagesize = 5;//查询的每页记录数，赋一个初始值
    private int querypage = 1;//查询第几页，赋一个初始值
    //提供get，set方法，便于设置，获取属性值
    public int getStartindex() {
        this.startindex = (this.querypage-1) + 1;
        return startindex;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getQuerypage() {
        return querypage;
    }
    public void setQuerypage(int querypage) {
        this.querypage = querypage;
    }
}