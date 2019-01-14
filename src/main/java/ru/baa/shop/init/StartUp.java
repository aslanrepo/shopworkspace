package ru.baa.shop.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.baa.shop.model.Client;
import ru.baa.shop.model.Feature;
import ru.baa.shop.model.OmniChannel;
import ru.baa.shop.repository.ClientRepository;
import ru.baa.shop.repository.FeatureRepository;
import ru.baa.shop.repository.OmniChannelRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.UUID;

@Component
public class StartUp {

    private final ClientRepository clientRepository;
    private final FeatureRepository featureRepository;
    private final OmniChannelRepository omniChannelRepository;

    @Autowired
    public StartUp( ClientRepository clientRepository, FeatureRepository featureRepository, OmniChannelRepository omniChannelRepository) {
        this.clientRepository = clientRepository;
        this.featureRepository = featureRepository;
        this.omniChannelRepository = omniChannelRepository;
    }

    @PostConstruct
    public void init() {
        clientRepository.deleteAllInBatch();
        featureRepository.deleteAllInBatch();
        omniChannelRepository.deleteAllInBatch();
        OmniChannel omniChannel = new OmniChannel("CH-MOB");
        String clientId = UUID.randomUUID().toString();
        String clientId2 = UUID.randomUUID().toString();
        Client client = new Client(clientId);
        Client client2 = new Client(clientId2);
        clientRepository.saveAndFlush(client2);
        Feature feature = new Feature("OMNI_2144", false, Arrays.asList(client), Arrays.asList(omniChannel));
        Feature feature2 = new Feature("OMNI_5555", false);
        featureRepository.saveAndFlush(feature);
        featureRepository.saveAndFlush(feature2);

        Feature entityFeature = featureRepository.findById("OMNI_2144").get();
        Client oneClient = clientRepository.findById(clientId2).get();
        System.out.println(oneClient.getId());
        entityFeature.getClients().add(oneClient);

        featureRepository.saveAndFlush(entityFeature);


    }
}
