package com.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class UserDetails {

	private long userId;
	private String name;
	private String email;
	private String location;
	private boolean isError;
	private String errMsg;

}
