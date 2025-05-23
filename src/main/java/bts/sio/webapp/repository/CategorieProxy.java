package bts.sio.webapp.repository;

import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Categorie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CategorieProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all
     * @return An iterable of all
     */
    public Iterable<Categorie> getCategories() {

        String baseApiUrl = props.getApiUrl();
        String getCategoriesUrl = baseApiUrl + "/categories";
        System.out.println("url=" + getCategoriesUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Categorie>> response = restTemplate.exchange(
                getCategoriesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Categorie>>() {}
        );

        log.debug("Get categoriescall " + response.getStatusCode().toString());

        return response.getBody();
    }
}
