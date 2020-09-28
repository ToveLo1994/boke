package com.wwh.boke.entity.vo;

/**
* @Description:    自定义一个相应返回实体类
* @Author:         wangwenhu
* @CreateDate:     2020/9/27 0027 15:11
* @UpdateUser:     修改人 修改时更新
* @UpdateDate:     2020/9/27 0027 15:11
* @UpdateRemark:   修改内容 修改时更新
* @Version:        1.0
*/
public class ResponseEntity {

    //http状态码
    private int status;

    //返回附带消息
    private String msg;

    //返回体内容
    private Object data;

    public ResponseEntity( int status, String msg, Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseEntity(){

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
