package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.ContactController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactResponseContactFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.response.crm.ContactResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ContactResponseAssembler extends RepresentationModelAssemblerSupport<ContactFastDto, ContactResponse> {

    private final ContactResponseContactFastDtoMapper contactResponseContactFastDtoMapper;

    public ContactResponseAssembler(ContactResponseContactFastDtoMapper contactResponseContactFastDtoMapper) {
        super(ContactController.class,ContactResponse.class);
        this.contactResponseContactFastDtoMapper = contactResponseContactFastDtoMapper;
    }

    @Override
    public ContactResponse toModel(ContactFastDto contactFastDto) {

        ContactResponse contactResponse = contactResponseContactFastDtoMapper
                .toContactResponse(contactFastDto, new CycleAvoidingMappingContext());

        if(contactFastDto.getContactPublicId()!= null) {
            contactResponse
                    .add(linkTo(
                            methodOn(
                                    ContactController.class)
                                    .getContactByContactPublicId(contactFastDto.getContactPublicId()))
                            .withSelfRel());
        }

/*        contactResponse.
                add(linkTo(
                        methodOn(
                                ContactController.class)
                                .getPeriods(Pageable.unpaged()))
                        .withRel("periods"));*/

        return contactResponse;
    }

    @Override
    public CollectionModel<ContactResponse> toCollectionModel(Iterable<? extends ContactFastDto> entities)
    {
        CollectionModel<ContactResponse> actorModels = super.toCollectionModel(entities);

        Pageable defaultPageable = PageRequest.of(0,10, Sort.Direction.fromString("DESC"),"createDate");
        actorModels.add(linkTo(methodOn(ContactController.class).getAllContacts(defaultPageable)).withSelfRel());

        return actorModels;
    }

}
