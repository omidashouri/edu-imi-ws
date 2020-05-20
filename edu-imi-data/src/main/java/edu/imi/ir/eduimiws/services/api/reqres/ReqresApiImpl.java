package edu.imi.ir.eduimiws.services.api.reqres;

import edu.imi.ir.eduimiws.models.api.UserReqres;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ReqresApiImpl implements ReqresApi{

    private final RestTemplate restTemplate;

/*    @Value("${api.url}")
    private final String api_url;*/


    @Override
    public UserReqres getSingleUser(Long reqresId) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString("https://reqres.in/api/users/"+reqresId);
//                .queryParam("reqresId", reqresId);

        UserReqres userReqres = restTemplate.getForObject(uriBuilder.toUriString(), UserReqres.class);
        return userReqres;
    }
}
