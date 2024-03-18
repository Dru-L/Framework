package com.kh.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kh.mybatis.common.template.SqlSessionTemplate;

import lombok.extern.slf4j.Slf4j;

//@Slf4j으로 인해서 아래의 선언문은 생략이 가능하다.
@Slf4j
public class App {
//	private static final Logger log =
//				LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) {
        int count = 0;
        SqlSession session = SqlSessionTemplate.getSession();
        
        count = session.selectOne("memberMapper.selectCount");
        log.debug("memberMapper의 selectCount 쿼리 호출");
        
        session.close();
        
//        System.out.println("회원 수 : " + count);
        log.info("회원 수 : " + count);
    }
}









