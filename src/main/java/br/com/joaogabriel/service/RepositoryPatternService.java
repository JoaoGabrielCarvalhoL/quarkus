package br.com.joaogabriel.service;

import br.com.joaogabriel.mapper.RepositoryPatternEntityMapper;
import br.com.joaogabriel.pattern.repository.RepositoryPattern;
import br.com.joaogabriel.pattern.repository.RepositoryPatternEntity;
import br.com.joaogabriel.payload.request.RepositoryPatternRequest;
import br.com.joaogabriel.payload.response.RepositoryPatternResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ApplicationScoped:
 *  A single bean instance is used for the
 *  application and shared among all injection
 *  points. The instance is created lazily once a
 *  method is invoked on its proxy.
 *
 * Singleton:
 *  Just like @ApplicationScoped except that
 *  no proxy is used. The instance is created when
 *  an injection point resolves to an injected @
 *  Singleton bean.
 *
 * RequestScoped:
 *  The bean instance is associated with the
 *  current request, usually an HTTP request.
 *
 * Dependent:
 *  A pseudo-scope. The instances are not shared,
 *  and every injection point spawns a new instance
 *  of the dependent bean. The lifecycle of a
 *  dependent bean is bound to the bean injecting
 *  it. The bean will be created and destroyed along
 *  with the bean injecting it.
 *
 * SessionScoped:
 *  This scope is backed by a javax.servlet.
 *  http.HttpSession object. This annotation
 *  is available only if the quarkus-undertow
 *  extension is used.
 * */

@ApplicationScoped
public class RepositoryPatternService {

    /**
     * Dependency Injection:
     *
     * @Inject on the field or Constructor of class.
     *
     * */

    /**
     * Both Quarkus and Spring support creating lifecycle callbacks on beans, supporting the
     * @PostConstruct and @PreDestroy annotations found in the javax.annotation
     * package. Methods annotated with @PostConstruct are invoked before the bean
     * instance is placed into service. It is safe to perform bean initialization within the method.
     * Methods annotated with @PreDestroy are invoked before the destruction of the bean
     * instance. It is safe to perform cleanup tasks within the method.
     * */


    private final RepositoryPattern repository;
    private final RepositoryPatternEntityMapper repositoryPatternEntityMapper;
    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    @Inject //Optional
    public RepositoryPatternService(RepositoryPattern repository,
                                    RepositoryPatternEntityMapper repositoryPatternEntityMapper) {
        this.repository = repository;
        this.repositoryPatternEntityMapper = repositoryPatternEntityMapper;
    }

    @Transactional
    public RepositoryPatternResponse save(RepositoryPatternRequest repositoryPatternRequest) {
        logger.log(Level.INFO, "Saving {0} into database.", repositoryPatternRequest);
        RepositoryPatternEntity entity = repositoryPatternEntityMapper
                .toRepositoryPatternEntity(repositoryPatternRequest);
        repository.persist(entity);
        return repositoryPatternEntityMapper.toRepositoryPatternResponse(entity);
    }



}
