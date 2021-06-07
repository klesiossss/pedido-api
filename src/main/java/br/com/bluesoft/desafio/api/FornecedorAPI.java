package br.com.bluesoft.desafio.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.bluesoft.desafio.model.dto.FornecedorResponse;

public class FornecedorAPI {
	
	RestTemplate restTemplate = new RestTemplate();


	public List<FornecedorResponse> getApi(String gtin) {
		
		String urlBase = "https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/produto/"+gtin;
		
		HttpHeaders header = new HttpHeaders();
		header.set("ContentType","application/json");
		HttpEntity<String> entity = new HttpEntity<>(header);

		ResponseEntity<FornecedorResponse[]> repos = restTemplate.exchange(urlBase, HttpMethod.GET, entity, FornecedorResponse[].class);
		List<FornecedorResponse> res = Arrays.asList(repos.getBody());
	
		return res;
	}

}
