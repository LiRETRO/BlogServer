package net.meloli.demo.sys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {
    // blogId
    private String blogId;
    // 请求时间(访问时间)
    private Date requestTime;
    // 请求IP
    private String ipAddr;
}
