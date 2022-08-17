package com.template.springnativerest.exception.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.github.shihyuho.jackson.databind.DynamicFilterMixIn;
import com.github.shihyuho.jackson.databind.DynamicFilterProvider;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class JacksonConfiguratorUtil {

    /**
     * Create a Jackson2ObjectMapperBuilder with custom configuration
     *
     * @param timeZone timezone string, e.g. UTC
     * @param fullLazy if 0, the lazy field are not loaded (null is returned)
     *                 if 1, only the reference ids are returned
     *                 if 2, the serialization force the loading of lazy field
     */
    public static Jackson2ObjectMapperBuilder createJacksonMapperBuilder(
            String timeZone, int fullLazy) {
        //Hibernate5Module hibernateModule = new Hibernate5Module();
        /*if (fullLazy == 2)
            hibernateModule.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
        else if (fullLazy == 1) {
            hibernateModule.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
            hibernateModule.configure(Hibernate5Module.Feature
                    .SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true);
        }*/
        return new Jackson2ObjectMapperBuilder()
                .timeZone(timeZone)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    /**
     * Create MappingJackson2HttpMessageConverter with a ObjectMapper properly configured
     *
     * @param configureObjectMapper
     * @return
     */
    public static MappingJackson2HttpMessageConverter createObjectMapper(
            Jackson2ObjectMapperBuilder configureObjectMapper) {
        ObjectMapper mapper = configureObjectMapper.build();
        mapper.addMixIn(Object.class, DynamicFilterMixIn.class);
        mapper.setFilterProvider(new DynamicFilterProvider());
        return new MappingJackson2HttpMessageConverter(mapper);
    }
}