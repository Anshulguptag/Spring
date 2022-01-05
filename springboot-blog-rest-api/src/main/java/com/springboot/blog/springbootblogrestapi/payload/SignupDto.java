package com.springboot.blog.springbootblogrestapi.payload;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {

    private String name;
    private String username;
    private String email;
    private String password;

}
