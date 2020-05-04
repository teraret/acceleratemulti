package resellerclub

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected
class Website {
    @JsonProperty("auth-userid")
    Integer AuthUserId
    @JsonProperty("api-key")
    String ApiKey
    @JsonProperty("no-of-records")
    Integer NoOfRecords
    @JsonProperty("page-no")
    Integer PageNo

    Website() {
    }

    Integer getAuthUserId() {
        return AuthUserId
    }

    void setAuthUserId(Integer authUserId) {
        AuthUserId = authUserId
    }

    String getApiKey() {
        return ApiKey
    }

    void setApiKey(String apiKey) {
        ApiKey = apiKey
    }

    Integer getNoOfRecords() {
        return NoOfRecords
    }

    void setNoOfRecords(Integer noOfRecords) {
        NoOfRecords = noOfRecords
    }

    Integer getPageNo() {
        return PageNo
    }

    void setPageNo(Integer pageNo) {
        PageNo = pageNo
    }
}
