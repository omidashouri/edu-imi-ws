package edu.imi.ir.eduimiws.assemblers.crm;

import edu.imi.ir.eduimiws.controllers.v1.ContactController;
import edu.imi.ir.eduimiws.mapper.crm.ContactResponseForPaymentCodeContactFactDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.response.crm.ContactResponseForPaymentCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ContactResponseForPaymentCodeAssembler extends RepresentationModelAssemblerSupport<ContactFastDto, ContactResponseForPaymentCode> {

    private final ContactResponseForPaymentCodeContactFactDtoMapper contactResponseForPaymentCodeContactFactDtoMapper;

    public ContactResponseForPaymentCodeAssembler(ContactResponseForPaymentCodeContactFactDtoMapper contactResponseForPaymentCodeContactFactDtoMapper) {
        super(ContactController.class, ContactResponseForPaymentCode.class);
        this.contactResponseForPaymentCodeContactFactDtoMapper = contactResponseForPaymentCodeContactFactDtoMapper;
    }

    @Override
    public ContactResponseForPaymentCode toModel(ContactFastDto contactFastDto) {

        ContactResponseForPaymentCode contactResponseForPaymentCode = contactResponseForPaymentCodeContactFactDtoMapper
                .contactFastDtoToContactResponseForPaymentCode(contactFastDto);

        if (contactFastDto.getContactPublicId() != null) {
            contactResponseForPaymentCode
                    .add(linkTo(
                            methodOn(
                                    ContactController.class)
                                    .getContactByContactPublicId(contactFastDto.getContactPublicId()))
                            .withSelfRel());
        }

        if(contactFastDto.getNationCode() != null){
            contactResponseForPaymentCode
                    .add(linkTo(
                            methodOn(ContactController.class)
                            .getContactByNationalCode(contactFastDto.getNationCode()))
                    .withRel("nationalCode"));
        }

        return contactResponseForPaymentCode;
    }

    @Override
    public CollectionModel<ContactResponseForPaymentCode> toCollectionModel(Iterable<? extends ContactFastDto> contactFastDtos) {
        CollectionModel<ContactResponseForPaymentCode> contactResponseCollectionModel = super.toCollectionModel(contactFastDtos);

        Pageable defaultPageable = PageRequest
                .of(0, 10, Sort.Direction.fromString("DESC"), "lastName");

        contactResponseCollectionModel
                .add(linkTo(methodOn(ContactController.class).getContacts(defaultPageable)).withRel("contacts"));

        return contactResponseCollectionModel;
    }

}
