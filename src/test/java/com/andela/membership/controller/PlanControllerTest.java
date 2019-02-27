package com.andela.membership.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.andela.membership.model.Plan;
import com.andela.membership.service.PlanService;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanController.class)
public class PlanControllerTest {

	@MockBean
	PlanService planService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetPlan() throws Exception {
		when(planService.getPlan(1L)).thenReturn(new Plan("Plan 5", LocalDate.now(), LocalDate.now().plusYears(1)));
		mockMvc.perform(get("/plan/1")).andExpect(status().isOk()).andExpect(content().string(containsString("Plan 5")));
	}

}
