package com.example.videorental.dto;

import com.example.videorental.constant.ServerResponseStatus;
import lombok.Data;

@Data
public class ServerResponsePage extends ServerResponse {
    private int totalPage;
    private int page;
    private long totalRecord;

    public ServerResponsePage() {
    }

    public ServerResponsePage(boolean success, String message, Object data, int status, int totalPage, int page, long totalRecord) {
        super(success, message, data, status);
        this.totalPage = totalPage;
        this.page = page;
        this.totalRecord = totalRecord;
    }

    public static ServerResponsePage successResponse(String message, Object data, int totalPage, int page, long totalRecord){
        return new ServerResponsePage(true,
                message,
                data,
                ServerResponseStatus.OK,
                totalPage,
                page,
                totalRecord
        );
    }
}
