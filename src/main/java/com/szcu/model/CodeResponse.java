package com.szcu.model;

import lombok.Data;

@Data
public class CodeResponse {
	int row;
	int column;
	String errorMsg;
	String correctCode;
}
