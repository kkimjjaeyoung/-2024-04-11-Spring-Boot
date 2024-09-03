package com.sist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//클래스 등록 파일
@Configuration

@ComponentScan(basePackages = { "com.sist.*" })
public class MusicConfig {

}
