package bts.sio.webapp.repository;


import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Entreprise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EntrepriseProxy {
    @Autowired
    private CustomProperties props;

    /**
     * Get all athletes
     * @return An iterable of all athlete
     */
    public Iterable<Entreprise> getEntreprises() {

        String baseApiUrl = props.getApiUrl();
        String getEntreprisesUrl = baseApiUrl + "/entreprises";
        System.out.println("url=" + getEntreprisesUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Entreprise>> response = restTemplate.exchange(
                getEntreprisesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Entreprise>>() {}
        );

        log.debug("Get Entreprises call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Entreprise createEntreprise(Entreprise e) {

        String baseApiUrl = props.getApiUrl();
        String createEntrepriseUrl = baseApiUrl + "/entreprise";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Entreprise> request = new HttpEntity<Entreprise>(e);
        ResponseEntity<Entreprise> response = restTemplate.exchange(
                createEntrepriseUrl,
                HttpMethod.POST,
                request,
                Entreprise.class);

        log.debug("Create Entreprise call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Entreprise updateEntreprise(Entreprise e) {
        String baseApiUrl = props.getApiUrl();
        String updateEntrepriseUrl = baseApiUrl + "/entreprise/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Entreprise> request = new HttpEntity<Entreprise>(e);


        ResponseEntity<Entreprise> response = restTemplate.exchange(
                updateEntrepriseUrl,
                HttpMethod.PUT,
                request,
                Entreprise.class);

        log.debug("Update Entreprise call " + response.getStatusCode().toString());

        return response.getBody();
    }
}
