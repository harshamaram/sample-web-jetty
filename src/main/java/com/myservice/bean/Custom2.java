package com.myservice.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dates"
})
public class Custom2 {

//    @JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("anotherDate")
	private Date anotherDate;
	
    @JsonProperty("dates")
    private List<Date> dates = new ArrayList<Date>();

    @JsonProperty("dates")
    public List<Date> getDates() {
        return dates;
    }

    @JsonProperty("dates")
    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    @JsonProperty("anotherDate")
    public Date getAnotherDate() {
		return anotherDate;
	}

    @JsonProperty("anotherDate")
	public void setAnotherDate(Date anotherDate) {
		this.anotherDate = anotherDate;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this).append("dates", dates).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dates).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Custom2) == false) {
            return false;
        }
        Custom2 rhs = ((Custom2) other);
        return new EqualsBuilder().append(dates, rhs.dates).isEquals();
    }

}
