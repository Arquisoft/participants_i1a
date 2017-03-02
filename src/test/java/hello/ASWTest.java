package hello;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import asw.participants.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest( "server.port=0" )
public class ASWTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;
    
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
	this.base = new URL("http://localhost:" + port + "/");
	template = new TestRestTemplate();
	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getLanding() throws Exception {
	ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
	assertThat(response.getBody(), containsString("Username:"));
	assertThat(response.getBody(), containsString("Password:"));
    }
    
    @Test
    public void testGetUserHTML() {
    	String body = "";
	    try {
			MvcResult result = this.mockMvc.perform(post("/login")
			      .param("username", "DNI")
			      .param("password","123")
			      .accept(MediaType.TEXT_HTML_VALUE))
			.andExpect(status().isOk())
			.andReturn();
		    body = result.getResponse().getContentAsString();

	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    //An HTML
	    Assert.isTrue(body.startsWith("<!DOCTYPE HTML>"));
    	//Not a JSON
  		Assert.isTrue(!body.startsWith("{"));
  		Assert.isTrue(!body.endsWith("}"));
  		//Not an XML
		Assert.isTrue(!body.startsWith("<user>"));

		Assert.hasText(body, "Jose");
		Assert.hasText(body, "Hidalgo");
		Assert.hasText(body, "Jose");
		Assert.hasText(body, "hidalgo@uniovi.es");
		Assert.hasText(body, "Calle Uria");
		Assert.hasText(body, "Spain");
    }
    
    
    @Test
    public void testGetUserJSON() {
    	String body = "";
	    try {
			MvcResult result = this.mockMvc.perform(post("/login")
			      .param("username", "DNI")
			      .param("password","123")
			      .accept(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(status().isOk())
					.andReturn();
			body = result.getResponse().getContentAsString();
		
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    //Not an HTML
	    Assert.isTrue(!body.startsWith("<!DOCTYPE HTML>"));
	    //A JSON
  		Assert.isTrue(body.startsWith("{"));
  		Assert.isTrue(body.endsWith("}"));
  		//Not an XML
		Assert.isTrue(!body.startsWith("<User>"));
	    
		Assert.hasText(body, "Jose");
		Assert.hasText(body, "Hidalgo");
		Assert.hasText(body, "Jose");
		Assert.hasText(body, "hidalgo@uniovi.es");
		Assert.hasText(body, "Calle Uria");
		Assert.hasText(body, "Spain");
    }
    
    @Test
    public void testGetUserXML() {
    	String body = "";
	    try {
			MvcResult result = this.mockMvc.perform(post("/login")
			      .param("username", "DNI")
			      .param("password","123")
			      .accept(MediaType.APPLICATION_XML))
					.andExpect(status().isOk())
					.andReturn();
			body = result.getResponse().getContentAsString();
		
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    //Not an HTML
	    Assert.isTrue(!body.startsWith("<!DOCTYPE HTML>"));
	    //Not a JSON
  		Assert.isTrue(!body.startsWith("{"));
  		Assert.isTrue(!body.endsWith("}"));
  		//An XML
		Assert.isTrue(body.startsWith("<User>"));
	    
		Assert.hasText(body, "Jose");
		Assert.hasText(body, "Hidalgo");
		Assert.hasText(body, "Jose");
		Assert.hasText(body, "hidalgo@uniovi.es");
		Assert.hasText(body, "Calle Uria");
		Assert.hasText(body, "Spain");
    }
    
    @Test
    public void testGetNonExistingUser() {
	    try {
		MvcResult result = this.mockMvc.perform(post("/login")
		      .param("username", "Unexistant")
		      .param("password","Unexistant")
		      .accept(MediaType.TEXT_HTML_VALUE)
		      ).andExpect(status().is4xxClientError())
		.andReturn();
		String body = result.getResponse().getContentAsString();
		Assert.doesNotContain(body, "Jose");
		Assert.doesNotContain(body, "Hidalgo");
		Assert.doesNotContain(body, "Jose");
		Assert.doesNotContain(body, "hidalgo@uniovi.es");
		Assert.doesNotContain(body, "Calle Uria");
		Assert.doesNotContain(body, "Spain");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
    }
}