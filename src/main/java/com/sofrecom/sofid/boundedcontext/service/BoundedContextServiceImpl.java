package com.sofrecom.sofid.boundedcontext.service;

import static com.sofrecom.sofid.boundedcontext.exception.BoundedContextException.Error.USER_NOT_FOUND;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofrecom.sofid.boundedcontext.domain.BoundedContext;
import com.sofrecom.sofid.boundedcontext.exception.BoundedContextException;
import com.sofrecom.sofid.boundedcontext.repository.BoundedContextRepository;

/**
 * {@link BoundedContextServiceImpl} class implements methods from {@link BoundedContextService}
 * interfaces that contains methods to interact with the database.
 *
 * @author sofid@sofrecom.com
 * @author Mehdi JEBBARI
 * @version 1.1
 * @since April 22, 2019
 * @author sofid@sofrecom.com

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
