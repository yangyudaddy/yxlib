package yyl.utils.gson;


import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

import yyl.utils.gson.reflect.TypeBuilder;

/**
 * ——感觉自己萌萌哒——
 * +   /\_/\     +
 * + =( °w° )=   +
 * +   )   (  // +
 * + (__ __)//   +
 * +++++++++++++++
 * <p>
 * author: yangxiaoling
 * Create_Date:   2018/2/9 下午3:14
 * Package_NAME  yyl.base
 * Describe:
 */

public class GsonUtils {

    public static <T> Result<T> fromJsonObject(String reader, Class<T> clazz) {
        Type type = TypeBuilder
                .newInstance(Result.class)
                .addTypeParam(clazz)
                .build();
        return new Gson().fromJson(reader, type);
    }

    public static <T> Result<T> fromJsonArray(String reader,Class<T> clazz){
        Type type = TypeBuilder
                .newInstance(Result.class)
                .beginSubType(List.class)
                .addTypeParam(clazz)
                .endSubType()
                .build();
        return new Gson().fromJson(reader,type);
    }

    public static <T> String toJsonString(Data<T> data){
        return new Gson().toJson(data);
    }

}
