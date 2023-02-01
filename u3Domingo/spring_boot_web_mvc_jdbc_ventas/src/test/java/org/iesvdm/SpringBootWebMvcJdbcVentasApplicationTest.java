package org.iesvdm;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

@SpringBootTest
class SpringBootWebMvcJdbcVentasApplicationTest {

	WebClient webClient;

	@BeforeEach
	void setup(WebApplicationContext context) {
		webClient = MockMvcWebClientBuilder.webAppContextSetup(context).build();
	}

@Test
   void validationForm() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
       
       HtmlPage validationFormPage = webClient.getPage("http://localhost:8080/clientes/crear");
       
       HtmlForm validationForm = validationFormPage.getHtmlElementById("validationForm");
       
       HtmlTextInput nombreInput = validationFormPage.getHtmlElementById("nombre");
       nombreInput.setValueAttribute("Juan");
       
       HtmlTextInput salarioInput = validationFormPage.getHtmlElementById("salario");
       salarioInput.setValueAttribute("1000");
       
       HtmlTextInput emailInput = validationFormPage.getHtmlElementById("email");
       emailInput.setValueAttribute("juan@gmail.com");
       
       HtmlSubmitInput submit = validationForm.getOneHtmlElementByAttribute("input", "type", "submit");
       HtmlPage newValidationPage = submit.click();
       
       assertThat(newValidationPage.getUrl().toString()).endsWith("/validation");
       
       String nombreNew = newValidationPage.getHtmlElementById("nombre").getTextContent();
       assertThat(nombreNew).isEqualTo("Juan");
       
       String salarioNew = newValidationPage.getHtmlElementById("salario").getTextContent();
       assertThat(salarioNew).isEqualTo("1000");
       
       String emailNew = newValidationPage.getHtmlElementById("email").getTextContent();
       assertThat(emailNew).isEqualTo("juan@gmail.com");
       
   }

}