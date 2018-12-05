package net.meloli.demo.sys.util;

public class MvcDataDto {

    private MvcDataDto() {}

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    public static MvcDataDto getInstance() {
        synchronized (MvcDataDto.class) {
            return new MvcDataDto().setResultCode(MvcDataDto.FAIL);
        }
    }

    // 返回代码
    private String resultCode;
    // 返回消息
    private String resultMessage;
    // 翻页对象
    private Page page;
    // 返回结果
    private Object resultObj;
    // 返回参数
    private Object param;
    // 返回结果冗余
    private Object resultObjMore;

    public String getResultCode() {
        return resultCode;
    }

    public MvcDataDto setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public MvcDataDto setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
        return this;
    }

    public Page getPage() {
        return page;
    }

    public MvcDataDto setPage(Page page) {
        this.page = page;
        return this;
    }

    public Object getResultObj() {
        return resultObj;
    }

    public MvcDataDto setResultObj(Object resultObj) {
        this.resultObj = resultObj;
        return this;
    }

    public Object getParam() {
        return param;
    }

    public MvcDataDto setParam(Object param) {
        this.param = param;
        return this;
    }

    public Object getResultObjMore() {
        return resultObjMore;
    }

    public MvcDataDto setResultObjMore(Object resultObjMore) {
        this.resultObjMore = resultObjMore;
        return this;
    }
}
