package com.upgrad.myntra.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.myntra.api.model.BrandDetailsResponseAddressState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BrandDetailsResponseAddress
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T18:32:51.090+05:30")

public class BrandDetailsResponseAddress   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("flat_building_name")
  private String flatBuildingName = null;

  @JsonProperty("locality")
  private String locality = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("pincode")
  private String pincode = null;

  @JsonProperty("state")
  private BrandDetailsResponseAddressState state = null;

  public BrandDetailsResponseAddress id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the address in a standard UUID format
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the address in a standard UUID format")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public BrandDetailsResponseAddress flatBuildingName(String flatBuildingName) {
    this.flatBuildingName = flatBuildingName;
    return this;
  }

  /**
   * Flat and building address
   * @return flatBuildingName
  **/
  @ApiModelProperty(value = "Flat and building address")


  public String getFlatBuildingName() {
    return flatBuildingName;
  }

  public void setFlatBuildingName(String flatBuildingName) {
    this.flatBuildingName = flatBuildingName;
  }

  public BrandDetailsResponseAddress locality(String locality) {
    this.locality = locality;
    return this;
  }

  /**
   * Locality of the address
   * @return locality
  **/
  @ApiModelProperty(value = "Locality of the address")


  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public BrandDetailsResponseAddress city(String city) {
    this.city = city;
    return this;
  }

  /**
   * City of the address
   * @return city
  **/
  @ApiModelProperty(value = "City of the address")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public BrandDetailsResponseAddress pincode(String pincode) {
    this.pincode = pincode;
    return this;
  }

  /**
   * pincode of the address
   * @return pincode
  **/
  @ApiModelProperty(value = "pincode of the address")


  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public BrandDetailsResponseAddress state(BrandDetailsResponseAddressState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BrandDetailsResponseAddressState getState() {
    return state;
  }

  public void setState(BrandDetailsResponseAddressState state) {
    this.state = state;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrandDetailsResponseAddress brandDetailsResponseAddress = (BrandDetailsResponseAddress) o;
    return Objects.equals(this.id, brandDetailsResponseAddress.id) &&
        Objects.equals(this.flatBuildingName, brandDetailsResponseAddress.flatBuildingName) &&
        Objects.equals(this.locality, brandDetailsResponseAddress.locality) &&
        Objects.equals(this.city, brandDetailsResponseAddress.city) &&
        Objects.equals(this.pincode, brandDetailsResponseAddress.pincode) &&
        Objects.equals(this.state, brandDetailsResponseAddress.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, flatBuildingName, locality, city, pincode, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BrandDetailsResponseAddress {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    flatBuildingName: ").append(toIndentedString(flatBuildingName)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

