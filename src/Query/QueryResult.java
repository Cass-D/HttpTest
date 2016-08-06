package Query;
import  java.util.List;
/**
 * Created by Cass on 2016/6/14.
 */
//该类封装了分页查询的结果信息，作为中间值，用于给QueryBean提供信息
public class QueryResult {
    private List list;//封装了查询后某页的所有记录
    private int totalrecord;//总记录数，用于给用户提供交互信息
    //  提供属性的get，set方法，
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
    public int getTotalrecord() {
        return totalrecord;
    }
    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }
}