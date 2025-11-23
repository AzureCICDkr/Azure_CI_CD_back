package com.seohan1010.ch8_4.mock;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.seohan1010.ch8_4.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value=BoardController.class)
@WebMvcTest(MainController.class) // 특정 컨트롤러만 테스트
@AutoConfigureMockMvc
public class MockTest {


@Autowired
private MockMvc mockMvc;

@Autowired
ObjectMapper objectMapper;

@Test
public void chatBotTest()throws Exception{



	ResultActions resultActions = mockMvc.
	perform(MockMvcRequestBuilders.get("/"));

	resultActions
		.andExpect(status().isOk())
		.andDo(result -> System.out.println("result = " + result) );

	}
}
