package com.allianz.ms.eventnotification.hello.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Preconditions;
import lombok.Value;

/**
 * Created by dmcloughlin on 05/01/2018.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegistrationEvent.PolicyAndEmailCombinationVerified.class,
                name = "policy-and-email-combination-verified")
})
public interface RegistrationEvent {

    @Value
    final class PolicyAndEmailCombinationVerified implements RegistrationEvent {

        private final String policyNumber;
        private final String email;
        private final String uuid;
        private final String timestamp;

        @JsonCreator
        public PolicyAndEmailCombinationVerified(String policyNumber, String email,
                                                 String uuid, String timestamp) {

            this.policyNumber = Preconditions.checkNotNull(policyNumber);
            this.email = Preconditions.checkNotNull(email);
            this.uuid = Preconditions.checkNotNull(uuid);
            this.timestamp = Preconditions.checkNotNull(timestamp);
        }
    }
}
