package com.pratsan.kirana.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResponseDto<Generic> {
    Generic object;
private int status_code;
private String status_msg;
StringBuffer s=new StringBuffer();

}
