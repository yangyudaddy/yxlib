package yyl.utils.gson;


/**
 * ——感觉自己萌萌哒——
 * +   /\_/\     +
 * + =( °w° )=   +
 * +   )   (  // +
 * + (__ __)//   +
 * +++++++++++++++
 * <p>
 * author: yangxiaoling
 * Create_Date:   2018/2/9 下午4:08
 * Package_NAME  yyl.utils.gson
 * Describe:
 */

public class Data<T> {

    private T data;

    public Data(T data){
        this.data = data;
    }

    public static  <T> Data<T> sendData(T data){
       return new Data(data) ;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
