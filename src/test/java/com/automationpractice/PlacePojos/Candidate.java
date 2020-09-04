
package com.automationpractice.PlacePojos;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "formatted_address",
    "geometry",
    "name",
    "opening_hours",
    "rating"
})
public class Candidate {

    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("name")
    private String name;
    @JsonProperty("opening_hours")
    private OpeningHours openingHours;
    @JsonProperty("rating")
    private Double rating;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Candidate() {
    }

    /**
     * 
     * @param formattedAddress
     * @param name
     * @param rating
     * @param geometry
     * @param openingHours
     */
    public Candidate(String formattedAddress, Geometry geometry, String name, OpeningHours openingHours, Double rating) {
        super();
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
        this.name = name;
        this.openingHours = openingHours;
        this.rating = rating;
    }

    @JsonProperty("formatted_address")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("formatted_address")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("opening_hours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    @JsonProperty("opening_hours")
    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
