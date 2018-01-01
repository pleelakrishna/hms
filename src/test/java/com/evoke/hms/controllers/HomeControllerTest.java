package com.evoke.hms.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class HomeControllerTest {

	private MockMvc mockMvc;	
	@Mock
	ModelAndView modelAndView;

	//private HomeController homeController;

	@Before
	public void setUp(){
		//homeController = new HomeController();
		
		//Loading view resolvers
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
				.setViewResolvers(viewResolver)
				.build();
	}

	@Test
	public void TestWelcome() throws Exception{
		this.mockMvc.perform(get("/hms"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/jsp/index.jsp"));
	}

	@Test
	public void TestLogin() throws Exception{
		this.mockMvc.perform(get("/login"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));
	}

	@Test
	public void TestHomePage() throws Exception{
		this.mockMvc.perform(get("/homepage"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/jsp/homepage.jsp"));
	}
	

/*	//TODO: Can we do like this???
	@Test
	public void TestHomePage_direct() throws Exception{
		String page = homeController.homePage(modelAndView);
	    Assert.assertEquals(Pages.homepage.name(), page);
    
	}*/

}
