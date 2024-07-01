package no.infossys.spacecount;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpacecountDataFetcher {

	@Value("${spacecount.url}")
	String url;
	
	public String getSpacecount() throws IOException {
		URI uri;
		try {
			uri = new URI(url);
			String json = IOUtils.toString(uri, Charset.forName("UTF-8"));
			return json;
		} catch (URISyntaxException e) {
			throw new RuntimeException("URI syntax is wrong: " + url, e);
		}
		
	}
	
}