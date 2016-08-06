package Query;
import  java.util.List;
/**
 * Created by Cass on 2016/6/14.
 */
//该类封装了分页查询的所有信息，用于与用户交互，用于jsp页面，web层
public class QueryBean {
    private List list;//封装查询的所有记录信息
    private int totalrecord;//告诉用户总共有多少记录，可以从QueryResult对象获取
    private int pagesize;//告诉用户每页有多少记录，从QueryInfo对象获取
    private int totalpage;//告诉用户一共有多少页，可以通过totalrecord和pagesize计算
    private int currentpage;//告诉用户当前查看的是第几页，从QueryInfo对象获取
    private int previouspage;//上一页是第几页，通过当前页计算出
    private int nextpage;//下一页是第几页，通过当前页计算出
    private int[] pagebar;//记录页码条，通过currentpage和pagesize计算出的一个数组
    //  提供所有属性的get，set方法
    public int getTotalrecord() {
        return totalrecord;
    }
    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getTotalpage() {
//      计算总页数,21条，每页5条，有5页。20条，每页5条，有4页。
        if(this.totalrecord%this.pagesize == 0){
            this.totalpage = this.totalrecord / this.pagesize;
        }else{
            this.totalpage = this.totalrecord / this.pagesize + 1;
        }
        return totalpage;
    }
    public int getCurrentpage() {
        return currentpage;
    }
    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }
    public int getPreviouspage() {
        this.previouspage = this.currentpage - 1;
//      如果当前页小于等于0，就指向第一页
        if(this.previouspage<=0){
            this.previouspage = 1;
        }
        return previouspage;
    }
    public int getNextpage() {
        this.previouspage = this.currentpage - 1;
//      如果当前页小于等于0，就指向最后一页
        if(this.nextpage<=0){
            this.nextpage = 1;
        }
        return nextpage;
    }
    public int[] getPagebar() {
        int startindex;
        int endindex;
//      如果总页数小于10
        if(this.pagesize <= 10){
            startindex = 1;
            endindex = this.pagesize;
        }else{
            startindex = this.currentpage - 4;
            endindex = this.currentpage + 5;
//          如果startindex小于1，就从0开始，如果endindex大于总页数，就用总页数作为结束
            if(startindex < 1){
                startindex = 1;
                endindex = 10;
            }
            if(endindex > this.pagesize){
                startindex = this.pagesize - 9;
                endindex = this.pagesize;
            }
        }
//      更具两个索引值定义数组pagebar
        this.pagebar = new int[endindex-startindex+1];
//      为数组赋值
        for (int i = 0; i < pagebar.length; i++) {
            this.pagebar[i] = startindex++;
        }
        return pagebar;
    }
}