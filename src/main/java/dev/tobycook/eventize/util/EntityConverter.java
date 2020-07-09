package dev.tobycook.eventize.util;

import org.modelmapper.ModelMapper;


/**
 * The type Entity converter.
 */
public class EntityConverter {

    /* The model mapper. */
    private ModelMapper modelMapper;

    /**
     * Instantiates a new Entity converter.
     */
    public EntityConverter() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Convert to entity d.
     *
     * @param <D>    the type parameter
     * @param dto    the dto
     * @param entity the entity
     * @return the d
     */
    public <D> D convertToEntity(Object dto, Class<D> entity) {
        return modelMapper.map(dto, entity);
    }
}
