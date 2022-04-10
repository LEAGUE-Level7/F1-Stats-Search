package org.jointheleague.api.F1Stats.repository.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"season",
"Constructors"
})
@Generated("jsonschema2pojo")
public class ConstructorTable {

@JsonProperty("season")
private String season;
@JsonProperty("Constructors")
private List<Constructor> constructors = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("season")
public String getSeason() {
return season;
}

@JsonProperty("season")
public void setSeason(String season) {
this.season = season;
}

@JsonProperty("Constructors")
public List<Constructor> getConstructors() {
return constructors;
}

@JsonProperty("Constructors")
public void setConstructors(List<Constructor> constructors) {
this.constructors = constructors;
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