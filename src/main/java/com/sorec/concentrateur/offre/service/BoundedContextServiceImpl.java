package com.sorec.concentrateur.offre.service;

import static com.sorec.concentrateur.offre.exception.BoundedContextException.Error.USER_NOT_FOUND;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorec.concentrateur.offre.domain.BoundedContext;
import com.sorec.concentrateur.offre.domain.Partant;
import com.sorec.concentrateur.offre.exception.BoundedContextException;
import com.sorec.concentrateur.offre.exception.PartantException;
import com.sorec.concentrateur.offre.repository.BoundedContextRepository;
import com.sorec.concentrateur.offre.repository.PartantRepository;

/**
 * {@link BoundedContextServiceImpl} class implements methods from {@link BoundedContextService}
 * interfaces that contains methods to interact with the database.
 *

 */
@Service
@Transactional
public class BoundedContextServiceImpl implements BoundedContextService {

    @Autowired
    BoundedContextRepository userRepository;

    @Override
    public BoundedContext get(@NotNull Integer id) {
        Optional<BoundedContext> boundedcontext = userRepository.findById(id);
        if (!boundedcontext.isPresent()) {
            throw new BoundedContextException(USER_NOT_FOUND);
        }
        return boundedcontext.get();
    }
    
    
}
