package be.intecbrussel.kaartje.modules;

import be.intecbrussel.kaartje.model.StatusValue;
import be.intecbrussel.kaartje.repositories.StatusValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusValueModule {
    private static final Logger log = LoggerFactory.getLogger(StatusValueModule.class);

    @Autowired
    StatusValueRepository repository;


    public List<StatusValue> findAll() {
        System.out.println("getting list of StatusValues");
        List<StatusValue> statusValues = repository.findAll();
        System.out.println("got list of status values : " + statusValues);
        return statusValues;
    }

}
