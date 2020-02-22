package demo.http;

/**
 * 请求枚举
 */
public enum ResponseCode {

    SUCCESS(200,"操作成功"),
    ERROR(100,"操作失败");

    private int code;
    private String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }

}


