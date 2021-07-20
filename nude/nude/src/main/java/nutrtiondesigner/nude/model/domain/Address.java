package nutrtiondesigner.nude.model.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;
    private String steet;
    private String zipcode;

}
