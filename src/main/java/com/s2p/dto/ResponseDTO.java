package com.s2p.dto;
import java.util.List;

public class ResponseDTO {
    private int status;
    private List<Object> data;

    public ResponseDTO() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
