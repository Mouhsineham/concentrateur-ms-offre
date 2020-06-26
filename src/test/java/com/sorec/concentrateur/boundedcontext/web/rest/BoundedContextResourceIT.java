package com.sorec.concentrateur.boundedcontext.web.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorec.concentrateur.OffreApp;
import com.sorec.concentrateur.boundedcontext.InitTestDB;
import com.sorec.concentrateur.framework.context.UserPrincipal;
import com.sorec.concentrateur.framework.dto.SelectItemDto;
import com.sorec.concentrateur.framework.exception.RestErrorHandler;
import com.sorec.concentrateur.framework.security.configuration.api.AuthenticationToken;
import com.sorec.concentrateur.offre.domain.BoundedContext;
import com.sorec.concentrateur.offre.messaging.service.MessagingService;
import com.sorec.concentrateur.offre.process.OffreProcess;
import com.sorec.concentrateur.offre.remote.service.ReferenceDataClient;
import com.sorec.concentrateur.offre.repository.BoundedContextRepository;
import com.sorec.concentrateur.offre.service.BoundedContextService;
import com.sorec.concentrateur.offre.web.rest.BoundedContextResource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OffreApp.class)
@AutoConfigureMockMvc
@InitTestDB
public class BoundedContextResourceIT {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    OffreProcess userProcess;

    @Autowired
    BoundedContextService userService;

    @Autowired
    BoundedContextRepository userRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private RestErrorHandler restErrorHandler;

    @Autowired
    private Validator validator;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @MockBean
    ReferenceDataClient referenceDataClient;

    @MockBean
    MessagingService messagingService;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void init() {
        Mockito.when(referenceDataClient.select(3, null, Arrays.asList(2), null)).thenReturn(Arrays.asList(SelectItemDto.from(2, "Passport")));
        Mockito.when(referenceDataClient.select(3, null, Arrays.asList(1), null)).thenReturn(Arrays.asList(SelectItemDto.from(1, "National ID")));
        Mockito.when(referenceDataClient.select(5, null, Arrays.asList(3, 5), null)).thenReturn(Arrays.asList(SelectItemDto.from(3, "Trusted"), SelectItemDto.from(5, "AHA")));
        Mockito.when(referenceDataClient.select(5, null, Arrays.asList(3, 4), null)).thenReturn(Arrays.asList(SelectItemDto.from(3, "Trusted"), SelectItemDto.from(4, "Point of sales")));
        Mockito.when(referenceDataClient.select(5, null, Arrays.asList(4), null)).thenReturn(Arrays.asList(SelectItemDto.from(4, "Point of sales")));
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BoundedContextResource userResource = new BoundedContextResource(userProcess);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userResource)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setControllerAdvice(restErrorHandler)
                .setConversionService(createFormattingConversionService())
                .setMessageConverters(jacksonMessageConverter)
                .setValidator(validator).build();

        BoundedContext boundedcontext = userService.get(1);
        UserPrincipal userPrincipal = new UserPrincipal(boundedcontext.getId(),boundedcontext.getUsername()
        ,new HashSet<>());
        AuthenticationToken authenticationToken =
                new AuthenticationToken("jwt",null);
        authenticationToken.setAuthenticated(true);
        authenticationToken.setUserPrincipal(userPrincipal);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

 
    /**
     * Create a {@link FormattingConversionService} which use ISO date format, instead of the localized one.
     *
     * @return the {@link FormattingConversionService}.
     */
    public static FormattingConversionService createFormattingConversionService() {
        DefaultFormattingConversionService dfcs = new DefaultFormattingConversionService();
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);
        registrar.registerFormatters(dfcs);
        return dfcs;
    }
    
    
    @Test
    public void testGet() throws Exception{

        Map expectedResult=  new HashMap() {{
            put("id", 1);
            put("username","usertest");
            put("password","passTest");
        }};

        mockMvc.perform(get("/api/v1/boundedcontext/1")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(expectedResult.get("id"))))
                .andExpect(jsonPath("$.username",is(expectedResult.get("username"))))
                .andExpect(jsonPath("$.password",is(expectedResult.get("password"))));
    	//assertTrue(true);
        
    }
    
   
}


