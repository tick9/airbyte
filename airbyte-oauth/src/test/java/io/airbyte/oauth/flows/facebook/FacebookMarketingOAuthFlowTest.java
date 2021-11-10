/*
 * Copyright (c) 2021 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.oauth.flows.facebook;

import com.fasterxml.jackson.databind.JsonNode;
import io.airbyte.commons.json.Jsons;
import io.airbyte.oauth.BaseOAuthFlow;
import io.airbyte.oauth.flows.BaseOAuthFlowTest;
import java.util.List;
import java.util.Map;

public class FacebookMarketingOAuthFlowTest extends BaseOAuthFlowTest {

  @Override
  protected BaseOAuthFlow getOAuthFlow() {
    return new FacebookMarketingOAuthFlow(getConfigRepository(), getHttpClient(), this::getConstantState);
  }

  @Override
  protected String getExpectedConsentUrl() {
    return "https://www.facebook.com/v12.0/dialog/oauth?client_id=test_client_id&redirect_uri=https%3A%2F%2Fairbyte.io&state=state&scope=ads_management%2Cads_read%2Cread_insights";
  }

  @Override
  protected List<String> getExpectedOutputPath() {
    return List.of();
  }

  @Override
  protected Map<String, String> getExpectedOutput() {
    return Map.of(
        "access_token", "access_token_response",
        "client_id", Jsons.SECRET_MASK,
        "client_secret", Jsons.SECRET_MASK);
  }

  @Override
  protected JsonNode getOutputOAuthSpecification() {
    return Jsons.jsonNode(Map.of(
        "access_token", Map.of("type", "String"),
        "client_id", Map.of("type", "String")));
  }

  @Override
  protected Map<String, String> getExpectedFilteredOutput() {
    return Map.of(
        "access_token", "access_token_response",
        "client_id", Jsons.SECRET_MASK);
  }

}
