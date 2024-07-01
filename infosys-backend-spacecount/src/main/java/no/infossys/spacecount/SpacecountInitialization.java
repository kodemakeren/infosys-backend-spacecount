package no.infossys.spacecount;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import no.infossys.spacecount.json.Root;


@Component
public class SpacecountDataFetcher {

	@Value("${spacecount.url}")
	String url;

	public Root getRoot() {
		ObjectMapper objectMapper = new ObjectMapper();
		Root root = null;
		try {
			URL spacecountUrl = URI.create(url).toURL();
			root = objectMapper.readValue(spacecountUrl, Root.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}
}