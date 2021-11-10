/*
 * Copyright (c) 2021 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.oauth.flows;

import com.fasterxml.jackson.databind.JsonNode;
import io.airbyte.commons.json.Jsons;
import io.airbyte.oauth.BaseOAuthFlow;
import java.util.List;
import java.util.Map;

public class SurveymonkeyOAuthFlowTest extends BaseOAuthFlowTest {

  @Override
  protected BaseOAuthFlow getOAuthFlow() {
    return new SurveymonkeyOAuthFlow(getConfigRepository(), getHttpClient(), this::getConstantState);
  }

  @Override
  protected String getExpectedConsentUrl() {
    return "https://api.surveymonkey.com/oauth/authorize?client_id=test_client_id&redirect_uri=https%3A%2F%2Fairbyte.io&response_type=code&state=state";
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
