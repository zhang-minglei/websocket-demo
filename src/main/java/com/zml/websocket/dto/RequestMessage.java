package com.zml.websocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangminglei
 */
@Data
@AllArgsConstructor
public class RequestMessage {

    private String content;

    public RequestMessage() {
    }

    @Override
    public String toString() {
        return content;
    }

}
