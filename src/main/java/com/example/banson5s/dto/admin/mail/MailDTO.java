package com.example.banson5s.dto.admin.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailDTO {
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> props;

}