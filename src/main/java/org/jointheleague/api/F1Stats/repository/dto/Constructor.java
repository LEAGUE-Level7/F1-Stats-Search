package org.jointheleague.api.F1Stats.repository.dto;

import java.util.HashMap;
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
"constructorId",
"url",
"name",
"nationality"
})
@Generated("jsonschema2pojo")
public class Constructor {

@JsonProperty("constructorId")
private String constructorId;
@JsonProperty("url")
private String url;
@JsonProperty("name")
private String name;
@JsonProperty("nationality")
private String nationality;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("constructorId")
public String getConstructorId() {
return constructorId;
}

@JsonProperty("constructorId")
public void setConstructorId(String constructorId) {
this.constructorId = constructorId;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("nationality")
public String getNationality() {
return nationality;
}

@JsonProperty("nationality")
public void setNationality(String nationality) {
this.nationality = nationality;
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
